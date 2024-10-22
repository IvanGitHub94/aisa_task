package com.coffee_machine.task.repository;

import com.coffee_machine.task.model.Coffee;
import com.coffee_machine.task.model.CoffeeMachine;
import com.coffee_machine.task.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT c FROM Coffee c JOIN Order o ON c.id = o.coffee.id GROUP BY c.id ORDER BY COUNT(o.id) DESC LIMIT 1")
    Coffee getMostPopularCoffee();

    int countByCoffeeMachineAndCreateDateAfter(CoffeeMachine coffeeMachine, LocalDateTime createDate);

    List<Order> findAllByCreateDateBefore(LocalDateTime createDate);
}
