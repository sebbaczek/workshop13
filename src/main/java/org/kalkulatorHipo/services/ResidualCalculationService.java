package org.kalkulatorHipo.services;

import org.kalkulatorHipo.model.InputData;
import org.kalkulatorHipo.model.Installment;
import org.kalkulatorHipo.model.InstallmentAmounts;
import org.kalkulatorHipo.model.MortgageResidual;

public interface ResidualCalculationService {

    MortgageResidual calculate(InstallmentAmounts installmentAmounts, InputData inputData);

    MortgageResidual calculate(InstallmentAmounts installmentAmounts, final InputData inputData, Installment previousInstallment);

}
