package com.example.resumeanalyzer.repository;

import com.example.resumeanalyzer.entity.ResumeAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeAnalysisRepository extends JpaRepository<ResumeAnalysis, Long> {

    List<ResumeAnalysis> findByResumeFileNameContainingIgnoreCase(String resumeFileName);

    List<ResumeAnalysis> findByFinalScoreGreaterThanEqual(double finalScore);
}