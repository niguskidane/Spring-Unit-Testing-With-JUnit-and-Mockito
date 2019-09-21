package io.nk.unittestingwithjunitmockito.controller;

import io.nk.unittestingwithjunitmockito.model.Item;
import io.nk.unittestingwithjunitmockito.service.ItemBusinessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.print.attribute.standard.Media;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ItemBusinessService businessService;



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


    @Test
    public void saveItemToDatabase() throws Exception {

        RequestBuilder request=MockMvcRequestBuilders
                .post("/add-item-to-database")
                .accept(MediaType.APPLICATION_JSON).content("{\n" +
                        "\"id\": 1004,\n" +
                        "\"name\": \"Item4\",\n" +
                        "\"price\": 20,\n" +
                        "\"quantity\": 3,\n" +
                        "\"value\": 30\n" +
                        "}").contentType(MediaType.APPLICATION_JSON);

        MvcResult result=mockMvc
                .perform(request)
                .andExpect(status().isCreated())
                .andReturn();
    }

}