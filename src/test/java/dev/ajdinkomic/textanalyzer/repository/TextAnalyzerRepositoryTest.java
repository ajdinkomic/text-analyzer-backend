package dev.ajdinkomic.textanalyzer.repository;

import dev.ajdinkomic.textanalyzer.enumeration.AnalysisParameterEnum;
import dev.ajdinkomic.textanalyzer.model.TextAnalyzer;
import dev.ajdinkomic.textanalyzer.model.UserInput;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


class TextAnalyzerRepositoryTest {

    private final TextAnalyzerRepository repository = new TextAnalyzerRepository();

    @Test
    void shouldAnalyzeForVowels() {
        UserInput userInput = new UserInput(
                "Random sentence to be analyzed.!\"#$%&/()=?*-_.:,;@{}[]€|\\÷×¤ß~ˇ^~˘°˛`˙´˝¨¸§<>Łł",
                AnalysisParameterEnum.VOWELS
        );

        TextAnalyzer actualTextAnalyzer = repository.analyzeText(userInput);
        assertNotNull(actualTextAnalyzer);
        assertEquals(userInput, actualTextAnalyzer.userInput());

        HashMap<Character, Integer> expectedAnalysisResult = new HashMap<>();
        expectedAnalysisResult.put('a', 3);
        expectedAnalysisResult.put('e', 5);
        expectedAnalysisResult.put('o', 2);

        assertEquals(expectedAnalysisResult, actualTextAnalyzer.analysisResult());
    }

    @Test
    void shouldAnalyzeForConsonants() {
        UserInput userInput = new UserInput(
                "Random sentence to be analyzed.!\"#$%&/()=?*-_.:,;@{}[]€|\\÷×¤ß~ˇ^~˘°˛`˙´˝¨¸§<>Łł",
                AnalysisParameterEnum.CONSONANTS
        );

        TextAnalyzer actualTextAnalyzer = repository.analyzeText(userInput);
        assertNotNull(actualTextAnalyzer);
        assertEquals(userInput, actualTextAnalyzer.userInput());

        HashMap<Character, Integer> expectedAnalysisResult = new HashMap<>();
        expectedAnalysisResult.put('r', 1);
        expectedAnalysisResult.put('n', 4);
        expectedAnalysisResult.put('d', 2);
        expectedAnalysisResult.put('m', 1);
        expectedAnalysisResult.put('s', 1);
        expectedAnalysisResult.put('t', 2);
        expectedAnalysisResult.put('c', 1);
        expectedAnalysisResult.put('b', 1);
        expectedAnalysisResult.put('l', 1);
        expectedAnalysisResult.put('y', 1);
        expectedAnalysisResult.put('z', 1);

        assertEquals(expectedAnalysisResult, actualTextAnalyzer.analysisResult());
    }

    @Test
    void shouldAnalyzeForIncorrectParameter() {
        UserInput userInput = new UserInput(
                "Random sentence to be analyzed.!\"#$%&/()=?*-_.:,;@{}[]€|\\÷×¤ß~ˇ^~˘°˛`˙´˝¨¸§<>Łł",
                AnalysisParameterEnum.NONE
        );

        TextAnalyzer actualTextAnalyzer = repository.analyzeText(userInput);
        assertNull(actualTextAnalyzer);
    }

    @Test
    void shouldAnalyzeNullTextForVowels() {
        UserInput userInput = new UserInput(
                null,
                AnalysisParameterEnum.VOWELS
        );

        TextAnalyzer actualTextAnalyzer = repository.analyzeText(userInput);
        assertNull(actualTextAnalyzer);
    }

    @Test
    void shouldAnalyzeNullTextForConsonants() {
        UserInput userInput = new UserInput(
                null,
                AnalysisParameterEnum.CONSONANTS
        );

        TextAnalyzer actualTextAnalyzer = repository.analyzeText(userInput);
        assertNull(actualTextAnalyzer);
    }

    @Test
    void shouldAnalyzeBlankTextForVowels() {
        UserInput userInput = new UserInput(
                "  ",
                AnalysisParameterEnum.VOWELS
        );

        TextAnalyzer actualTextAnalyzer = repository.analyzeText(userInput);
        assertNull(actualTextAnalyzer);
    }

    @Test
    void shouldAnalyzeBlankTextForConsonants() {
        UserInput userInput = new UserInput(
                "  ",
                AnalysisParameterEnum.CONSONANTS
        );

        TextAnalyzer actualTextAnalyzer = repository.analyzeText(userInput);
        assertNull(actualTextAnalyzer);
    }

    @Test
    void shouldAnalyzeOnlyNonLettersForVowels() {
        UserInput userInput = new UserInput(
                ".!\"#$%&/()=?*-_.:,;@{}[]€|\\÷×¤ß~ˇ^~˘°˛`˙´˝¨¸§<>Łł",
                AnalysisParameterEnum.VOWELS
        );

        TextAnalyzer actualTextAnalyzer = repository.analyzeText(userInput);
        assertNotNull(actualTextAnalyzer);
        assertEquals(userInput, actualTextAnalyzer.userInput());
        assertEquals(0, actualTextAnalyzer.analysisResult().size());
    }

    @Test
    void shouldAnalyzeOnlyNonLettersForConsonants() {
        UserInput userInput = new UserInput(
                ".!\"#$%&/()=?*-_.:,;@{}[]€|\\÷×¤ß~ˇ^~˘°˛`˙´˝¨¸§<>Łł",
                AnalysisParameterEnum.VOWELS
        );

        TextAnalyzer actualTextAnalyzer = repository.analyzeText(userInput);
        assertNotNull(actualTextAnalyzer);
        assertEquals(userInput, actualTextAnalyzer.userInput());
        assertEquals(0, actualTextAnalyzer.analysisResult().size());
    }
}
