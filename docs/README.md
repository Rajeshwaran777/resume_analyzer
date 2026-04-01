# 🚀 AI-Powered Resume Analyzer API

A Spring Boot REST API that analyzes resumes against job descriptions using keyword extraction and match scoring.  
Supports file uploads, stores results in PostgreSQL, and provides searchable analysis history.

---

## 📌 Features

- 📄 Analyze resume text
- 📂 Upload and analyze PDF/TXT resumes
- 🧠 Keyword extraction (skills, tech)
- 📊 Match percentage scoring
- 💾 PostgreSQL persistence (Docker)
- 🔍 Search history by file name
- 🎯 Filter history by match score
- 📚 Swagger API documentation

---

## 🛠️ Tech Stack

- Java 25  
- Spring Boot 4  
- Spring Data JPA  
- PostgreSQL (Docker)  
- Maven  
- Swagger (OpenAPI)  

---

## ⚙️ How to Run the Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/YOUR_USERNAME/resume-analyzer.git
cd resume-analyzer/backend
```

### 2️⃣ Start PostgreSQL using Docker
```bash
docker compose up -d
```

### 3️⃣ Run the Spring Boot application
```bash
./mvnw spring-boot:run
```

### 4️⃣ Open Swagger UI
```bash
http://localhost:8080/swagger-ui/index.html
```

---

## 📷 Screenshots

### 🔹 Swagger API Overview

![Swagger API Overview](C:\Rajesh\Projects\javascript\resume-analyzer\docs\screenshots\swagger-ui-overview.jpeg)

### 🔹 Resume Analysis (Text Input)

![Resume Analysis (Text Input)](C:\Rajesh\Projects\javascript\resume-analyzer\docs\screenshots\analyze-text-response.jpeg)

### 🔹 Analysis History (Stored Data)

![Analysis History (Stored Data)](C:\Rajesh\Projects\javascript\resume-analyzer\docs\screenshots\history-response-1.jpeg)

![Analysis History (Stored Data)](C:\Rajesh\Projects\javascript\resume-analyzer\docs\screenshots\history-response-2.jpeg)

![Analysis History (Stored Data)](C:\Rajesh\Projects\javascript\resume-analyzer\docs\screenshots\history-response-3.jpeg)

### 🔹 PostgreSQL Stored Records

![PostgreSQL Stored Records](C:\Rajesh\Projects\javascript\resume-analyzer\docs\screenshots\postgres-table-data.jpeg)

---

## 📡 API Endpoints

### Resume Analysis
- POST /api/analysis/analyze-text
- POST /api/analysis/analyze-file

### Analysis History
- GET /api/analysis/history
- GET /api/analysis/history/id/{id}
- GET /api/analysis/history/search?fileName=...
- GET /api/analysis/history/filter?minScore=...

### Health
- GET /api/health

---

## 🧪 Example Request

### Analyze Resume Text

#### POST /api/analysis/analyze-text
```json
{
  "resumeText": "Java Spring Boot REST API MySQL Maven Git Docker",
  "jobDescription": "Looking for a Java developer with Spring Boot, REST API, MySQL, Git, Docker and AWS experience."
}
```

---

## 🧠 Future Improvements
- React frontend UI
- Authentication (JWT)
- Advanced NLP (ML-based scoring)
- Resume parsing for DOCX
- Pagination + sorting enhancements

---

## 👤 Author

### Rajesh

⭐ If you like this project

Give it a star ⭐ on GitHub


---

## 🔥 Important things you must update

### 1. Replace GitHub URL
```bash
https://github.com/YOUR_USERNAME/resume-analyzer.git
```

### 2. Make sure screenshots exist here:
```bash
docs/screenshots/
```

If paths are wrong → images won’t show on GitHub.