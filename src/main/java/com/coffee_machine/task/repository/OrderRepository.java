package com.coffee_machine.task.repository;

import com.coffee_machine.task.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
