package com.coffee_machine.task.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "coffee_standard")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "water_ml", nullable = false)
    private Integer waterMl;

    @Column(name = "milk_ml", nullable = false)
    private Integer milkMl;

    @Column(name = "coffee_grams", nullable = false)
    private Integer coffeeGrams;
}
