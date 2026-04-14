package com.example.resumeanalyzer.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class AnalysisHistoryResponse {

    private Long id;
    private String resumeFileName;
    private String jobDescription;

    private double keywordScore;
    private double semanticScore;
    private double finalScore;

    private Set<String> matchedKeywords;
    private Set<String> missingKeywords;
    private Set<String> extractedResumeKeywords;
    private Set<String> extractedJobKeywords;

    private List<String> normalizedResumeSkills;
    private List<String> normalizedJobSkills;
    private List<String> strengths;
    private List<String> gaps;

    private String summary;
    private String message;
    private LocalDateTime createdAt;

    public AnalysisHistoryResponse() {
    }

    public AnalysisHistoryResponse(Long id,
                                   String resumeFileName,
                                   String jobDescription,
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
                                   String message,
                                   LocalDateTime createdAt) {
        this.id = id;
        this.resumeFileName = resumeFileName;
        this.jobDescription = jobDescription;
        this.keywordScore = keywordScore;
        this.semanticScore = semanticScore;
        this.finalScore = finalScore;
        this.matchedKeywords = matchedKeywords;
        this.missingKeywords = missingKeywords;
        this.extractedResumeKeywords = extractedResumeKeywords;
        this.extractedJobKeywords = extractedJobKeywords;
        this.normalizedResumeSkills = normalizedResumeSkills;
        this.normalizedJobSkills = normalizedJobSkills;
        this.strengths = strengths;
        this.gaps = gaps;
        this.summary = summary;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public double getKeywordScore() {
        return keywordScore;
    }

    public double getSemanticScore() {
        return semanticScore;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public Set<String> getMatchedKeywords() {
        return matchedKeywords;
    }

    public Set<String> getMissingKeywords() {
        return missingKeywords;
    }

    public Set<String> getExtractedResumeKeywords() {
        return extractedResumeKeywords;
    }

    public Set<String> getExtractedJobKeywords() {
        return extractedJobKeywords;
    }

    public List<String> getNormalizedResumeSkills() {
        return normalizedResumeSkills;
    }

    public List<String> getNormalizedJobSkills() {
        return normalizedJobSkills;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public List<String> getGaps() {
        return gaps;
    }

    public String getSummary() {
        return summary;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}