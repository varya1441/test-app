package com.example.ascendion.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClickRequestTest {

    @Test
    void testDefaultConstructor() {
        ClickRequest request = new ClickRequest();
        
        assertEquals(0, request.getCount());
        assertNull(request.getName());
    }

    @Test
    void testParameterizedConstructor() {
        ClickRequest request = new ClickRequest(5, "John");
        
        assertEquals(5, request.getCount());
        assertEquals("John", request.getName());
    }

    @Test
    void testSettersAndGetters() {
        ClickRequest request = new ClickRequest();
        
        request.setCount(10);
        request.setName("Jane");
        
        assertEquals(10, request.getCount());
        assertEquals("Jane", request.getName());
    }

    @Test
    void testSetCount() {
        ClickRequest request = new ClickRequest();
        request.setCount(15);
        assertEquals(15, request.getCount());
    }

    @Test
    void testSetName() {
        ClickRequest request = new ClickRequest();
        request.setName("Alice");
        assertEquals("Alice", request.getName());
    }
} 