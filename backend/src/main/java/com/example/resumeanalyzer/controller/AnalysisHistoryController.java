package com.example.resumeanalyzer.controller;

import com.example.resumeanalyzer.dto.response.AnalysisHistoryResponse;
import com.example.resumeanalyzer.service.AnalysisHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/analysis/history")
@Tag(name = "Analysis History", description = "Endpoints for retrieving saved analysis history")
public class AnalysisHistoryController {

    private final AnalysisHistoryService analysisHistoryService;

    public AnalysisHistoryController(AnalysisHistoryService analysisHistoryService) {
        this.analysisHistoryService = analysisHistoryService;
    }

    @Operation(summary = "Get paginated analysis history")
    @GetMapping
    public Page<AnalysisHistoryResponse> getHistory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return analysisHistoryService.getHistory(page, size);
    }

    @Operation(summary = "Get one analysis record by ID")
    @GetMapping("/id/{id}")
    public AnalysisHistoryResponse getHistoryById(@PathVariable Long id) {
        return analysisHistoryService.getHistoryById(id);
    }

    @Operation(summary = "Search saved analysis history by resume file name")
    @GetMapping("/search")
    public List<AnalysisHistoryResponse> searchByFileName(@RequestParam String fileName) {
        return analysisHistoryService.searchByFileName(fileName);
    }

    @Operation(summary = "Filter saved analysis history by minimum match percentage")
    @GetMapping("/filter")
    public List<AnalysisHistoryResponse> filterByMinimumScore(@RequestParam double minScore) {
        return analysisHistoryService.getByMinimumMatchPercentage(minScore);
    }
}