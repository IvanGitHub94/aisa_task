package com.coffee_machine.task.controllers;

import com.coffee_machine.task.service.StatService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/stats")
public class StatsController {

    private final StatService statService;

    @Operation(summary = "Get most popular coffee")
    @GetMapping("/popular")
    public ResponseEntity<String> getPopular() {
        try {
            return ResponseEntity.ok(statService.getPopular());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
