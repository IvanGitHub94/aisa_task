package com.coffee_machine.task.model;

import com.coffee_machine.task.model.listeners.StandardCoffeeLoader;
import com.coffee_machine.task.values.Values;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "coffee_machines")
@EntityListeners(StandardCoffeeLoader.class)
public class CoffeeMachine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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

    public void setWaterMl(Integer waterMl) {
        if (waterMl > Values.WATER_LIMIT) {
            throw new IllegalArgumentException("Water over limit!");
        }
        this.waterMl = waterMl;
    }

    public void setMilkMl(Integer milkMl) {
        if (milkMl > Values.MILK_LIMIT) {
            throw new IllegalArgumentException("Milk over limit!");
        }
        this.milkMl = milkMl;
    }

    public void setCoffeeGrams(Integer coffeeGrams) {
        if (coffeeGrams > Values.COFFEE_LIMIT) {
            throw new IllegalArgumentException("Coffee over limit!");
        }
        this.coffeeGrams = coffeeGrams;
    }

    public void setTrashGrams(Integer trashGrams) {
        this.trashGrams = trashGrams;
    }

    public void setRecipes(List<Coffee> recipes) {
        this.recipes = recipes;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
