package com.coffee_machine.task.service;

import com.coffee_machine.task.model.CoffeeMachine;
import com.coffee_machine.task.repository.CoffeeMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CoffeeMachineFactory {

    private final CoffeeMachineRepository coffeeMachineRepository;

    private CoffeeMachine coffeeMachine;

    public CoffeeMachine getCoffeeMachine() {
        if (Objects.isNull(coffeeMachine)) {
            coffeeMachine = coffeeMachineRepository.findAll().get(0);
        }
        return coffeeMachine;
    }
}
