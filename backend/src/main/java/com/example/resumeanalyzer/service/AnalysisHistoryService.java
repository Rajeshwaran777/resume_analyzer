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

        analysis.setKeywordScore(responseData.keywordScore());
        analysis.setSemanticScore(responseData.semanticScore());
        analysis.setFinalScore(responseData.finalScore());

        analysis.setMatchedKeywords(joinSet(responseData.matchedKeywords()));
        analysis.setMissingKeywords(joinSet(responseData.missingKeywords()));
        analysis.setExtractedResumeKeywords(joinSet(responseData.extractedResumeKeywords()));
        analysis.setExtractedJobKeywords(joinSet(responseData.extractedJobKeywords()));

        analysis.setNormalizedResumeSkills(joinList(responseData.normalizedResumeSkills()));
        analysis.setNormalizedJobSkills(joinList(responseData.normalizedJobSkills()));
        analysis.setStrengths(joinList(responseData.strengths()));
        analysis.setGaps(joinList(responseData.gaps()));

        analysis.setSummary(responseData.summary());
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
        return resumeAnalysisRepository.findByFinalScoreGreaterThanEqual(minScore)
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
                analysis.getKeywordScore(),
                analysis.getSemanticScore(),
                analysis.getFinalScore(),
                splitSet(analysis.getMatchedKeywords()),
                splitSet(analysis.getMissingKeywords()),
                splitSet(analysis.getExtractedResumeKeywords()),
                splitSet(analysis.getExtractedJobKeywords()),
                splitList(analysis.getNormalizedResumeSkills()),
                splitList(analysis.getNormalizedJobSkills()),
                splitList(analysis.getStrengths()),
                splitList(analysis.getGaps()),
                analysis.getSummary(),
                analysis.getMessage(),
                analysis.getCreatedAt()
        );
    }

    private String joinSet(Set<String> values) {
        if (values == null || values.isEmpty()) {
            return "";
        }
        return String.join(",", new TreeSet<>(values));
    }

    private String joinList(List<String> values) {
        if (values == null || values.isEmpty()) {
            return "";
        }
        return String.join("||", values);
    }

    private Set<String> splitSet(String values) {
        if (values == null || values.isBlank()) {
            return Collections.emptySet();
        }

        return Arrays.stream(values.split(","))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private List<String> splitList(String values) {
        if (values == null || values.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.stream(values.split("\\|\\|"))
                .map(String::trim)
                .filter(s -> !s.isBlank())
                .toList();
    }

    public record AnalyzeResponseData(
            double keywordScore,
            double semanticScore,
            double finalScore,
            Set<String> matchedKeywords,
            Set<String> missingKeywords,
            Set<String> extractedResumeKeywords,
            Set<String> extractedJobKeywords,
            List<String> normalizedResumeSkills,
            List<String> normalizedJobSkills,
            List<String> strengths,
            List<String> gaps,
            String summary,
            String message
    ) {
    }
}