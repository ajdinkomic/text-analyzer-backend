package dev.ajdinkomic.textanalyzer.model;

import dev.ajdinkomic.textanalyzer.enumeration.AnalysisParameterEnum;

import javax.validation.constraints.NotBlank;

public record UserInput(
        @NotBlank
        String text,
        AnalysisParameterEnum parameter) {
}
