package com.leetcode.problemservice.service;

import com.leetcode.problemservice.dto.ProblemDTO;
import com.leetcode.problemservice.entity.Difficulty;
import com.leetcode.problemservice.entity.Problem;
import com.leetcode.problemservice.mapper.ProblemMapper;
import com.leetcode.problemservice.repository.ProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemRepository problemRepository;

    @Override
    public ProblemDTO saveProblem(ProblemDTO dto){
        Problem problem = ProblemMapper.toEntity(dto);
        Problem saved = problemRepository.save(problem);

        return ProblemMapper.toDTO(saved);
    }

    @Override
    public List<ProblemDTO> getAllProblems(){
        return problemRepository.findAll()
                .stream()
                .map(ProblemMapper::toDTO)
                .toList();
    }

    @Override
    public Problem getProblemById(Long id){
        return problemRepository.findById(id).orElseThrow(()->new RuntimeException("problem not found"));
    }

    @Override
    public ProblemDTO updateProblem(Long id, ProblemDTO dto) {

        // 1. Get ENTITY from DB
        Problem existing = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found"));

        // 2. Update fields
        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());

        if (dto.getDifficulty() != null) {
            existing.setDifficulty(Difficulty.valueOf(dto.getDifficulty().toUpperCase()));
        }

        existing.setInputFormat(dto.getInputFormat());
        existing.setOutputFormat(dto.getOutputFormat());
        existing.setConstraints(dto.getConstraints());
        existing.setSampleInput(dto.getSampleInput());
        existing.setSampleOutput(dto.getSampleOutput());
        existing.setExplanation(dto.getExplanation());
        existing.setStarterCode(dto.getStarterCode());

        // 3. Save ENTITY
        Problem updated = problemRepository.save(existing);

        // 4. Convert to DTO
        return ProblemMapper.toDTO(updated);
    }

    @Override
    public void deleteProblemById(Long id){
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found"));

        problemRepository.delete(problem);
    }

}
