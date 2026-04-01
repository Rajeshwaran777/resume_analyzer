package com.example.resumeanalyzer.util;

import java.util.Set;

public final class KeywordDictionary {

    private KeywordDictionary() {
    }

    public static final Set<String> TECH_KEYWORDS = Set.of(
            "java",
            "spring",
            "springboot",
            "hibernate",
            "mysql",
            "postgresql",
            "mongodb",
            "sql",
            "nosql",
            "rest",
            "restapi",
            "api",
            "microservices",
            "docker",
            "kubernetes",
            "aws",
            "azure",
            "gcp",
            "maven",
            "gradle",
            "git",
            "github",
            "junit",
            "mockito",
            "html",
            "css",
            "javascript",
            "typescript",
            "react",
            "angular",
            "nodejs",
            "python",
            "nlp",
            "machinelearning",
            "datastructures",
            "algorithms",
            "oop",
            "multithreading",
            "linux",
            "jwt",
            "security"
    );

    public static final Set<String> STOP_WORDS = Set.of(
            "a", "an", "the", "and", "or", "to", "for", "of", "in", "on", "with", "by",
            "is", "are", "was", "were", "be", "been", "being", "as", "at", "from",
            "this", "that", "these", "those", "it", "its", "you", "your", "will", "can",
            "should", "must", "have", "has", "had", "we", "our", "they", "their", "but",
            "looking", "developer", "developers", "experience", "strong", "good", "ability",
            "team", "working", "knowledge", "skills", "skill", "role", "job"
    );
}