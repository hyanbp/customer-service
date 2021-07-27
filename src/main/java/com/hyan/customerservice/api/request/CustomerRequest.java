package com.hyan.customerservice.api.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerRequest {

    @NotEmpty(message = "Nome do cliente é obrigatório.")
    private String name;
    @NotEmpty(message = "Email do cliente é obrigatório.")
    private String email;
    @NotNull(message = "Idade do cliente é obrigatório.")
    private Integer age;


    public CustomerRequest(String name, String email, Integer age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public CustomerRequest() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
