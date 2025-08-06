package com.example.ascendion.controller;

import com.example.ascendion.dto.ClickRequest;
import com.example.ascendion.dto.ClickResponse;
import com.example.ascendion.service.AscendionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AscendionController {

    private final AscendionService ascendionService;

    public AscendionController(AscendionService ascendionService) {
        this.ascendionService = ascendionService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/api/click")
    public ResponseEntity<?> handleClick(@RequestBody ClickRequest clickRequest) {
        try {
            ClickResponse result = ascendionService.handleClick(clickRequest);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
}
