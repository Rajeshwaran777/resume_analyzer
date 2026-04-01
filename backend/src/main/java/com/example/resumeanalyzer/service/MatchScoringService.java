package com.example.resumeanalyzer.service;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.TreeSet;

@Service
public class MatchScoringService {

    public Set<String> findMatchedKeywords(Set<String> resumeKeywords, Set<String> jobKeywords) {
        Set<String> matched = new TreeSet<>(resumeKeywords);
        matched.retainAll(jobKeywords);
        return matched;
    }

    public Set<String> findMissingKeywords(Set<String> resumeKeywords, Set<String> jobKeywords) {
        Set<String> missing = new TreeSet<>(jobKeywords);
        missing.removeAll(resumeKeywords);
        return missing;
    }

    public double calculateMatchPercentage(Set<String> matchedKeywords, Set<String> jobKeywords) {
        if (jobKeywords == null || jobKeywords.isEmpty()) {
            return 0.0;
        }

        double score = ((double) matchedKeywords.size() / jobKeywords.size()) * 100;
        return Math.round(score * 100.0) / 100.0;
    }

    public String getMatchMessage(double score) {
        if (score >= 80) {
            return "Strong match";
        } else if (score >= 60) {
            return "Good match";
        } else if (score >= 40) {
            return "Average match";
        } else {
            return "Low match";
        }
    }
}