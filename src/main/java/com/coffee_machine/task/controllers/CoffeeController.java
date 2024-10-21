package com.coffee_machine.task.controllers;

import com.coffee_machine.task.dto.CoffeeDto;
import com.coffee_machine.task.enums.StandardCoffeeType;
import com.coffee_machine.task.service.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/coffee")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Operation(summary = "Prepare coffee")
    @PostMapping("/prepare")
    public ResponseEntity<String> prepareCoffee(@RequestBody String coffeeName) {
        try {
            return ResponseEntity.ok(coffeeService.prepareCoffee(coffeeName));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Add new recipe")
    @PostMapping("/add")
    public ResponseEntity<String> addCoffee(@RequestBody CoffeeDto coffeeDto) {
        try {
            return ResponseEntity.ok(coffeeService.addCoffee(coffeeDto));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
