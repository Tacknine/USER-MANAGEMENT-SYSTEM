package com.tacknine.ums.controller;

import com.tacknine.ums.dto.AuthResponseDto;
import com.tacknine.ums.dto.LoginRequestDto;
import com.tacknine.ums.dto.UserRequestDto;
import com.tacknine.ums.dto.UserResponseDto;
import com.tacknine.ums.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponseDto login(@RequestBody LoginRequestDto request) {
        return authService.login(request);
    }
}