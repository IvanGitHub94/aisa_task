package com.coffee_machine.task.model.listeners;

import com.coffee_machine.task.model.CoffeeMachine;
import com.coffee_machine.task.service.CoffeeService;
import jakarta.persistence.PostLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class StandardCoffeeLoader {

    @Lazy
    @Autowired
    private CoffeeService coffeeService;

    @PostLoad
    public void loadStandardCoffee(CoffeeMachine coffeeMachine) {
        coffeeMachine.getRecipes().addAll(coffeeService.findAllStandardRecipes());
    }


}
