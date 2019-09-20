package io.nk.unittestingwithjunitmockito.controller;

import io.nk.unittestingwithjunitmockito.model.Item;
import io.nk.unittestingwithjunitmockito.service.BusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    BusinessService businessService;



    @Test
    public void getDummyItem() throws Exception {

        //call Get url="/dummy-item" application/json
        RequestBuilder request= MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        //Other way to Verify the new Item(1, "Ball", 10,100) with  content().string()
        MvcResult result=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        //Other way to Verify the new Item(1, "Ball", 10,100) with  content().json()
        MvcResult result1=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }

    @Test
    public void getDummyItemFromBusinessService() throws Exception {
        when(businessService.retriveHardCodedItem()).thenReturn(new Item(1, "Ball", 10,100));

        //call Get url="/dummy-item" application/json
        RequestBuilder request= MockMvcRequestBuilders
                .get("/dummy-item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        //Other way to Verify the new Item(1, "Ball", 10,100) with  content().string()
        MvcResult result=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        //Other way to Verify the new Item(1, "Ball", 10,100) with  content().json()
        MvcResult result1=mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }

}