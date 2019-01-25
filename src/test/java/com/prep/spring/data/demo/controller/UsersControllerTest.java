package com.prep.spring.data.demo.controller;

import com.prep.spring.data.demo.repository.UserJpaRespository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
public class UsersControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;
    @MockBean
    UserJpaRespository userJpaRespository;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UsersController(userJpaRespository)).build();
    }

    @Test
    public void findAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/allString?test=kash&query=map")).andExpect(status().isOk());
    }
}