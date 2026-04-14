from fastapi import APIRouter
from app.models.schemas import AnalyzeRequest, AnalyzeResponse
from app.services.skill_extraction_service import extract_skills
from app.services.similarity_service import compute_semantic_similarity
from app.services.summary_service import build_strengths, build_gaps, build_summary

router = APIRouter()


@router.post("/analyze", response_model=AnalyzeResponse)
def analyze_resume(request: AnalyzeRequest):
    print("AI SERVICE RECEIVED:")
    print("resume_text:", request.resume_text)
    print("job_description:", request.job_description)

    resume_skills = extract_skills(request.resume_text)
    job_skills = extract_skills(request.job_description)

    semantic_score = compute_semantic_similarity(
        request.resume_text,
        request.job_description
    )

    strengths = build_strengths(resume_skills, job_skills)
    gaps = build_gaps(resume_skills, job_skills)
    summary = build_summary(semantic_score, strengths, gaps)

    return AnalyzeResponse(
        semantic_score=semantic_score,
        extracted_resume_skills=resume_skills,
        extracted_job_skills=job_skills,
        strengths=strengths,
        gaps=gaps,
        summary=summary
    )