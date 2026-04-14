from pydantic import BaseModel, Field
from typing import List


class AnalyzeRequest(BaseModel):
    resume_text: str = Field(..., min_length=1)
    job_description: str = Field(..., min_length=1)


class AnalyzeResponse(BaseModel):
    semantic_score: float
    extracted_resume_skills: List[str]
    extracted_job_skills: List[str]
    strengths: List[str]
    gaps: List[str]
    summary: str