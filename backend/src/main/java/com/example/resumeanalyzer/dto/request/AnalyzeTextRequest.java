package com.example.resumeanalyzer.dto.request;

import jakarta.validation.constraints.NotBlank;

public class AnalyzeTextRequest {

    @NotBlank(message = "Resume text must not be blank")
    private String resumeText;

    @NotBlank(message = "Job description must not be blank")
    private String jobDescription;

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
}