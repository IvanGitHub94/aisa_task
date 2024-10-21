package com.coffee_machine.task.service;

import com.coffee_machine.task.dto.CoffeeDto;
import com.coffee_machine.task.enums.StandardCoffeeType;
import com.coffee_machine.task.model.Coffee;
import com.coffee_machine.task.model.CoffeeMachine;
import com.coffee_machine.task.model.Order;
import com.coffee_machine.task.repository.CoffeeMachineRepository;
import com.coffee_machine.task.repository.CoffeeRepository;
import com.coffee_machine.task.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

    @Value("${trash.limit}")
    private int trashLimit;

    @Value("${trash.ratio}")
    private double trashRatio;

    private final CoffeeMachineFactory coffeeMachineFactory;

    private final CoffeeRepository coffeeRepository;

    private final CoffeeMachineRepository coffeeMachineRepository;

    private final OrderRepository orderRepository;

    @Override
    public Collection<Coffee> findAllStandardRecipes() {
        return coffeeRepository.findByRecipeNameIn(getStandardCoffeeNames());
    }

    @Override
    public String prepareCoffee(String coffeeName) {
        CoffeeMachine coffeeMachine = coffeeMachineFactory.getCoffeeMachine();
        Coffee coffee = coffeeRepository.findByRecipeName(coffeeName).orElseThrow(() -> new IllegalArgumentException("Invalid coffee name."));
        if (coffeeMachine.getWaterMl() < coffee.getWaterMl()) {
            throw new IllegalArgumentException("Please, add some water.");
        }
        if (coffeeMachine.getCoffeeGrams() < coffee.getCoffeeGrams()) {
            throw new IllegalArgumentException("Please, add some coffee.");
        }
        if (coffeeMachine.getMilkMl() < coffee.getMilkMl()) {
            throw new IllegalArgumentException("Please, add some milk.");
        }
        if (coffeeMachine.getTrashGrams() >= trashLimit - coffee.getCoffeeGrams() * trashRatio) {
            throw new IllegalArgumentException("Please, clean trash container.");
        }

        coffeeMachine.setWaterMl(coffeeMachine.getWaterMl() - coffee.getWaterMl());
        coffeeMachine.setCoffeeGrams(coffeeMachine.getCoffeeGrams() - coffee.getCoffeeGrams());
        coffeeMachine.setMilkMl(coffeeMachine.getMilkMl() - coffee.getMilkMl());
        coffeeMachine.setTrashGrams(coffeeMachine.getTrashGrams() + (int) Math.round(coffee.getCoffeeGrams() * trashRatio));

        Order order = Order.builder()
                .coffee(coffee)
                .coffeeMachine(coffeeMachine)
                .createDate(LocalDateTime.now())
                .build();

        orderRepository.save(order);

        coffeeMachineRepository.save(coffeeMachine);

        return String.format("Your %s is ready", coffeeName);
    }

    @Override
    public String addCoffee(CoffeeDto coffeeDto) {
        // TODO пока без учета удаления из бд
        // TODO валидировать кофе дто
        long customRecipesCount = coffeeRepository.countByCoffeeMachineIsNotNull();

        Coffee coffee = Coffee.builder()
                .recipeName("custom" + ++customRecipesCount)
                .waterMl(coffeeDto.waterMl())
                .milkMl(coffeeDto.milkMl())
                .coffeeGrams(coffeeDto.coffeeGrams())
                .coffeeMachine(coffeeMachineFactory.getCoffeeMachine())
                .build();

        coffeeRepository.save(coffee);

        return String.format("%s saved", coffee.getRecipeName());
    }

    private List<String> getStandardCoffeeNames() {
        return Arrays.stream(StandardCoffeeType.values()).map(StandardCoffeeType::getName).collect(Collectors.toList());
    }
}
