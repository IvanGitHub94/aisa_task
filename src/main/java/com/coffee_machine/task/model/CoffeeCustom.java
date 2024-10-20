package com.coffee_machine.task.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "coffee_custom")
public class CoffeeCustom extends Coffee {

    @ManyToOne
    @JoinColumn(name = "coffee_machine_id")
    @EqualsAndHashCode.Exclude
    //@JsonIgnore
    private CoffeeMachine coffeeMachine;
}
