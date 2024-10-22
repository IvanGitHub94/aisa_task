package com.coffee_machine.task.service;

import com.coffee_machine.task.dto.CoffeeDto;
import com.coffee_machine.task.model.Coffee;

import java.util.Collection;

public interface CoffeeService {

    Collection<Coffee> findAllStandardRecipes();

    String prepareCoffee(String coffeeName);

    String addCoffee(CoffeeDto coffeeDto);
}
