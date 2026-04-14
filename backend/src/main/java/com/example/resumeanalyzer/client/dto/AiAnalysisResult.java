package com.example.resumeanalyzer.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AiAnalysisResult {

    @JsonProperty("semantic_score")
    private double semanticScore;

    @JsonProperty("extracted_resume_skills")
    private List<String> extractedResumeSkills;

    @JsonProperty("extracted_job_skills")
    private List<String> extractedJobSkills;

    private List<String> strengths;
    private List<String> gaps;
    private String summary;

    public AiAnalysisResult() {
    }

    public double getSemanticScore() {
        return semanticScore;
    }

    public void setSemanticScore(double semanticScore) {
        this.semanticScore = semanticScore;
    }

    public List<String> getExtractedResumeSkills() {
        return extractedResumeSkills;
    }

    public void setExtractedResumeSkills(List<String> extractedResumeSkills) {
        this.extractedResumeSkills = extractedResumeSkills;
    }

    public List<String> getExtractedJobSkills() {
        return extractedJobSkills;
    }

    public void setExtractedJobSkills(List<String> extractedJobSkills) {
        this.extractedJobSkills = extractedJobSkills;
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
}