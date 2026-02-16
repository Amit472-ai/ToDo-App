package com.example.todoapp.controller;

import com.example.todoapp.DTO.LoginRequestDTO;
import com.example.todoapp.DTO.RegisterRequestDTO;
import com.example.todoapp.model.UserModel;
import com.example.todoapp.service.AuthService;
import jakarta.validation.Valid;
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
    public UserModel register(@Valid @RequestBody RegisterRequestDTO request) {

        UserModel user = new UserModel();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        return service.register(user);
    }


    @PostMapping("/login")
    public UserModel login(@Valid @RequestBody LoginRequestDTO request) {

        return service.login(request.getEmail(), request.getPassword());
    }

}
