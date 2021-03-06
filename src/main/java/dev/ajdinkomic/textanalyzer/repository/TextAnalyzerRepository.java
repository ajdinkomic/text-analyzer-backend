package dev.ajdinkomic.textanalyzer.repository;

import dev.ajdinkomic.textanalyzer.enumeration.AnalysisParameterEnum;
import dev.ajdinkomic.textanalyzer.helper.Helper;
import dev.ajdinkomic.textanalyzer.model.TextAnalyzer;
import dev.ajdinkomic.textanalyzer.model.UserInput;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.UUID;

@Repository
public class TextAnalyzerRepository {

    public TextAnalyzer analyzeText(UserInput userInput) {
        // Return null if text or parameter is incorrect
        if (userInput == null || userInput.text() == null || userInput.text().isBlank() || userInput.parameter() == null ||
                (userInput.parameter() != AnalysisParameterEnum.VOWELS && userInput.parameter() != AnalysisParameterEnum.CONSONANTS)) {
            return null;
        }

        // Start timer
        long timerStart = System.nanoTime();

        // Transform text to lower case and replace all non-letter characters with empty string
        String text = userInput.text().toLowerCase().replaceAll("[^a-z]+", "");

        if (userInput.parameter().equals(AnalysisParameterEnum.VOWELS)) {
            // Remove all consonants
            text = text.replaceAll("[^aeiou]+", "");
        } else {
            // Remove all vowels
            text = text.replaceAll("[aeiou]+", "");
        }

        // Store analysis result to HashMap by iterating over text
        HashMap<Character, Integer> analysisResult = new HashMap<>();

        for (Character currentChar : text.toCharArray()) {
            analysisResult.put(currentChar, analysisResult.getOrDefault(currentChar, 0) + 1);
        }

        // End timer and calculate time elapsed
        long timerEnd = System.nanoTime();
        long timeElapsed = timerEnd - timerStart;

        // Convert time elapsed to milliseconds and round to three decimal places
        BigDecimal analysisDuration = Helper.roundToThreeDecimalPlaces(timeElapsed);

        return new TextAnalyzer(
                UUID.randomUUID().toString(),
                userInput,
                analysisResult,
                analysisDuration
        );
    }
}
