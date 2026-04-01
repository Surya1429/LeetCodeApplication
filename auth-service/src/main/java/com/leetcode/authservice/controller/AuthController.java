package com.leetcode.authservice.controller;

import com.leetcode.authservice.dto.LoginRequest;
import com.leetcode.authservice.entity.User;
import com.leetcode.authservice.repository.UserRepository;
import com.leetcode.authservice.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    /* -----------default login practice
    @PostMapping("/login")
    public User login(@RequestParam String email,
                      @RequestParam String password)
    {
        return authService.login(email,password);
    }*/



    /*

    // if use this approach then i have to pass in url itself
    //POST http://localhost:8081/auth/login?email=madhu@gmail.com&password=123
    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password) {

        return authService.login(email, password);
    }
     */

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        return authService.login(
                request.getEmail(),
                request.getPassword()
        );
    }


    @GetMapping("/profile")
    public User getProfile(HttpServletRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName(); // 🔥 this is correct way --- here email is an user id so we used getName()

        return authService.getUserByEmail(email);
    }

}
