package com.example.ascendion.service;

import com.example.ascendion.dto.ClickRequest;
import com.example.ascendion.dto.ClickResponse;

public interface AscendionService {
    ClickResponse handleClick(ClickRequest clickRequest);
}
