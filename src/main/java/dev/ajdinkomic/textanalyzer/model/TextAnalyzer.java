package dev.ajdinkomic.textanalyzer.model;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

public record TextAnalyzer(
        String id,
        @NotNull
        UserInput userInput,
        HashMap<Character, Integer> analysisResult,
        Double analysisDuration
) {
}
