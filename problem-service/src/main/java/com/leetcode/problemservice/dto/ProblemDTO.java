package com.leetcode.problemservice.dto;

import com.leetcode.problemservice.entity.Difficulty;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemDTO
{
    private Long id;
    private String title;
    private String description;
    private String difficulty;

    private String inputFormat;
    private String outputFormat;
    private String constraints;
    private String sampleInput;
    private String sampleOutput;
    private String explanation;
    private String starterCode;

    private List<TestCaseDTO> testcases;
}
