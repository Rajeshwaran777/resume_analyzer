package com.example.resumeanalyzer.service;

import com.example.resumeanalyzer.exception.FileProcessingException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class FileParserService {

    public String extractText(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new FileProcessingException("File must not be empty");
        }

        String fileName = file.getOriginalFilename();
        if (fileName == null || fileName.isBlank()) {
            throw new FileProcessingException("Invalid file name");
        }

        String lowerFileName = fileName.toLowerCase();

        try {
            if (lowerFileName.endsWith(".txt")) {
                return new String(file.getBytes(), StandardCharsets.UTF_8);
            }

            if (lowerFileName.endsWith(".pdf")) {
                try (PDDocument document = Loader.loadPDF(file.getBytes())) {
                    PDFTextStripper stripper = new PDFTextStripper();
                    return stripper.getText(document);
                }
            }
        } catch (IOException e) {
            throw new FileProcessingException("Failed to read file content", e);
        }

        throw new FileProcessingException("Only PDF and TXT files are supported");
    }
}