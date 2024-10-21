package com.coffee_machine.task.model;

import com.coffee_machine.task.model.listeners.StandardCoffeeLoader;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coffee_machines")
@EntityListeners(StandardCoffeeLoader.class)
public class CoffeeMachine {

    @Id
    private Long id;

    @Column(name = "water_ml")
    private Integer waterMl;

    @Column(name = "milk_ml")
    private Integer milkMl;

    @Column(name = "coffee_grams")
    private Integer coffeeGrams;

    @Column(name = "trash_grams")
    private Integer trashGrams;

    @OneToMany(mappedBy = "coffeeMachine")
    private List<Coffee> recipes;

    @OneToMany(mappedBy = "coffeeMachine")
    private List<Order> orderList;
}
