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

    @Column(name = "match_percentage", nullable = false)
    private double matchPercentage;

    @Column(name = "matched_keywords", columnDefinition = "TEXT")
    private String matchedKeywords;

    @Column(name = "missing_keywords", columnDefinition = "TEXT")
    private String missingKeywords;

    @Column(name = "extracted_resume_keywords", columnDefinition = "TEXT")
    private String extractedResumeKeywords;

    @Column(name = "extracted_job_keywords", columnDefinition = "TEXT")
    private String extractedJobKeywords;

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

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(double matchPercentage) {
        this.matchPercentage = matchPercentage;
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