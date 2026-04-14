package com.example.resumeanalyzer.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resume_analysis")
public class ResumeAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resume_file_name")
    private String resumeFileName;

    @Column(name = "resume_text", columnDefinition = "TEXT")
    private String resumeText;

    @Column(name = "job_description", columnDefinition = "TEXT")
    private String jobDescription;

    @Column(name = "keyword_score", nullable = false)
    private double keywordScore;

    @Column(name = "semantic_score", nullable = false)
    private double semanticScore;

    @Column(name = "final_score", nullable = false)
    private double finalScore;

    @Column(name = "matched_keywords", columnDefinition = "TEXT")
    private String matchedKeywords;

    @Column(name = "missing_keywords", columnDefinition = "TEXT")
    private String missingKeywords;

    @Column(name = "extracted_resume_keywords", columnDefinition = "TEXT")
    private String extractedResumeKeywords;

    @Column(name = "extracted_job_keywords", columnDefinition = "TEXT")
    private String extractedJobKeywords;

    @Column(name = "normalized_resume_skills", columnDefinition = "TEXT")
    private String normalizedResumeSkills;

    @Column(name = "normalized_job_skills", columnDefinition = "TEXT")
    private String normalizedJobSkills;

    @Column(name = "strengths", columnDefinition = "TEXT")
    private String strengths;

    @Column(name = "gaps", columnDefinition = "TEXT")
    private String gaps;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "message")
    private String message;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public ResumeAnalysis() {
    }

    public Long getId() {
        return id;
    }

    public String getResumeFileName() {
        return resumeFileName;
    }

    public void setResumeFileName(String resumeFileName) {
        this.resumeFileName = resumeFileName;
    }

    public String getResumeText() {
        return resumeText;
    }

    public void setResumeText(String resumeText) {
        this.resumeText = resumeText;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
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

    public String getMatchedKeywords() {
        return matchedKeywords;
    }

    public void setMatchedKeywords(String matchedKeywords) {
        this.matchedKeywords = matchedKeywords;
    }

    public String getMissingKeywords() {
        return missingKeywords;
    }

    public void setMissingKeywords(String missingKeywords) {
        this.missingKeywords = missingKeywords;
    }

    public String getExtractedResumeKeywords() {
        return extractedResumeKeywords;
    }

    public void setExtractedResumeKeywords(String extractedResumeKeywords) {
        this.extractedResumeKeywords = extractedResumeKeywords;
    }

    public String getExtractedJobKeywords() {
        return extractedJobKeywords;
    }

    public void setExtractedJobKeywords(String extractedJobKeywords) {
        this.extractedJobKeywords = extractedJobKeywords;
    }

    public String getNormalizedResumeSkills() {
        return normalizedResumeSkills;
    }

    public void setNormalizedResumeSkills(String normalizedResumeSkills) {
        this.normalizedResumeSkills = normalizedResumeSkills;
    }

    public String getNormalizedJobSkills() {
        return normalizedJobSkills;
    }

    public void setNormalizedJobSkills(String normalizedJobSkills) {
        this.normalizedJobSkills = normalizedJobSkills;
    }

    public String getStrengths() {
        return strengths;
    }

    public void setStrengths(String strengths) {
        this.strengths = strengths;
    }

    public String getGaps() {
        return gaps;
    }

    public void setGaps(String gaps) {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}