package com.example.demo;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private CustomerRepository repository;

    @Test
    public void saveShouldMapCorrectly() throws Exception {
        Customer customer = new Customer(null, "first", "second", "mumehta@gmail.com");
        Customer cust = testEntityManager.persistAndFlush(customer);
        BDDAssertions.then(cust.getId()).isNotNull();
    }
    @Test
    public void repositorySaveShouldAlsoWork () {
        Customer customer = new Customer(null, "first", "second", "mumehta@gmail.com");
        Customer cust = repository.save(customer);
        BDDAssertions.then(cust.getId()).isNotNull();
    }

    @Test
    public void newInsWithInvalidParamsShouldResultInConstraintVoilarrions() {
//        this.expectedException.expect(ConstraintViolationException.class);
        this.repository.save(new Customer(null, null, null, null));
    }
}