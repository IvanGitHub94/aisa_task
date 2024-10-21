package com.coffee_machine.task.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coffee_machine_id")
    private CoffeeMachine coffeeMachine;

    @OneToOne
    @JoinColumn(name = "coffee_id")
    private Coffee coffee;

    @Column(name = "create_date")
    private LocalDateTime createDate;
}
