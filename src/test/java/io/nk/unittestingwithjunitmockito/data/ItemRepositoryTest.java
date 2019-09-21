package io.nk.unittestingwithjunitmockito.data;

import io.nk.unittestingwithjunitmockito.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository repository;


    @Test
    public void findALl(){
        List<Item> itemList=repository.findAll();
        assertEquals(3,itemList.size() );
    }
}