package org.kalkulatorHipo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.kalkulatorHipo.model.InputData;
import org.kalkulatorHipo.model.Installment;
import org.kalkulatorHipo.model.InstallmentAmounts;
import org.kalkulatorHipo.model.Overpayment;

@Service
@AllArgsConstructor
public class AmountsCalculationServiceImpl implements AmountsCalculationService {

    private final org.kalkulatorHipo.services.ConstantAmountsCalculationService constantAmountsCalculationService;

    private final org.kalkulatorHipo.services.DecreasingAmountsCalculationService decreasingAmountsCalculationService;

    @Override
    public InstallmentAmounts calculate(final InputData inputData, final Overpayment overpayment) {
        return switch (inputData.installmentType()) {
            case CONSTANT -> constantAmountsCalculationService.calculate(inputData, overpayment);
            case DECREASING -> decreasingAmountsCalculationService.calculate(inputData, overpayment);
        };
    }

    @Override
    public InstallmentAmounts calculate(final InputData inputData, final Overpayment overpayment, final Installment previousInstallment) {
        return switch (inputData.installmentType()) {
            case CONSTANT -> constantAmountsCalculationService.calculate(inputData, overpayment, previousInstallment);
            case DECREASING -> decreasingAmountsCalculationService.calculate(inputData, overpayment, previousInstallment);
        };
    }


}
