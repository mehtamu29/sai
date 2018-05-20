package com.example.client;

import demo.Customer;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@SpringBootTest(classes = CustomerClientApplication.class)
@RunWith(SpringRunner.class)
public class CustomerClientRestServiceServerTests {
    @Autowired
    private CustomerClient client;

    @Test
    public void customersShouldReturnAllCusts (){
        Collection<Customer> customers =  client.getCustomers();
        BDDAssertions.then(customers.size()).isEqualTo(2);
    }
}