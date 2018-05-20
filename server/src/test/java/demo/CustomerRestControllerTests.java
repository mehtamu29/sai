package demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class CustomerRestControllerTests {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRestControllerTests.class);

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void customerByIdShouldReturnJson () throws Exception {
        Mockito.when(customerRepository.findById(Mockito.anyLong()))
                .thenReturn(Optional.of(new Customer(1L, "first", "second", "mumehta@gmail.com")));

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/customers/1"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("@.id").value(1L))
                .andReturn();

        logger.info(result.getResponse().getContentAsString());
    }

    @Test
    public void reoShouldReturnAllCustomers() throws Exception{
        Mockito.when(customerRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Customer(1L, "first", "second", "mumehta@gmail.com"),
                        new Customer(2L, "first", "second", "mumehta@gmail.com")
                ));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/customers"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[0]id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("@.[1]id").value(2L));

    }

}
