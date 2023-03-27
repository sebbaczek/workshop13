package org.kalkulatorHipo.services;

import org.kalkulatorHipo.model.InputData;
import org.kalkulatorHipo.model.Installment;
import org.kalkulatorHipo.model.InstallmentAmounts;
import org.kalkulatorHipo.model.Overpayment;

public interface DecreasingAmountsCalculationService {

    InstallmentAmounts calculate(InputData inputData, Overpayment overpayment);

    InstallmentAmounts calculate(InputData inputData, Overpayment overpayment, Installment previousInstallment);
}
