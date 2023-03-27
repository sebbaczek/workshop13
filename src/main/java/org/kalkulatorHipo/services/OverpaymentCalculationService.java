package org.kalkulatorHipo.services;

import org.kalkulatorHipo.model.InputData;
import org.kalkulatorHipo.model.Overpayment;

import java.math.BigDecimal;

public interface OverpaymentCalculationService {

    Overpayment calculate(final BigDecimal installmentNumber, final InputData inputData);
}
