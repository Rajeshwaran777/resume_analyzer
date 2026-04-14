package com.example.resumeanalyzer.client;

import com.example.resumeanalyzer.client.dto.AiAnalysisRequest;
import com.example.resumeanalyzer.client.dto.AiAnalysisResult;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class AiServiceClient {

    private final RestClient aiRestClient;

    public AiServiceClient(RestClient aiRestClient) {
        this.aiRestClient = aiRestClient;
    }

    public AiAnalysisResult analyze(String resumeText, String jobDescription) {
        AiAnalysisRequest request = new AiAnalysisRequest(resumeText, jobDescription);

        System.out.println("Sending to AI service:");
        System.out.println("resumeText = " + resumeText);
        System.out.println("jobDescription = " + jobDescription);

        return aiRestClient.post()
                .uri("/analyze")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(AiAnalysisResult.class);
    }
}