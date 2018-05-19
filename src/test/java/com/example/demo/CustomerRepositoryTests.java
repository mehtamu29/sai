package com.example.demo;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void saveShouldMapCorrectly() throws Exception {
        Customer customer = new Customer(null, "first", "second", "mumehta@gmail.com");
        Customer cust = testEntityManager.persistAndFlush(customer);
        BDDAssertions.then(cust.getId()).isNotNull();
    }
}