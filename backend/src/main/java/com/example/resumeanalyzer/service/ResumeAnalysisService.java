package com.example.resumeanalyzer.service;

import com.example.resumeanalyzer.client.dto.AiAnalysisResult;
import com.example.resumeanalyzer.dto.response.AnalyzeResponse;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ResumeAnalysisService {

    private final KeywordExtractorService keywordExtractorService;
    private final MatchScoringService matchScoringService;
    private final AnalysisHistoryService analysisHistoryService;
    private final AiAnalysisService aiAnalysisService;
    private final FinalScoringService finalScoringService;

    public ResumeAnalysisService(KeywordExtractorService keywordExtractorService,
                                 MatchScoringService matchScoringService,
                                 AnalysisHistoryService analysisHistoryService,
                                 AiAnalysisService aiAnalysisService,
                                 FinalScoringService finalScoringService) {
        this.keywordExtractorService = keywordExtractorService;
        this.matchScoringService = matchScoringService;
        this.analysisHistoryService = analysisHistoryService;
        this.aiAnalysisService = aiAnalysisService;
        this.finalScoringService = finalScoringService;
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

        double keywordScore = matchScoringService.calculateMatchPercentage(matchedKeywords, jobKeywords);

        AiAnalysisResult aiResult = aiAnalysisService.analyze(resumeText, jobDescription);
        double semanticScore = aiResult.getSemanticScore();

        double finalScore = finalScoringService.calculateFinalScore(keywordScore, semanticScore);
        String message = finalScoringService.buildFinalMessage(finalScore);
        String summary = finalScoringService.buildFinalSummary(
                finalScore,
                aiResult.getStrengths(),
                aiResult.getGaps()
        );

        AnalyzeResponse response = new AnalyzeResponse(
                keywordScore,
                semanticScore,
                finalScore,
                matchedKeywords,
                missingKeywords,
                resumeKeywords,
                jobKeywords,
                aiResult.getExtractedResumeSkills(),
                aiResult.getExtractedJobSkills(),
                aiResult.getStrengths(),
                aiResult.getGaps(),
                summary,
                message
        );

        analysisHistoryService.saveAnalysis(
                resumeFileName,
                resumeText,
                jobDescription,
                new AnalysisHistoryService.AnalyzeResponseData(
                        response.getKeywordScore(),
                        response.getSemanticScore(),
                        response.getFinalScore(),
                        response.getMatchedKeywords(),
                        response.getMissingKeywords(),
                        response.getExtractedResumeKeywords(),
                        response.getExtractedJobKeywords(),
                        aiResult.getExtractedResumeSkills(),
                        aiResult.getExtractedJobSkills(),
                        response.getStrengths(),
                        response.getGaps(),
                        response.getSummary(),
                        response.getMessage()
                )
        );

        return response;
    }
}