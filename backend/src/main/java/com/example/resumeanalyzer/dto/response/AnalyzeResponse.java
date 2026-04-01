package com.example.resumeanalyzer.dto.response;

import java.util.Set;

public class AnalyzeResponse {

    private double matchPercentage;
    private Set<String> matchedKeywords;
    private Set<String> missingKeywords;
    private Set<String> extractedResumeKeywords;
    private Set<String> extractedJobKeywords;
    private String message;

    // Constructor
    public AnalyzeResponse(double matchPercentage,
                           Set<String> matchedKeywords,
                           Set<String> missingKeywords,
                           Set<String> extractedResumeKeywords,
                           Set<String> extractedJobKeywords,
                           String message) {
        this.matchPercentage = matchPercentage;
        this.matchedKeywords = matchedKeywords;
        this.missingKeywords = missingKeywords;
        this.extractedResumeKeywords = extractedResumeKeywords;
        this.extractedJobKeywords = extractedJobKeywords;
        this.message = message;
    }

    // Getters and Setters

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(double matchPercentage) {
        this.matchPercentage = matchPercentage;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}