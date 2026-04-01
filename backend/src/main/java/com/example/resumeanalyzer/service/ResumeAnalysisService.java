package com.example.resumeanalyzer.service;

import com.example.resumeanalyzer.dto.response.AnalyzeResponse;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ResumeAnalysisService {

    private final KeywordExtractorService keywordExtractorService;
    private final MatchScoringService matchScoringService;
    private final AnalysisHistoryService analysisHistoryService;

    public ResumeAnalysisService(KeywordExtractorService keywordExtractorService,
                                 MatchScoringService matchScoringService,
                                 AnalysisHistoryService analysisHistoryService) {
        this.keywordExtractorService = keywordExtractorService;
        this.matchScoringService = matchScoringService;
        this.analysisHistoryService = analysisHistoryService;
    }

    public AnalyzeResponse analyzeText(String resumeText, String jobDescription) {
        return analyzeAndSave(null, resumeText, jobDescription);
    }

    public AnalyzeResponse analyzeFile(String resumeFileName, String resumeText, String jobDescription) {
        return analyzeAndSave(resumeFileName, resumeText, jobDescription);
    }

    private AnalyzeResponse analyzeAndSave(String resumeFileName, String resumeText, String jobDescription) {
        Set<String> resumeKeywords = keywordExtractorService.extractKeywords(resumeText);
        Set<String> jobKeywords = keywordExtractorService.extractKeywords(jobDescription);

        Set<String> matchedKeywords = matchScoringService.findMatchedKeywords(resumeKeywords, jobKeywords);
        Set<String> missingKeywords = matchScoringService.findMissingKeywords(resumeKeywords, jobKeywords);
        double matchPercentage = matchScoringService.calculateMatchPercentage(matchedKeywords, jobKeywords);
        String message = matchScoringService.getMatchMessage(matchPercentage);

        AnalyzeResponse response = new AnalyzeResponse(
                matchPercentage,
                matchedKeywords,
                missingKeywords,
                resumeKeywords,
                jobKeywords,
                message
        );

        analysisHistoryService.saveAnalysis(
                resumeFileName,
                resumeText,
                jobDescription,
                new AnalysisHistoryService.AnalyzeResponseData(
                        response.getMatchPercentage(),
                        response.getMatchedKeywords(),
                        response.getMissingKeywords(),
                        response.getExtractedResumeKeywords(),
                        response.getExtractedJobKeywords(),
                        response.getMessage()
                )
        );

        return response;
    }
}