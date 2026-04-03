package com.leetcode.problemservice.service;

import com.leetcode.problemservice.dto.ProblemDTO;
import com.leetcode.problemservice.entity.Problem;

import java.util.List;

public interface ProblemService {
    ProblemDTO saveProblem(ProblemDTO problem);
    List<ProblemDTO> getAllProblems();
    Problem getProblemById(Long id);
    ProblemDTO updateProblem(Long id,ProblemDTO problem);
    void deleteProblemById(Long id);
}
