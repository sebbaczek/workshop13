package org.kalkulatorHipo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.kalkulatorHipo.MortgageCalculatorApplication;
import org.kalkulatorHipo.model.Installment;
import org.kalkulatorHipo.model.InstallmentAmounts;
import org.kalkulatorHipo.model.Summary;
import org.kalkulatorHipo.services.SummaryService;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

@Configuration
@ComponentScan(basePackageClasses = MortgageCalculatorApplication.class)
public class CalculatorConfiguration {

    @Bean
    public static SummaryService summaryService() {
        return installments -> {
            BigDecimal interestSum = calculate(installments, installment -> installment.installmentAmounts().interestAmount());
            BigDecimal overpaymentProvisionSum = calculate(installments, installment -> installment.installmentAmounts().overpayment().provisionAmount());
            BigDecimal totalLostSum = interestSum.add(overpaymentProvisionSum);
            BigDecimal totalCapital = calculate(installments, installment -> totalCapital(installment.installmentAmounts()));
            return new Summary(interestSum, overpaymentProvisionSum, totalLostSum, totalCapital);
        };
    }

    private static BigDecimal totalCapital(final InstallmentAmounts installmentAmounts) {
        return installmentAmounts.capitalAmount().add(installmentAmounts.overpayment().amount());
    }

    private static BigDecimal calculate(final List<Installment> installments, Function<Installment, BigDecimal> function) {
        return installments.stream()
            .reduce(BigDecimal.ZERO, (sum, next) -> sum.add(function.apply(next)), BigDecimal::add);
    }

}
