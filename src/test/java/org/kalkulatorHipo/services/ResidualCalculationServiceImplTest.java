package org.kalkulatorHipo.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kalkulatorHipo.fixtures.TestDataFixtures;
import org.kalkulatorHipo.model.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ResidualCalculationServiceImplTest {
        
       
        @InjectMocks
        private ResidualCalculationServiceImpl residualCalculationService;
//        @Mock
//        private InstallmentAmounts installmentAmounts;
//        @Mock
//        private Overpayment overpayment;
   
        
        @Test
        void calculate() {
                final var inputData = TestDataFixtures.someInputData();
                final var inputData2 = TestDataFixtures.someInputData().withAmount(BigDecimal.ZERO);
                final var expected = TestDataFixtures.someMortgageResidual().withResidualAmount(BigDecimal.valueOf(
                        196239.21)).withResidualDuration(BigDecimal.valueOf(178));
                final var expected2 =
                        TestDataFixtures.someMortgageResidual().withResidualAmount(BigDecimal.ZERO).withResidualDuration(BigDecimal.ZERO);
                final var overpayment = TestDataFixtures.someOverpayment();
                final var installmentAmounts = TestDataFixtures.someInstallmentAmounts().withOverpayment(overpayment);
//                when(residualCalculationService.calculate(any(InstallmentAmounts.class), inputData))
//                        .thenReturn(new MortgageResidual(BigDecimal.ZERO,BigDecimal.ZERO));
//                when(residualCalculationService.calculate(TestDataFixtures.someInstallmentAmounts().withOverpayment(TestDataFixtures.someOverpayment()), inputData))
//                        .thenReturn(new MortgageResidual(any(BigDecimal.class),any(BigDecimal.class)));
        

        
                // when
                final var result = residualCalculationService.calculate(installmentAmounts, inputData);
                final var result2 = residualCalculationService.calculate(installmentAmounts, inputData2);
                final var result3 = residualCalculationService.calculate(installmentAmounts, inputData2,
                        getPreviousInstallment());
        
                // then
                Assertions.assertEquals(expected, result);
                Assertions.assertEquals(expected2, result2);
                Assertions.assertEquals(expected2, result3);
                
                
                
        }
        
        private static Installment getPreviousInstallment() {
                return TestDataFixtures.someInstallment().withMortgageResidual(new MortgageResidual(BigDecimal.ZERO,
                        BigDecimal.ZERO));
        }

//        @Test
//        void testCalculate() {
//        }
}