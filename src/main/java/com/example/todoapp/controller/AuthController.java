package com.example.todoapp.controller;

import com.example.todoapp.model.UserModel;
import com.example.todoapp.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserModel register(@RequestBody UserModel user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public UserModel login(@RequestBody UserModel user) {
        return service.login(user.getEmail(), user.getPassword());
    }
}
