package org.kalkulatorHipo.services;

import org.kalkulatorHipo.model.InputData;
import org.kalkulatorHipo.model.Installment;
import org.kalkulatorHipo.model.InstallmentAmounts;
import org.kalkulatorHipo.model.MortgageReference;

public interface ReferenceCalculationService {

    MortgageReference calculate(InstallmentAmounts installmentAmounts, InputData inputData);

    MortgageReference calculate(InstallmentAmounts installmentAmounts, final InputData inputData, Installment previousInstallment);

}
