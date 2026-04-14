from fastapi import FastAPI
from app.api.routes import router

app = FastAPI(
    title="Resume Analyzer AI Service",
    version="1.0.0",
    description="AI microservice for semantic similarity, skill extraction, and resume-job matching insights."
)

app.include_router(router)


@app.get("/health")
def health_check():
    return {
        "status": "UP",
        "message": "AI service is running"
    }