from typing import List


def build_strengths(resume_skills: List[str], job_skills: List[str]) -> List[str]:
    matched = [skill for skill in resume_skills if skill in job_skills]

    strengths = []

    if matched:
        strengths.append("Good alignment in core technical skills")

    if "Java" in matched and "Spring Boot" in matched:
        strengths.append("Strong backend alignment with Java and Spring Boot")

    if "MySQL" in matched or "PostgreSQL" in matched:
        strengths.append("Relevant database skills are present")

    return strengths[:3]


def build_gaps(resume_skills: List[str], job_skills: List[str]) -> List[str]:
    missing = [skill for skill in job_skills if skill not in resume_skills]

    gaps = []

    if missing:
        gaps.append("Some required or preferred skills are missing")

    if "AWS" in missing:
        gaps.append("Cloud platform experience is not clearly shown")

    if "Docker" in missing:
        gaps.append("Containerization experience is missing")

    return gaps[:3]


def build_summary(semantic_score: float, strengths: List[str], gaps: List[str]) -> str:
    if semantic_score >= 70:
        level = "strong"
    elif semantic_score >= 50:
        level = "moderate"
    else:
        level = "limited"

    summary = f"Semantic analysis indicates a {level} alignment between the resume and the job description."

    if strengths:
        summary += f" Key strength: {strengths[0]}."
    if gaps:
        summary += f" Main gap: {gaps[0]}."

    return summary