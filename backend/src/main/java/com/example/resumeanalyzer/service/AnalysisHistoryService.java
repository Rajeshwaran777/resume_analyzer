package com.example.resumeanalyzer.service;

import com.example.resumeanalyzer.dto.response.AnalysisHistoryResponse;
import com.example.resumeanalyzer.entity.ResumeAnalysis;
import com.example.resumeanalyzer.repository.ResumeAnalysisRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalysisHistoryService {

    private final ResumeAnalysisRepository resumeAnalysisRepository;

    public AnalysisHistoryService(ResumeAnalysisRepository resumeAnalysisRepository) {
        this.resumeAnalysisRepository = resumeAnalysisRepository;
    }

    public void saveAnalysis(String resumeFileName,
                             String resumeText,
                             String jobDescription,
                             AnalyzeResponseData responseData) {
        ResumeAnalysis analysis = new ResumeAnalysis();
        analysis.setResumeFileName(resumeFileName);
        analysis.setResumeText(resumeText);
        analysis.setJobDescription(jobDescription);
        analysis.setMatchPercentage(responseData.matchPercentage());
        analysis.setMatchedKeywords(joinKeywords(responseData.matchedKeywords()));
        analysis.setMissingKeywords(joinKeywords(responseData.missingKeywords()));
        analysis.setExtractedResumeKeywords(joinKeywords(responseData.extractedResumeKeywords()));
        analysis.setExtractedJobKeywords(joinKeywords(responseData.extractedJobKeywords()));
        analysis.setMessage(responseData.message());
        analysis.setCreatedAt(LocalDateTime.now());

        resumeAnalysisRepository.save(analysis);
    }

    public Page<AnalysisHistoryResponse> getHistory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        return resumeAnalysisRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    public AnalysisHistoryResponse getHistoryById(Long id) {
        ResumeAnalysis analysis = resumeAnalysisRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Analysis record not found for id: " + id));
        return mapToResponse(analysis);
    }

    public List<AnalysisHistoryResponse> searchByFileName(String fileName) {
        return resumeAnalysisRepository.findByResumeFileNameContainingIgnoreCase(fileName)
                .stream()
                .sorted(createdAtDescNullSafe())
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public List<AnalysisHistoryResponse> getByMinimumMatchPercentage(double minScore) {
        return resumeAnalysisRepository.findByMatchPercentageGreaterThanEqual(minScore)
                .stream()
                .sorted(createdAtDescNullSafe())
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private Comparator<ResumeAnalysis> createdAtDescNullSafe() {
        return Comparator.comparing(
                ResumeAnalysis::getCreatedAt,
                Comparator.nullsLast(Comparator.reverseOrder())
        );
    }

    private AnalysisHistoryResponse mapToResponse(ResumeAnalysis analysis) {
        return new AnalysisHistoryResponse(
                analysis.getId(),
                analysis.getResumeFileName(),
                analysis.getJobDescription(),
                analysis.getMatchPercentage(),
                splitKeywords(analysis.getMatchedKeywords()),
                splitKeywords(analysis.getMissingKeywords()),
                splitKeywords(analysis.getExtractedResumeKeywords()),
                splitKeywords(analysis.getExtractedJobKeywords()),
                analysis.getMessage(),
                analysis.getCreatedAt()
        );
    }

    private String joinKeywords(Set<String> keywords) {
        if (keywords == null || keywords.isEmpty()) {
            return "";
        }
        return String.join(",", new TreeSet<>(keywords));
    }

    private Set<String> splitKeywords(String keywords) {
        if (keywords == null || keywords.isBlank()) {
            return Collections.emptySet();
        }

        return Arrays.stream(keywords.split(","))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public record AnalyzeResponseData(
            double matchPercentage,
            Set<String> matchedKeywords,
            Set<String> missingKeywords,
            Set<String> extractedResumeKeywords,
            Set<String> extractedJobKeywords,
            String message
    ) {}
}