package com.leetcode.problemservice.repository;

import com.leetcode.problemservice.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase,Long> {
}
