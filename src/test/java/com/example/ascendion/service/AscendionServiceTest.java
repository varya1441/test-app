package com.example.ascendion.service;

import com.example.ascendion.dto.ClickRequest;
import com.example.ascendion.dto.ClickResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AscendionServiceTest {

    private AscendionServiceImpl ascendionService;

    @BeforeEach
    void setUp() {
        ascendionService = new AscendionServiceImpl();
    }

    @Test
    void testHandleClickWithValidName() {
        ClickRequest request = new ClickRequest(5, "Jon");
        ClickResponse response = ascendionService.handleClick(request);

        assertEquals("Hello Jon! You have clicked 5 times.", response.getMessage());
        assertEquals(5, response.getCount());
        assertEquals("Jon", response.getName());
    }

    @Test
    void testHandleClickWithValidNameWithSpaces() {
        ClickRequest request = new ClickRequest(3, "Jon Second");
        ClickResponse response = ascendionService.handleClick(request);

        assertEquals("Hello Jon Second! You have clicked 3 times.", response.getMessage());
        assertEquals(3, response.getCount());
        assertEquals("Jon Second", response.getName());
    }

    @Test
    void testHandleClickWithNullName() {
        ClickRequest request = new ClickRequest(1, null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ascendionService.handleClick(request);
        });

        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    void testHandleClickWithEmptyName() {
        ClickRequest request = new ClickRequest(1, "");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ascendionService.handleClick(request);
        });

        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    void testHandleClickWithWhitespaceName() {
        ClickRequest request = new ClickRequest(1, "   ");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ascendionService.handleClick(request);
        });

        assertEquals("Name cannot be empty", exception.getMessage());
    }

    @Test
    void testHandleClickWithShortName() {
        ClickRequest request = new ClickRequest(1, "A");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ascendionService.handleClick(request);
        });

        assertEquals("Name should be at least 2 characters long", exception.getMessage());
    }

    @Test
    void testHandleClickWithNameContainingNumbers() {
        ClickRequest request = new ClickRequest(1, "John123");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ascendionService.handleClick(request);
        });

        assertEquals("Name should only contain letters", exception.getMessage());
    }

    @Test
    void testHandleClickWithNameContainingSpecialCharacters() {
        ClickRequest request = new ClickRequest(1, "Jon@Second");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ascendionService.handleClick(request);
        });

        assertEquals("Name should only contain letters", exception.getMessage());
    }

    @Test
    void testHandleClickWithNameContainingHyphens() {
        ClickRequest request = new ClickRequest(1, "Jon-Second");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ascendionService.handleClick(request);
        });

        assertEquals("Name should only contain letters", exception.getMessage());
    }
} 