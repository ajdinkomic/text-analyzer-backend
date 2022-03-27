package dev.ajdinkomic.textanalyzer.repository;

import dev.ajdinkomic.textanalyzer.enumeration.AnalysisParameterEnum;
import dev.ajdinkomic.textanalyzer.model.TextAnalyzer;
import dev.ajdinkomic.textanalyzer.model.UserInput;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.UUID;

@Repository
public class TextAnalyzerRepository {

    private static double roundToFour(double doubleValue) {
        // Using BigDecimal(String) constructor for preventing issues with inexact values
        BigDecimal bigDecimalValue = new BigDecimal(Double.toString(doubleValue));
        bigDecimalValue = bigDecimalValue.setScale(4, RoundingMode.HALF_UP);
        return bigDecimalValue.doubleValue();
    }

    public TextAnalyzer analyzeText(UserInput userInput) {
        long timerStart = System.nanoTime();
        HashMap<Character, Integer> analysisResult = new HashMap<>();

        // Transform text to lower case and replace all non-letter characters with empty string
        String text = userInput.text().toLowerCase().replaceAll("[^a-z]+", "");

        if (userInput.parameter().equals(AnalysisParameterEnum.VOWELS)) {
            // Remove all consonants
            text = text.replaceAll("[^aeiou]+", "");
        } else {
            // Remove all vowels
            text = text.replaceAll("[aeiou]+", "");
        }

        for (Character currentChar : text.toCharArray()) {
            analysisResult.put(currentChar, analysisResult.getOrDefault(currentChar, 0) + 1);
        }

        long timerEnd = System.nanoTime();
        Double duration = roundToFour((double) (timerEnd - timerStart) / 1000000);

        return new TextAnalyzer(
                UUID.randomUUID().toString(),
                userInput,
                analysisResult,
                duration
        );
    }
}
