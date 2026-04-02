package com.leetcode.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    private Long id; // same as auth-service

    @NotBlank
    private String username;

    @NotBlank
    @Email
    @Column(unique = true, nullable = false)
    private String email;


}
