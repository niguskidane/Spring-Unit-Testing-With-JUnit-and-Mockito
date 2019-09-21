package io.nk.unittestingwithjunitmockito.service;

import io.nk.unittestingwithjunitmockito.data.ItemRepository;
import io.nk.unittestingwithjunitmockito.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

  @InjectMocks
   ItemBusinessService businessService;

  @Mock
   ItemRepository repository;


    @Test
    public void retriveAllItems() {
    when(repository
            .findAll())
            .thenReturn(Arrays.asList(new Item(1, "Ball1", 10,10),
                                      new Item(2, "Ball2", 10,20)));

    List<Item> itemList=businessService.retriveAllItems();
    assertEquals(100, itemList.get(0).getValue());
    assertEquals(200, itemList.get(1).getValue());


    }




}