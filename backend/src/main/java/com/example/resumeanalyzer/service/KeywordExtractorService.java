package com.example.resumeanalyzer.service;

import com.example.resumeanalyzer.util.KeywordDictionary;
import com.example.resumeanalyzer.util.TextNormalizer;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class KeywordExtractorService {

    public Set<String> extractKeywords(String text) {
        if (text == null || text.isBlank()) {
            return Collections.emptySet();
        }

        String normalizedText = TextNormalizer.normalize(text);

        return Arrays.stream(normalizedText.split("\\s+"))
                .map(String::trim)
                .filter(token -> !token.isBlank())
                .filter(token -> token.length() > 2)
                .filter(token -> !KeywordDictionary.STOP_WORDS.contains(token))
                .filter(token -> KeywordDictionary.TECH_KEYWORDS.contains(token))
                .collect(Collectors.toCollection(TreeSet::new));
    }
}