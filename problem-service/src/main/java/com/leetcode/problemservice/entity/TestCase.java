package com.leetcode.problemservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="test_cases")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TestCase
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String input;

    @Column(columnDefinition = "TEXT")
    private String expectedOutput;

    private boolean isSample; // true = visible, false = hidden

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;
}
