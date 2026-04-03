package com.leetcode.problemservice.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name="problems")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Problem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length=2000)
    private String description;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty; //EASY,MEDIUM,HARD

    @Column(columnDefinition = "TEXT")
    private String sampleInput;

    @Column(columnDefinition = "TEXT")
    private String sampleOutput;

    @Column(columnDefinition = "TEXT")
    private String explanation;

    @Column(columnDefinition = "TEXT")
    private String starterCode;

    @Column(columnDefinition = "TEXT")
    private String constraints;

    @Column(columnDefinition = "TEXT")
    private String inputFormat;

    @Column(columnDefinition = "TEXT")
    private String outputFormat;

    @OneToMany(mappedBy = "problem",cascade=CascadeType.ALL)
    private List<TestCase> testCases;


}
