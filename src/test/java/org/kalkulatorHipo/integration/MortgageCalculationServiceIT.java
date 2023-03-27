package org.kalkulatorHipo.integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.util.ResourceUtils;
import org.kalkulatorHipo.configuration.CalculatorConfiguration;
import org.kalkulatorHipo.services.MortgageCalculationService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig(classes = {CalculatorConfiguration.class})
public class MortgageCalculationServiceIT {

    private static final Path RESULT_FILE_PATH = Paths.get("build/generated/calculationResult.txt");
    private static final String EXPECTED_GENERATED_CONTENT = "classpath:expectedGeneratedResult.txt";

    @Autowired
    @SuppressWarnings("unused")
    private MortgageCalculationService mortgageCalculationService;

    @BeforeEach
    public void setUp() {
        assertNotNull(mortgageCalculationService);
    }

    @Test
    @DisplayName("That whole app calculation works correctly")
    void test() {
        // given, when
        mortgageCalculationService.calculate();

        // then
        final var generatedResultContent = readGeneratedResultContent();
        final var expectedGeneratedResultContent = readExpectedGeneratedResultContent();

        for (int i = 0; i < expectedGeneratedResultContent.size(); i++) {
            assertEquals(expectedGeneratedResultContent.get(i), generatedResultContent.get(i));
        }
    }

    private List<String> readGeneratedResultContent() {
        try {
            return Files.readAllLines(RESULT_FILE_PATH);
        } catch (Exception e) {
            Assertions.fail("Reading file failed", e);
        }
        return List.of();
    }

    private List<String> readExpectedGeneratedResultContent() {
        try {
            File file = ResourceUtils.getFile(EXPECTED_GENERATED_CONTENT);
            return Files.readAllLines(file.toPath());
        } catch (Exception e) {
            Assertions.fail("Reading file failed", e);
        }
        return List.of();
    }
}
