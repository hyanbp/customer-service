package com.hyan.customerservice.api;

import com.hyan.customerservice.api.request.CustomerRequest;
import com.hyan.customerservice.entity.Customer;
import com.hyan.customerservice.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/customers")
@Validated
public class CustomerApi {

    private Logger logger = LoggerFactory.getLogger(CustomerApi.class);
    private CustomerService customerService;

    public CustomerApi(CustomerService customerService) {
        this.customerService = customerService;

    }


    @PostMapping
    @ApiOperation(value = "Criação de cliente.")
    public Mono<Customer> create(@RequestBody @Validated CustomerRequest request){
        logger.info("Iniciando a criação de um cliente email [{}]: ", request.getEmail());

        return customerService.create(request);
    }

    @PutMapping("/{email}/customer")
    public Mono<Customer> updateAll(@PathVariable String email , @RequestBody CustomerRequest request){
        return customerService.update(email, request);
    }

    @GetMapping
    public Flux<Customer> findAll( @RequestParam(value = "page", defaultValue = "0") long page,
                                   @RequestParam(value = "size", defaultValue = "10") long size){
        return customerService.findAll(page, size);

    }


    @GetMapping("/{email}/customer")
    public Mono<Customer> findOne(@PathVariable String email){
        return customerService.findByEmail(email);
    }


}
