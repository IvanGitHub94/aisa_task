package com.coffee_machine.task.controllers;

import com.coffee_machine.task.dto.IngredientDto;
import com.coffee_machine.task.service.MaintenanceService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceСontroller {

    private final MaintenanceService maintenanceService;

    @Operation(summary = "Coffee machine maintenance")
    @PostMapping("/addIngredient")
    public ResponseEntity<String> addIngredient(@RequestBody IngredientDto ingredientDto/*, String coffeeMachineUUID*/) {
        try {
            return ResponseEntity.ok(maintenanceService.addIngredient(ingredientDto/*, coffeeMachineUUID*/));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Operation(summary = "Clear trash container")
    @PostMapping("/removeTrash")
    public ResponseEntity<String> removeTrash() {
        try {
            return ResponseEntity.ok(maintenanceService.removeTrash());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
