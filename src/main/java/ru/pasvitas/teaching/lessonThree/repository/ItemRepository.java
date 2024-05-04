package ru.pasvitas.teaching.lessonThree.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pasvitas.teaching.lessonThree.model.Item;
import ru.pasvitas.teaching.lessonThree.model.ItemWithCount;

public interface ItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "SELECT i.id, i.name, i.price, count(*) FROM items i RIGHT JOIN orders o ON o.item_id = i.id GROUP BY i.id, i.name, i.price", nativeQuery = true)
    List<ItemWithCount> findTopItems();

}
