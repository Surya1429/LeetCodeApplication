package com.leetcode.userservice.service;

import com.leetcode.userservice.dto.UserRequest;
import com.leetcode.userservice.entity.User;
import com.leetcode.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(Long id, UserRequest request) {
        User user = new User();
        user.setId(id);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, UserRequest request) {
        User user = getUserById(id);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        return userRepository.save(user);
    }
}