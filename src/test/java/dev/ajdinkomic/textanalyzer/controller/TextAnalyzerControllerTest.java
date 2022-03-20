package dev.ajdinkomic.textanalyzer.controller;

import dev.ajdinkomic.textanalyzer.enumeration.AnalysisParameterEnum;
import dev.ajdinkomic.textanalyzer.model.TextAnalyzer;
import dev.ajdinkomic.textanalyzer.model.UserInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class TextAnalyzerControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void analyze() {
        UserInput userInput = new UserInput(
                "Random sentence to be analyzed.",
                AnalysisParameterEnum.VOWELS
        );

        ResponseEntity<TextAnalyzer> entity = restTemplate.postForEntity("/text-analyzer", userInput, TextAnalyzer.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());

        TextAnalyzer textAnalyzer = entity.getBody();
        assertNotNull(textAnalyzer);
        assertEquals(textAnalyzer.userInput(), userInput);

        HashMap<Character, Integer> analysisResult = new HashMap<>();
        analysisResult.put('a', 3);
        analysisResult.put('e', 5);
        analysisResult.put('o', 2);
        assertEquals(textAnalyzer.analysisResult(), analysisResult);
    }
}
