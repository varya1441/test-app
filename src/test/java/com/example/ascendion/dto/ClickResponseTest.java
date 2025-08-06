package com.example.ascendion.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClickResponseTest {

    @Test
    void testDefaultConstructor() {
        ClickResponse response = new ClickResponse();
        
        assertNull(response.getMessage());
        assertEquals(0, response.getCount());
        assertNull(response.getName());
    }

    @Test
    void testParameterizedConstructor() {
        ClickResponse response = new ClickResponse("Hello John!", 5, "John");
        
        assertEquals("Hello John!", response.getMessage());
        assertEquals(5, response.getCount());
        assertEquals("John", response.getName());
    }

    @Test
    void testSettersAndGetters() {
        ClickResponse response = new ClickResponse();
        
        response.setMessage("Hello Jane!");
        response.setCount(10);
        response.setName("Jane");
        
        assertEquals("Hello Jane!", response.getMessage());
        assertEquals(10, response.getCount());
        assertEquals("Jane", response.getName());
    }

    @Test
    void testSetMessage() {
        ClickResponse response = new ClickResponse();
        response.setMessage("Test message");
        assertEquals("Test message", response.getMessage());
    }

    @Test
    void testSetCount() {
        ClickResponse response = new ClickResponse();
        response.setCount(20);
        assertEquals(20, response.getCount());
    }

    @Test
    void testSetName() {
        ClickResponse response = new ClickResponse();
        response.setName("Bob");
        assertEquals("Bob", response.getName());
    }
} 