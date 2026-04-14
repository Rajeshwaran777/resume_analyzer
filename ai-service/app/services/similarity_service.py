from sentence_transformers import SentenceTransformer 
from sklearn.metrics.pairwise import cosine_similarity


model = SentenceTransformer("all-MiniLM-L6-v2")


def compute_semantic_similarity(resume_text: str, job_description: str) -> float:
    embeddings = model.encode([resume_text, job_description])

    similarity = cosine_similarity(
        [embeddings[0]],
        [embeddings[1]]
    )[0][0]

    percentage = round(float(similarity) * 100, 2)
    return percentage