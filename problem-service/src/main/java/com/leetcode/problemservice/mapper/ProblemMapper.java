package com.leetcode.problemservice.mapper;

import com.leetcode.problemservice.dto.ProblemDTO;
import com.leetcode.problemservice.dto.TestCaseDTO;
import com.leetcode.problemservice.entity.Difficulty;
import com.leetcode.problemservice.entity.Problem;
import com.leetcode.problemservice.entity.TestCase;

import java.util.List;

public class ProblemMapper {

    // DTO → ENTITY
    public static Problem toEntity(ProblemDTO dto) {

        Problem problem = new Problem();

        problem.setId(dto.getId());
        problem.setTitle(dto.getTitle());
        problem.setDescription(dto.getDescription());

        // 🔥 String → Enum
        if (dto.getDifficulty() != null) {
            problem.setDifficulty(Difficulty.valueOf(dto.getDifficulty().toUpperCase()));
        }
        System.out.println(dto.getTestcases());
        if (dto.getTestcases() != null) {
            List<TestCase> testCases = dto.getTestcases().stream().map(tcDto -> {
                TestCase tc = new TestCase();
                tc.setInput(tcDto.getInput());
                tc.setExpectedOutput(tcDto.getExpectedOutput());
                tc.setSample(tcDto.isSample());
                tc.setProblem(problem); // VERY IMPORTANT
                return tc;
            }).toList();

            problem.setTestCases(testCases);
        }
        // New fields
        problem.setInputFormat(dto.getInputFormat());
        problem.setOutputFormat(dto.getOutputFormat());
        problem.setConstraints(dto.getConstraints());
        problem.setSampleInput(dto.getSampleInput());
        problem.setSampleOutput(dto.getSampleOutput());
        problem.setExplanation(dto.getExplanation());
        problem.setStarterCode(dto.getStarterCode());

        return problem;
    }

    // ENTITY → DTO
    public static ProblemDTO toDTO(Problem problem) {

        ProblemDTO dto = new ProblemDTO();

        dto.setId(problem.getId());
        dto.setTitle(problem.getTitle());
        dto.setDescription(problem.getDescription());

        // 🔥 Enum → String
        if (problem.getDifficulty() != null) {
            dto.setDifficulty(problem.getDifficulty().name());
        }

        if (problem.getTestCases() != null) {
            List<TestCaseDTO> testCaseDTOs = problem.getTestCases().stream().map(tc -> {
                TestCaseDTO dtoTc = new TestCaseDTO();
                dtoTc.setInput(tc.getInput());
                dtoTc.setExpectedOutput(tc.getExpectedOutput());
                dtoTc.setSample(tc.isSample());
                return dtoTc;
            }).toList();

            dto.setTestcases(testCaseDTOs);
        }
        // New fields
        dto.setInputFormat(problem.getInputFormat());
        dto.setOutputFormat(problem.getOutputFormat());
        dto.setConstraints(problem.getConstraints());
        dto.setSampleInput(problem.getSampleInput());
        dto.setSampleOutput(problem.getSampleOutput());
        dto.setExplanation(problem.getExplanation());
        dto.setStarterCode(problem.getStarterCode());

        return dto;
    }
}
