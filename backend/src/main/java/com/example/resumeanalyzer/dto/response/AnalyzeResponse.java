package com.example.resumeanalyzer.dto.response;

import java.util.List;
import java.util.Set;

public class AnalyzeResponse {

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

    public AnalyzeResponse() {
    }

    public AnalyzeResponse(double keywordScore,
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
                           String message) {
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
    }

    public double getKeywordScore() {
        return keywordScore;
    }

    public void setKeywordScore(double keywordScore) {
        this.keywordScore = keywordScore;
    }

    public double getSemanticScore() {
        return semanticScore;
    }

    public void setSemanticScore(double semanticScore) {
        this.semanticScore = semanticScore;
    }

    public double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(double finalScore) {
        this.finalScore = finalScore;
    }

    public Set<String> getMatchedKeywords() {
        return matchedKeywords;
    }

    public void setMatchedKeywords(Set<String> matchedKeywords) {
        this.matchedKeywords = matchedKeywords;
    }

    public Set<String> getMissingKeywords() {
        return missingKeywords;
    }

    public void setMissingKeywords(Set<String> missingKeywords) {
        this.missingKeywords = missingKeywords;
    }

    public Set<String> getExtractedResumeKeywords() {
        return extractedResumeKeywords;
    }

    public void setExtractedResumeKeywords(Set<String> extractedResumeKeywords) {
        this.extractedResumeKeywords = extractedResumeKeywords;
    }

    public Set<String> getExtractedJobKeywords() {
        return extractedJobKeywords;
    }

    public void setExtractedJobKeywords(Set<String> extractedJobKeywords) {
        this.extractedJobKeywords = extractedJobKeywords;
    }

    public List<String> getNormalizedResumeSkills() {
        return normalizedResumeSkills;
    }

    public void setNormalizedResumeSkills(List<String> normalizedResumeSkills) {
        this.normalizedResumeSkills = normalizedResumeSkills;
    }

    public List<String> getNormalizedJobSkills() {
        return normalizedJobSkills;
    }

    public void setNormalizedJobSkills(List<String> normalizedJobSkills) {
        this.normalizedJobSkills = normalizedJobSkills;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public void setStrengths(List<String> strengths) {
        this.strengths = strengths;
    }

    public List<String> getGaps() {
        return gaps;
    }

    public void setGaps(List<String> gaps) {
        this.gaps = gaps;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}