package com.example.ascendion.dto;

public class ClickRequest {
    private int count;
    private String name;

    public ClickRequest() {}

    public ClickRequest(int count, String name) {
        this.count = count;
        this.name = name;
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