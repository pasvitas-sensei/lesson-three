package ru.pasvitas.teaching.lessonThree.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "items")
@Entity
@ToString
public class Item {

    @Id
    @GeneratedValue(generator = "item_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    private String name;

    private int price;

}
