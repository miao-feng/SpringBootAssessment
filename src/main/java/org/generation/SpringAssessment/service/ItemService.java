package org.generation.SpringAssessment.service;

import org.generation.SpringAssessment.repository.entity.Item;
import java.util.*;

public interface ItemService {

    Item save(Item item);

    void delete(int ItemId);

    List<Item> all();

    Item findById(int itemId);

}
