package com.example.resumeanalyzer.util;

public final class TextNormalizer {

    private TextNormalizer() {
    }

    public static String normalize(String text) {
        if (text == null || text.isBlank()) {
            return "";
        }

        return text.toLowerCase()
                .replace("spring boot", "springboot")
                .replace("node.js", "nodejs")
                .replace("rest api", "restapi")
                .replace("machine learning", "machinelearning")
                .replace("data structures", "datastructures")
                .replaceAll("[^a-zA-Z0-9\\s]", " ")
                .replaceAll("\\s+", " ")
                .trim();
    }
}