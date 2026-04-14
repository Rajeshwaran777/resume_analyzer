from typing import List

SKILL_ALIASES = {
    "Java": ["java"],
    "Spring Boot": ["spring boot", "springboot", "spring"],
    "REST API": ["rest api", "restapi", "restful api"],
    "MySQL": ["mysql"],
    "PostgreSQL": ["postgresql", "postgres"],
    "SQL": ["sql"],
    "Docker": ["docker"],
    "AWS": ["aws", "amazon web services"],
    "Git": ["git"],
    "GitHub": ["github"],
    "Python": ["python"],
    "Machine Learning": ["machine learning", "machinelearning", "ml"],
    "NLP": ["nlp", "natural language processing"],
    "Maven": ["maven"],
    "JUnit": ["junit"]
}


def normalize_text(text: str) -> str:
    return text.lower().strip()


def extract_skills(text: str) -> List[str]:
    normalized = normalize_text(text)
    found_skills = []

    for canonical_skill, aliases in SKILL_ALIASES.items():
        for alias in aliases:
            if alias in normalized:
                found_skills.append(canonical_skill)
                break

    # remove generic SQL if a specific SQL database already exists
    if "MySQL" in found_skills and "SQL" in found_skills:
        found_skills.remove("SQL")

    if "PostgreSQL" in found_skills and "SQL" in found_skills:
        found_skills.remove("SQL")

    # if Spring Boot exists, remove generic Spring duplication
    if "Spring Boot" in found_skills and "Spring" in found_skills:
        found_skills.remove("Spring")

    return sorted(set(found_skills))