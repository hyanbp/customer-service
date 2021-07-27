package com.hyan.customerservice.stub;

import com.hyan.customerservice.entity.Customer;

import java.time.LocalDate;

public class CustomerStub {

    public static Customer create() {
        return new Customer("teste@teste.com","teste",21, LocalDate.now());
    }

}
