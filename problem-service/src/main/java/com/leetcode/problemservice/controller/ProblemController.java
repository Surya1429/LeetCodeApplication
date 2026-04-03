package com.leetcode.problemservice.controller;

import com.leetcode.problemservice.dto.ProblemDTO;
import com.leetcode.problemservice.entity.Problem;
import com.leetcode.problemservice.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/problems")
public class ProblemController {
    @Autowired
    private ProblemService problemService;

    @PostMapping
    public ProblemDTO createProblem(@RequestBody ProblemDTO problem){
        return problemService.saveProblem(problem);
    }

    @GetMapping
    public List<ProblemDTO> getAllProblems(){
        return problemService.getAllProblems();
    }

    @GetMapping("/{id}")
    public Problem getProblemById(@PathVariable Long id)
    {
        return problemService.getProblemById(id);
    }

    @PutMapping("/{id}")
    public ProblemDTO updateProblem(@PathVariable Long id, @RequestBody ProblemDTO problem) {
        return problemService.updateProblem(id, problem);
    }

    @DeleteMapping("/{id}")
    public String deleteProblem(@PathVariable Long id) {
        problemService.deleteProblemById(id);
        return "Problem deleted successfully";
    }
}
