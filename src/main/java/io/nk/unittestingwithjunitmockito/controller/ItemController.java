package io.nk.unittestingwithjunitmockito.controller;

import io.nk.unittestingwithjunitmockito.model.Item;
import io.nk.unittestingwithjunitmockito.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public ResponseEntity<Item> getDummyItem() {
        Item item = new Item(1, "Ball", 10, 100);
        ResponseEntity response = new ResponseEntity<>(item, HttpStatus.OK);
        return response;
    }

    @GetMapping("/dummy-item-from-business-service")
    public ResponseEntity<Item> getDummyItemFromBusinessService() {
        Item item = businessService.retriveHardCodedItem();
        ResponseEntity entity = new ResponseEntity(item, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/all-item-from-database")
    public ResponseEntity<List<Item>> retriveAllItems() {
        List<Item> items = businessService.retriveAllItems();
        ResponseEntity response = new ResponseEntity(items, HttpStatus.OK);
        return response;
    }

    @PostMapping("/add-item-to-database1")
    public ResponseEntity<Object> saveItem1(@RequestBody Item item) {
        Item item1 = businessService.addItem(item);
        //Created
        // /add-item-to-database/{id} item1.getId()

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(item1.getId()).toUri();

        HttpHeaders headers=new HttpHeaders();
        headers.setLocation(location);

        ResponseEntity entity = new ResponseEntity(headers,HttpStatus.CREATED);
        return entity;
    }


    //Another way to use @PostMapping with out the location
    @PostMapping("/add-item-to-database")
    public ResponseEntity<Item> saveItem(@RequestBody Item item) {
        Item item1 = businessService.addItem(item);
        ResponseEntity entity = new ResponseEntity(item1, HttpStatus.CREATED);
        return entity;
    }


}
