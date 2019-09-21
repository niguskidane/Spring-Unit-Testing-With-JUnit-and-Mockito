package io.nk.unittestingwithjunitmockito.service;

import io.nk.unittestingwithjunitmockito.data.ItemRepository;
import io.nk.unittestingwithjunitmockito.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retriveHardCodedItem(){
        return new Item(1, "Ball", 10,100);
    }

    public List<Item> retriveAllItems(){

        List<Item> items=repository.findAll();
        for(Item i:items) {
            i.setValue(i.getQuantity() * i.getPrice());
        }
        return items;
    }
}
