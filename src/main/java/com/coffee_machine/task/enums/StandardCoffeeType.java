package com.coffee_machine.task.enums;

public enum StandardCoffeeType {

    AMERICANO("americano"),
    CAPPUCCINO("cappuccino"),
    ESPRESSO("espresso");

    private final String name;


    StandardCoffeeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
