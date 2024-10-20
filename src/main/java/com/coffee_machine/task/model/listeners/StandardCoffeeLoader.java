package com.coffee_machine.task.model.listeners;

import com.coffee_machine.task.model.CoffeeMachine;
import com.coffee_machine.task.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StandardCoffeeLoader {

    private final CoffeeRepository coffeeRepository;

    public void loadStandardCoffee(CoffeeMachine coffeeMachine) {
        coffeeMachine.setRecipesStandard(coffeeRepository.findAll());
    }
}
