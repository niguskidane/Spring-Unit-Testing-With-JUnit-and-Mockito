package io.nk.unittestingwithjunitmockito.service;

import io.nk.unittestingwithjunitmockito.model.Item;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    public Item retriveHardCodedItem(){
        return new Item(1, "Ball", 10,100);
    }
}
