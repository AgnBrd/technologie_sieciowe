package com.ts.projekt_ts.controllers;

import com.ts.projekt_ts.controllers.dto.RegisterDto;
import com.ts.projekt_ts.controllers.dto.RegisterResponseDto;
import com.ts.projekt_ts.infrastucture.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDto> register(@RequestBody RegisterDto requestBady){
        RegisterResponseDto dto = authService.register(requestBady);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
