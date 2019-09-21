package io.nk.unittestingwithjunitmockito.data;

import io.nk.unittestingwithjunitmockito.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
