package dev.ajdinkomic.textanalyzer.model;

import dev.ajdinkomic.textanalyzer.enumeration.AnalysisParameterEnum;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TextAnalyzerTest {

    @Test
    void create_new_record_text_analyzer() {
        UserInput userInput = new UserInput(
                "Testing a random sentence.",
                AnalysisParameterEnum.CONSONANTS
        );

        HashMap<Character, Integer> analysisResult = new HashMap<>();
        analysisResult.put('A', 5);
        analysisResult.put('B', 10);
        analysisResult.put('C', 15);

        TextAnalyzer textAnalyzer = new TextAnalyzer(
                UUID.randomUUID().toString(),
                userInput,
                analysisResult,
                0.2729
        );

        assertNotNull(textAnalyzer);
        assertEquals(0.2729, textAnalyzer.analysisDuration(), "Analysis duration is incorrect!");
        assertTrue(textAnalyzer.getClass().isRecord());
        assertEquals(4, textAnalyzer.getClass().getRecordComponents().length);
    }
}
