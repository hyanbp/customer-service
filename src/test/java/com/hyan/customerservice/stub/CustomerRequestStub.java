package com.hyan.customerservice.stub;

import com.hyan.customerservice.api.request.CustomerRequest;

public class CustomerRequestStub {

    public static CustomerRequest create(){
        return new CustomerRequest("teste","teste@teste.com",21);
    }
}
