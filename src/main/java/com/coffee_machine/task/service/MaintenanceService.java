package com.coffee_machine.task.service;

import com.coffee_machine.task.dto.IngredientDto;

public interface MaintenanceService {

    String addIngredient(IngredientDto ingredientDto/*, String coffeeMachineUUID*/);

    String removeTrash();
}
