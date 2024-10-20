package com.coffee_machine.task.model;

import com.coffee_machine.task.model.listeners.StandardCoffeeLoader;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
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

    @OneToMany
    private List<Coffee> recipesStandard;

    @OneToMany(mappedBy = "coffeeMachine")
    private List<CoffeeCustom> recipesCustom;

    @OneToMany(mappedBy = "coffeeMachine")
    private List<Order> orderList;

    public Integer getWaterMl() {
        return waterMl;
    }

    public void setWaterMl(Integer waterMl) {
        this.waterMl = waterMl;
    }

    public Integer getMilkMl() {
        return milkMl;
    }

    public void setMilkMl(Integer milkMl) {
        this.milkMl = milkMl;
    }

    public Integer getCoffeeGrams() {
        return coffeeGrams;
    }

    public void setCoffeeGrams(Integer coffeeGrams) {
        this.coffeeGrams = coffeeGrams;
    }

    public Integer getTrashGrams() {
        return trashGrams;
    }

    public void setTrashGrams(Integer trashGrams) {
        this.trashGrams = trashGrams;
    }

    public List<CoffeeCustom> getRecipesCustom() {
        return recipesCustom;
    }

    public void setRecipesCustom(List<CoffeeCustom> recipesCustom) {
        this.recipesCustom = recipesCustom;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Coffee> getRecipesStandard() {
        return recipesStandard;
    }

    public void setRecipesStandard(List<Coffee> recipesStandard) {
        this.recipesStandard = recipesStandard;
    }
}
