package org.kalkulatorHipo.services;

import org.kalkulatorHipo.model.InputData;
import org.kalkulatorHipo.model.Installment;

import java.util.List;

public interface InstallmentCalculationService {

    List<Installment> calculate(InputData inputData);
}
