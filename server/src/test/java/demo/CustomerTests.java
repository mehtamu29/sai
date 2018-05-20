package demo;

import org.assertj.core.api.BDDAssertions;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CustomerTests {


    private Validator validator;

    @Before
    public void before() throws Throwable {
        LocalValidatorFactoryBean localValidatorFactoryBean  = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.afterPropertiesSet();
        validator = localValidatorFactoryBean.getValidator();

    }

    @Test
    public void newInsWithValidValuesShouldReturnARecord(){
        Customer customer = new Customer(1L, "first", "second", "mumehta@gmail.com");
        assertEquals(customer.getId(), Long.valueOf(1L));
        assertEquals(customer.getFirst(), "first");
        //hamcrest
        assertThat(customer.getFirst(), Matchers.is("first"));
        //asserttj
        BDDAssertions.then(customer.getFirst()).isEqualToIgnoringCase("first");
        BDDAssertions.then(customer.getId()).isNotNull();
    }
    @Test
    public void newInsWithInvalidConstraintsShouldProduceContraintViolations(){
        Customer customer = new Customer(null,null,null,null);
        Set<ConstraintViolation<Customer>> violations = validator.validate(customer);
        BDDAssertions.then(violations.size()).isEqualTo(3);
    }
}
