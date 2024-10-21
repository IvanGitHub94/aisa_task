package com.coffee_machine.task.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "recipe_name")
    private String recipeName;

    @Column(name = "water_ml", nullable = false)
    private Integer waterMl;

    @Column(name = "milk_ml", nullable = false)
    private Integer milkMl;

    @Column(name = "coffee_grams", nullable = false)
    private Integer coffeeGrams;

    @ManyToOne
    @JoinColumn(name = "coffee_machine_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private CoffeeMachine coffeeMachine;
}
