package com.example.ascendion.service;

import com.example.ascendion.dto.ClickRequest;
import com.example.ascendion.dto.ClickResponse;
import org.springframework.stereotype.Service;

@Service
public class AscendionServiceImpl implements AscendionService {
    
    @Override
    public ClickResponse handleClick(ClickRequest clickRequest) {
        String name = clickRequest.getName();
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        
        if (name.length() < 2) {
            throw new IllegalArgumentException("Name should be at least 2 characters long");
        }
        
        if (!name.matches("^[a-zA-Z\\s]+$")) {
            throw new IllegalArgumentException("Name should only contain letters");
        }
        
        String message = String.format("Hello %s! You have clicked %d times.", 
                                     name, 
                                     clickRequest.getCount());
        return new ClickResponse(message, clickRequest.getCount(), name);
    }
}
