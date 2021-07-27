package com.hyan.customerservice.service;

import com.hyan.customerservice.api.mapper.CustomerMapper;
import com.hyan.customerservice.api.request.CustomerRequest;
import com.hyan.customerservice.entity.Customer;
import com.hyan.customerservice.repository.CustomerRepository;
import com.mongodb.bulk.UpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Comparator;

@Service
public class
CustomerService {

    private final CustomerRepository customerRepository;


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Mono<Customer> create(CustomerRequest request) {
        return verifyEmailIsNotRegistered(request.getEmail())
                .flatMap(customer -> customerRepository.insert(new Customer(request.getEmail(), request.getName(), request.getAge(), LocalDate.now())));
    }

    public Mono<Customer> findByEmail(String email){
        return customerRepository.findByEmail(email)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Email não cadastrado.")));
    }

    public Flux<Customer> findAll(long page, long size){
        return customerRepository.findAll()
                .sort(Comparator.comparing(Customer::getCreatedAt).reversed())
                .skip(page * size).take(size);
    }


    public Mono<Boolean> verifyEmailIsNotRegistered(String email){
        return customerRepository.findByEmail(email)
                .hasElement()
                .filter(customer -> !customer)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Email ja cadastrado")));
    }

    public Mono<Customer> update(String emailParam ,CustomerRequest request){
        return customerRepository.findByEmail(emailParam)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Email não encontrado.")))
                .flatMap(customer -> upsert(CustomerMapper.to(customer, request)));
    }


    public Mono<Customer> upsert(Customer customer){
         verifyEmailIsNotRegistered(customer.getEmail());
         return customerRepository.save(customer);
    }

}
