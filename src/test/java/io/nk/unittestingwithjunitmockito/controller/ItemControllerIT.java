package io.nk.unittestingwithjunitmockito.controller;

import io.nk.unittestingwithjunitmockito.data.ItemRepository;
import io.nk.unittestingwithjunitmockito.model.Item;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

    @Autowired
    private TestRestTemplate restTemplate;

    //if we don't want to not depend on the data in the DB we can Mock the Repository

    @MockBean
    ItemRepository repository;

    @Test
    public void contestLoad() throws JSONException {

        when(repository.findAll()).thenReturn(Arrays.asList(new Item(1001, "Item1", 10, 20 ),
                                                           new Item(1002, "Item2", 5, 10),
                                                            new Item(1003, "Item3", 15, 2)));

        String response = this.restTemplate.getForObject("/all-item-from-database", String.class);
        JSONAssert.assertEquals("[{id:1001},{id:1002},{id:1003}]", response, false);

    }
}
