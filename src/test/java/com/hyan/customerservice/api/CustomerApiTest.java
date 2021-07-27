package com.hyan.customerservice.api;

import com.hyan.customerservice.repository.CustomerRepository;
import com.hyan.customerservice.service.CustomerService;
import com.hyan.customerservice.stub.CustomerRequestStub;
import com.hyan.customerservice.stub.CustomerStub;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerApiTest {

    private WebTestClient webTestClient;

    @Mock
    private CustomerService customerService;

    @Before
    public void setUp() {
        webTestClient = WebTestClient
                .bindToController(new CustomerApi(customerService))
                .configureClient()
                .baseUrl("/v1/customers")
                .build();
    }

    @Test
    public void postCreateCustomerHavingValidContractAndReturnSuccess() {
        webTestClient.post()
                .syncBody(CustomerRequestStub.create())
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }


    @Test
    public void getCustomerHavingInvalidParametersReturnNotFound() {
        webTestClient.get()
                .uri("//customer")
                .exchange()
                .expectStatus()
                .isNotFound();
    }


}
