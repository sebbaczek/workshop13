package org.kalkulatorHipo.services;

import org.kalkulatorHipo.model.InputData;
import org.kalkulatorHipo.model.Installment;
import org.kalkulatorHipo.model.TimePoint;

import java.math.BigDecimal;

public interface TimePointCalculationService {

    TimePoint calculate(final BigDecimal installmentNumber, final InputData inputData);

    TimePoint calculate(BigDecimal installmentNumber, Installment previousInstallment);

}
