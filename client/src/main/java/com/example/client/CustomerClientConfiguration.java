package com.example.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerClientConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    CustomerClient client(RestTemplate restTemplate,
                          @Value("${customer-service.host}") String uri) {
        return new CustomerClientImpl(restTemplate, uri);
    }
}