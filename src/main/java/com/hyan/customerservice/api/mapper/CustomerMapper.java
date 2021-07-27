package com.hyan.customerservice.api.mapper;

import com.hyan.customerservice.api.request.CustomerRequest;
import com.hyan.customerservice.entity.Customer;

public class CustomerMapper {

    public static Customer to(Customer customer, CustomerRequest request) {
        customer.setAge(request.getAge());
        customer.setEmail(request.getEmail());
        customer.setName(request.getEmail());
        return customer;
    }
}
