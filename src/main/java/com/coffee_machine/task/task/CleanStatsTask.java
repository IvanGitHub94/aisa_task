package com.coffee_machine.task.task;

import com.coffee_machine.task.model.Order;
import com.coffee_machine.task.repository.OrderRepository;
import com.coffee_machine.task.values.Values;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CleanStatsTask {

    private final OrderRepository orderRepository;

    @Scheduled(cron = "*/20 * * * * *") // каждые 20 сек для целей тестирования
    public void process() {
        List<Order> allByCreateDateBefore = orderRepository.findAllByCreateDateBefore(LocalDateTime.now().minusYears(Values.ORDERS_SAVE_COUNT_YEARS));
        log.info("found {} orders to remove", allByCreateDateBefore.size());
        orderRepository.deleteAll(allByCreateDateBefore);
    }

}
