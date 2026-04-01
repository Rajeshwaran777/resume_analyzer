package com.example.resumeanalyzer.controller;

import com.example.resumeanalyzer.dto.request.AnalyzeTextRequest;
import com.example.resumeanalyzer.dto.response.AnalyzeResponse;
import com.example.resumeanalyzer.service.FileParserService;
import com.example.resumeanalyzer.service.ResumeAnalysisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/analysis")
@Tag(name = "Resume Analysis", description = "Endpoints for analyzing resumes")
public class ResumeAnalysisController {

    private final ResumeAnalysisService resumeAnalysisService;
    private final FileParserService fileParserService;

    public ResumeAnalysisController(ResumeAnalysisService resumeAnalysisService,
                                    FileParserService fileParserService) {
        this.resumeAnalysisService = resumeAnalysisService;
        this.fileParserService = fileParserService;
    }

    @Operation(summary = "Analyze resume text against a job description")
    @PostMapping("/analyze-text")
    public AnalyzeResponse analyzeText(@Valid @RequestBody AnalyzeTextRequest request) {
        return resumeAnalysisService.analyzeText(
                request.getResumeText(),
                request.getJobDescription()
        );
    }

    @Operation(summary = "Analyze uploaded resume file against a job description")
    @PostMapping(value = "/analyze-file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public AnalyzeResponse analyzeFile(@RequestParam("file") MultipartFile file,
                                       @RequestParam("jobDescription") String jobDescription) {
        String resumeText = fileParserService.extractText(file);
        String fileName = file.getOriginalFilename();
        return resumeAnalysisService.analyzeFile(fileName, resumeText, jobDescription);
    }
}