package com.leetcode.authservice.service;

import com.leetcode.authservice.entity.User;
import com.leetcode.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));

        if(!user.getPassword().equals(password)){
            throw new RuntimeException("Incorrect password");
        }
        return user;
    }

}
