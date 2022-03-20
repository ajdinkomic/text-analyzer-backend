package dev.ajdinkomic.textanalyzer.repository;

import dev.ajdinkomic.textanalyzer.enumeration.AnalysisParameterEnum;
import dev.ajdinkomic.textanalyzer.model.TextAnalyzer;
import dev.ajdinkomic.textanalyzer.model.UserInput;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.UUID;

@Repository
public class TextAnalyzerRepository {

    public TextAnalyzer analyzeText(UserInput userInput) {
        Long timerStart = System.nanoTime();
        HashMap<Character, Integer> analysisResult = new HashMap<>();

        // Transform text to lower case and replace all non-letter characters with empty string
        String text = userInput.text().toLowerCase().replaceAll("[^a-zA-Z]+", "");

        if (userInput.parameter().equals(AnalysisParameterEnum.VOWELS)) {
            // Remove all consonants
            text = text.replaceAll("[^aeiou]+", "");
        } else {
            // Remove all vowels
            text = text.replaceAll("[aeiou]+", "");
        }

        for (int i = 0; i < text.length(); i++) {
            analysisResult.put(text.charAt(i), analysisResult.getOrDefault(text.charAt(i), 0) + 1);
        }

        Long timerEnd = System.nanoTime();
        Long duration = (timerEnd - timerStart);

        return new TextAnalyzer(
                UUID.randomUUID().toString(),
                userInput,
                analysisResult,
                duration
        );
    }
}
