package com.example.ascendion.controller;

import com.example.ascendion.dto.ClickRequest;
import com.example.ascendion.dto.ClickResponse;
import com.example.ascendion.service.AscendionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AscendionControllerTest {

    @Mock
    private AscendionService ascendionService;

    @InjectMocks
    private AscendionController ascendionController;

    @Test
    void testHelloEndpoint() {
        String response = ascendionController.hello();
        assertEquals("Hello, World!", response);
    }

    @Test
    void testHandleClickSuccess() {
        ClickRequest request = new ClickRequest(5, "John");
        ClickResponse expectedResponse = new ClickResponse("Hello John! You have clicked 5 times.", 5, "John");

        when(ascendionService.handleClick(any(ClickRequest.class))).thenReturn(expectedResponse);

        ResponseEntity<?> responseEntity = ascendionController.handleClick(request);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());
    }

    @Test
    void testHandleClickWithInvalidName() {
        ClickRequest request = new ClickRequest(1, "J0hn");

        when(ascendionService.handleClick(any(ClickRequest.class)))
                .thenThrow(new IllegalArgumentException("Name should only contain letters"));

        ResponseEntity<?> responseEntity = ascendionController.handleClick(request);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        Map<?, ?> errorBody = (Map<?, ?>) responseEntity.getBody();
        assertEquals("Name should only contain letters", errorBody.get("error"));
    }
}
