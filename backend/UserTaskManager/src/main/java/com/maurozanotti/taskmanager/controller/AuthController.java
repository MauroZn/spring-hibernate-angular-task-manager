package com.maurozanotti.taskmanager.controller;

import com.maurozanotti.taskmanager.jwt.JwtUtil;
import com.maurozanotti.taskmanager.models.User;
import com.maurozanotti.taskmanager.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User authenticated = userService.authenticate(user.getUsername(), user.getPassword());
        String token = jwtUtil.generateToken(authenticated.getUsername());
        return Map.of("token", token);
    }
}
