package com.coffee_machine.task.controllers;

import com.coffee_machine.task.repository.CoffeeMachineRepository;
import com.coffee_machine.task.repository.CoffeeRepository;
import com.coffee_machine.task.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DummyController {

    private final CoffeeMachineRepository coffeeMachineRepository;
    private final CoffeeRepository coffeeRepository;
    private final OrderRepository orderRepository;

    @GetMapping
    public void getAllMachines() {
        coffeeMachineRepository.findAll();
    }
}
