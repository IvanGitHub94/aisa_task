package com.coffee_machine.task.service;

import com.coffee_machine.task.enums.StandardCoffeeType;
import com.coffee_machine.task.model.Coffee;
import com.coffee_machine.task.repository.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    @Override
    public Collection<Coffee> findAllStandardRecipes() {
        return coffeeRepository.findByRecipeNameIn(getStandardCoffeeNames());
    }

    private List<String> getStandardCoffeeNames() {
        return Arrays.stream(StandardCoffeeType.values()).map(StandardCoffeeType::getName).collect(Collectors.toList());
    }
}
