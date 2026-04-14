package com.example.resumeanalyzer.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AiAnalysisRequest {

    @JsonProperty("resume_text")
    private String resumeText;

    @JsonProperty("job_description")
    private String jobDescription;

    public AiAnalysisRequest() {
    }

    public AiAnalysisRequest(String resumeText, String jobDescription) {
        this.resumeText = resumeText;
        this.jobDescription = jobDescription;
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
}