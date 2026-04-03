package com.leetcode.problemservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestCaseDTO {
    private String input;
    private String expectedOutput;
    private boolean isSample;
}
