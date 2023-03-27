package org.kalkulatorHipo.services;

import org.springframework.stereotype.Service;
import org.kalkulatorHipo.model.InputData;
import org.kalkulatorHipo.model.Installment;
import org.kalkulatorHipo.model.TimePoint;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
public class TimePointCalculationServiceImpl implements TimePointCalculationService {

    public TimePoint calculate(final BigDecimal installmentNumber, final InputData inputData) {
        BigDecimal year = calculateYear(installmentNumber);
        BigDecimal month = calculateMonth(installmentNumber);
        LocalDate date = inputData.repaymentStartDate();
        return new TimePoint(year, month, date);
    }

    public TimePoint calculate(BigDecimal installmentNumber, Installment previousInstallment) {
        BigDecimal year = calculateYear(installmentNumber);
        BigDecimal month = calculateMonth(installmentNumber);
        LocalDate date = previousInstallment.timePoint().date().plus(1, ChronoUnit.MONTHS);
        return new TimePoint(year, month, date);
    }

    private BigDecimal calculateYear(final BigDecimal installmentNumber) {
        return installmentNumber.divide(AmountsCalculationService.YEAR, RoundingMode.UP).max(BigDecimal.ONE);
    }

    private BigDecimal calculateMonth(final BigDecimal installmentNumber) {
        return BigDecimal.ZERO.equals(installmentNumber.remainder(AmountsCalculationService.YEAR))
            ? AmountsCalculationService.YEAR
            : installmentNumber.remainder(AmountsCalculationService.YEAR);
    }

}
