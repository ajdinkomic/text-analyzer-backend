package dev.ajdinkomic.textanalyzer.controller;

import dev.ajdinkomic.textanalyzer.model.TextAnalyzer;
import dev.ajdinkomic.textanalyzer.model.UserInput;
import dev.ajdinkomic.textanalyzer.repository.TextAnalyzerRepository;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/text-analyzer")
public class TextAnalyzerController {

    private final TextAnalyzerRepository repository;
    private final String origins = "http://localhost:4200";

    public TextAnalyzerController(TextAnalyzerRepository repository) {
        this.repository = repository;
    }

    // POST http://localhost:8080/text-analyzer
    @CrossOrigin(origins)
    @PostMapping
    public TextAnalyzer analyze(@Valid @RequestBody UserInput userInput) {
        return repository.analyzeText(userInput);
    }
}
