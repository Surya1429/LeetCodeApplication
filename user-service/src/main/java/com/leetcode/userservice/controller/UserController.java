package com.leetcode.userservice.controller;

import com.leetcode.userservice.dto.UserRequest;
import com.leetcode.userservice.entity.User;
import com.leetcode.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // 🔹 Create user
    @PostMapping("/{id}")
    public User createUser(@PathVariable Long id,
                           @Valid @RequestBody UserRequest request) {
        return userService.createUser(id, request);
    }

    // 🔹 Get user by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // 🔹 Get user by email
    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // 🔹 Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // 🔹 Update user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @Valid @RequestBody UserRequest request) {
        return userService.updateUser(id, request);
    }


}