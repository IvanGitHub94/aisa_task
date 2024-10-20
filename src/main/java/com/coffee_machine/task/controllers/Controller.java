package com.coffee_machine.task.controllers;

import com.coffee_machine.task.repository.CoffeeMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {

    private final CoffeeMachineRepository coffeeMachineRepository;

    @GetMapping
    public void getAllMachines() {
        coffeeMachineRepository.findAll();
    }
}
