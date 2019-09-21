package io.nk.unittestingwithjunitmockito.controller;

import io.nk.unittestingwithjunitmockito.model.Item;
import io.nk.unittestingwithjunitmockito.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item getDummyItem(){
        return new Item(1, "Ball", 10,100);
    }


    @GetMapping("/dummy-item-from-business-service")
    public Item getDummyItemFromBusinessService(){
        return businessService.retriveHardCodedItem();
    }

    @GetMapping("/all-item-from-database")
    public List<Item> retriveAllItems(){
        return businessService.retriveAllItems();
    }


}
