package com.example.client;

import demo.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@Component
public class CustomerClientImpl implements CustomerClient{

    private final RestTemplate restTemplate;
    @Value("${customer-server-uri}")
    private String uri;

    public CustomerClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Collection<Customer> getCustomers() {
        ParameterizedTypeReference<Collection<Customer>>  ptr = new ParameterizedTypeReference<Collection<Customer>>() {};
        return restTemplate.exchange(this.uri + "/customers", HttpMethod.GET, null, ptr)
                .getBody();
    }
}
