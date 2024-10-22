package com.coffee_machine.task.service;

import com.coffee_machine.task.model.Coffee;
import com.coffee_machine.task.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StatServiceImpl implements StatService {

    private final OrderRepository orderRepository;

    @Override
    public String getPopular() {
        return orderRepository.getMostPopularCoffee().getRecipeName();
    }
}
