package com.leetcode.authservice.controller;

import com.leetcode.authservice.entity.User;
import com.leetcode.authservice.repository.UserRepository;
import com.leetcode.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email,
                      @RequestParam String password)
    {
        return authService.login(email,password);
    }
}
