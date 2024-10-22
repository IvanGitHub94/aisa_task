package com.coffee_machine.task.service;

import com.coffee_machine.task.dto.IngredientDto;
import com.coffee_machine.task.model.CoffeeMachine;
import com.coffee_machine.task.repository.CoffeeMachineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService{

    private final CoffeeMachineRepository coffeeMachineRepository;

    @Override
    public String addIngredient(IngredientDto ingredientDto/*, String coffeeMachineUUID*/) {

        CoffeeMachine coffeeMachine = coffeeMachineRepository.findAll().get(0); // TODO сделать по айди машины

        Map<String, Consumer<Integer>> setters = new HashMap<>();
        Map<String, Supplier<Integer>> getters = new HashMap<>();

        switch (ingredientDto.ingredientName()) {
            case "water" -> {
                getters.put("water", coffeeMachine::getWaterMl);
                setters.put("water", coffeeMachine::setWaterMl);
            }
            case "milk" -> {
                getters.put("milk", coffeeMachine::getMilkMl);
                setters.put("milk", coffeeMachine::setMilkMl);
            }
            case "coffee" -> {
                getters.put("coffee", coffeeMachine::getCoffeeGrams);
                setters.put("coffee", coffeeMachine::setCoffeeGrams);
            }
            default -> throw new IllegalArgumentException("Unknown ingredient");
        }
        setIngredient(ingredientDto.ingredientName(), getIngredient(ingredientDto.ingredientName(), getters) + ingredientDto.amount(), setters);

        coffeeMachineRepository.save(coffeeMachine);

        return String.format("%s added", ingredientDto.ingredientName());
    }

    public Integer getIngredient(String ingredient, Map<String, Supplier<Integer>> getters) {
        Supplier<Integer> getter = getters.get(ingredient);
        return getter.get();
    }

    public void setIngredient(String ingredient, Integer value, Map<String, Consumer<Integer>> setters) {
        Consumer<Integer> setter = setters.get(ingredient);
        setter.accept(value);
    }

    @Override
    public String removeTrash() {
        CoffeeMachine coffeeMachine = coffeeMachineRepository.findAll().get(0); // TODO сделать по айди машины
        coffeeMachine.setTrashGrams(0);
        coffeeMachineRepository.save(coffeeMachine);
        return "Trash removed!";
    }
}
