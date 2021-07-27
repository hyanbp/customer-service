package com.hyan.customerservice.repository;

import com.hyan.customerservice.entity.Customer;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

    @Query("{ 'email': ?0}")
    Mono<Customer> findByEmail(String email);



}
