package com.leetcode.problemservice.repository;

import com.leetcode.problemservice.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
}
