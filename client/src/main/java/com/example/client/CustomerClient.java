package com.example.client;

import demo.Customer;

import java.util.Collection;

public interface CustomerClient {
    Collection<Customer> getCustomers();
}