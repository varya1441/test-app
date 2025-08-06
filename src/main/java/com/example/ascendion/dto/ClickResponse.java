package com.example.ascendion.dto;

public class ClickResponse {
    private String message;
    private int count;
    private String name;

    public ClickResponse(String message, int count, String name) {
        this.message = message;
        this.count = count;
        this.name = name;
    }

    public ClickResponse() {}

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
} 