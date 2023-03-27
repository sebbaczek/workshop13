package org.kalkulatorHipo.services;

import org.kalkulatorHipo.model.Installment;
import org.kalkulatorHipo.model.Summary;

import java.util.List;

public interface SummaryService {

    Summary calculateSummary(List<Installment> installments);
}
