package com.example.resumeanalyzer.service;

import com.example.resumeanalyzer.client.AiServiceClient;
import com.example.resumeanalyzer.client.dto.AiAnalysisResult;
import org.springframework.stereotype.Service;

@Service
public class AiAnalysisService {

    private final AiServiceClient aiServiceClient;

    public AiAnalysisService(AiServiceClient aiServiceClient) {
        this.aiServiceClient = aiServiceClient;
    }

    public AiAnalysisResult analyze(String resumeText, String jobDescription) {
        return aiServiceClient.analyze(resumeText, jobDescription);
    }
}