package ru.pasvitas.teaching.lessonThree.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ItemWithCount extends Item {

    public ItemWithCount(Long id, String name, int price, long count) {
        super(id, name, price);
        this.count = count;
    }

    public long count;
}
