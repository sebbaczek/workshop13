package org.kalkulatorHipo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.kalkulatorHipo.configuration.CalculatorConfiguration;
import org.kalkulatorHipo.services.MortgageCalculationService;

public class MortgageCalculatorApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);
        MortgageCalculationService mortgageCalculationService = context.getBean(MortgageCalculationService.class);
        mortgageCalculationService.calculate();
    }
}
