package io.nk.unittestingwithjunitmockito.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getMessageTest() throws Exception {

        //call Get url="/hello" application/json
        RequestBuilder request= MockMvcRequestBuilders
                .get("/hello")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result=mockMvc.perform(request).andReturn();

        //Verify "Hello world"
        String expectedResponse="Hello World";
        String actualResponse=result.getResponse().getContentAsString();
        assertEquals(expectedResponse, actualResponse);

        //Other way to Verify "Hello World"
        MvcResult result1=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"))
                .andReturn();
    }

    @After
    public void tearDown() throws Exception {
    }
}