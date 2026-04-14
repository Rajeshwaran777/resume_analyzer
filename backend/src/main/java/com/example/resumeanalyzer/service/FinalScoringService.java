package com.example.resumeanalyzer.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinalScoringService {

    public double calculateFinalScore(double keywordScore, double semanticScore) {
        double finalScore = (0.7 * keywordScore) + (0.3 * semanticScore);
        return Math.round(finalScore * 100.0) / 100.0;
    }

    public String buildFinalMessage(double finalScore) {
        if (finalScore >= 80) {
            return "Strong Match";
        } else if (finalScore >= 60) {
            return "Good Match";
        } else if (finalScore >= 45) {
            return "Moderate Match";
        } else {
            return "Low Match";
        }
    }

    public String buildFinalSummary(double finalScore, List<String> strengths, List<String> gaps) {
        String level;

        if (finalScore >= 80) {
            level = "strong";
        } else if (finalScore >= 60) {
            level = "good";
        } else if (finalScore >= 45) {
            level = "moderate";
        } else {
            level = "weak";
        }

        StringBuilder summary = new StringBuilder(
                "Candidate shows a " + level + " overall match with the job description"
        );

        if (strengths != null && !strengths.isEmpty()) {
            summary.append(", with a notable strength in ").append(strengths.get(0).toLowerCase());
        }

        if (gaps != null && !gaps.isEmpty()) {
            summary.append(". Main gap: ").append(gaps.get(0));
        } else {
            summary.append(".");
        }

        return summary.toString();
    }
}