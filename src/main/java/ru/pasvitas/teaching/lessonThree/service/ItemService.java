package ru.pasvitas.teaching.lessonThree.service;

import java.util.List;
import java.util.Optional;
import ru.pasvitas.teaching.lessonThree.model.Item;

public interface ItemService {

    Item create(Item item);
    List<Item> getAllItems();
    Optional<Item> getItemById(Long id);
}
