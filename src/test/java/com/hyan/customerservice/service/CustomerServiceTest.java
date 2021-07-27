package com.hyan.customerservice.service;

import com.hyan.customerservice.api.request.CustomerRequest;
import com.hyan.customerservice.entity.Customer;
import com.hyan.customerservice.repository.CustomerRepository;
import com.hyan.customerservice.stub.CustomerRequestStub;
import com.hyan.customerservice.stub.CustomerStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;


    @Test
    public void getCustomerTestReturnSuccess() {
        Customer expected = CustomerStub.create();
        when(customerRepository.findByEmail(Mockito.anyString())).thenReturn(Mono.just(expected));

        Customer customer = customerService.findByEmail("teste@teste.com").block();

        assertNotNull(customer);
        assertEquals(expected.getEmail(), customer.getEmail());


    }

    @Test(expected = ResponseStatusException.class)
    public void getCustomerNotFoundAssociateFindByEmail() {
        Mockito.when(customerRepository.findByEmail(Mockito.anyString())).thenReturn(Mono.empty());
        customerService.findByEmail("teste@email.com").block();

    }

    @Test(expected = ResponseStatusException.class)
    public void createCustomerWhenEmailHasDuplicated() {
        when(customerRepository.findByEmail("teste@email.com")).thenReturn(Mono.just(CustomerStub.create()));
       customerService.verifyEmailIsNotRegistered("teste@email.com").block();

    }


    @Test(expected = ResponseStatusException.class)
    public void updateCustomerWhenEmailNotFound() {
        CustomerRequest request = CustomerRequestStub.create();
        when(customerRepository.findByEmail("teste1@teste.com")).thenReturn(Mono.empty());
        customerService.update("teste1@teste.com", request).block();

    }

}
