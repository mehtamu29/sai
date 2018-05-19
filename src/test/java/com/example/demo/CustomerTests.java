package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTests {
    @Test
    public void testNewCurtomerHasId(){
        Customer customer = new Customer();
        assertNotNull(customer);
    }
}
