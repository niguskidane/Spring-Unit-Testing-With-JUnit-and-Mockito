package io.nk.unittestingwithjunitmockito.controller;

import io.nk.unittestingwithjunitmockito.model.Item;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @GetMapping("/dummy-item")
    public Item getDummyItem(){
        return new Item(1, "Ball", 10,100);
    }
}
