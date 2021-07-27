package com.hyan.customerservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "customers")
public class Customer {


    @Id
    private String id;
    private String email;
    private String name;
    private Integer age;
    private LocalDate createdAt;


    public Customer(String email, String name, Integer age, LocalDate createdAt) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.createdAt = createdAt;
    }

    public Customer() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", createdAt=" + createdAt +
                '}';
    }
}
