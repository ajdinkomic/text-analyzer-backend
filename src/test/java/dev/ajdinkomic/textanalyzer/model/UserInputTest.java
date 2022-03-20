package dev.ajdinkomic.textanalyzer.model;

import dev.ajdinkomic.textanalyzer.enumeration.AnalysisParameterEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserInputTest {

    @Test
    void create_new_record_user_input() {
        UserInput userInput = new UserInput(
                "Testing a random sentence.",
                AnalysisParameterEnum.VOWELS
        );

        assertNotNull(userInput);
        assertEquals("Testing a random sentence.", userInput.text(), "Text is incorrect!");
        assertTrue(userInput.getClass().isRecord());
        assertEquals(2, userInput.getClass().getRecordComponents().length);
    }
}
