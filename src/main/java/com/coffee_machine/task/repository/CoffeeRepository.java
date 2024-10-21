package com.coffee_machine.task.repository;

import com.coffee_machine.task.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    List<Coffee> findByRecipeNameIn(List<String> recipeNames);

    Optional<Coffee> findByRecipeName(String recipeName);
}
