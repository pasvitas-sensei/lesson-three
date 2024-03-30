package ru.pasvitas.teaching.lessonThree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pasvitas.teaching.lessonThree.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
