package org.kalkulatorHipo.services;

import lombok.Builder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kalkulatorHipo.fixtures.TestDataFixtures;
import org.kalkulatorHipo.model.InputData;
import org.kalkulatorHipo.model.InstallmentAmounts;
import org.kalkulatorHipo.model.MortgageType;
import org.kalkulatorHipo.model.Overpayment;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AmountsCalculationServiceImplTest {

@InjectMocks
private AmountsCalculationServiceImpl amountsCalculationService;

@Mock
private ConstantAmountsCalculationServiceImpl constantAmountsCalculationService;
        

        @Test
        @DisplayName("if switch works correctly")
        void calculate() {
        
                // given
                InputData inputData = TestDataFixtures.someInputData();
                InputData inputData2 = TestDataFixtures.someInputData()
                                               .withInstallmentType(MortgageType.DECREASING);

                Overpayment overpayment = TestDataFixtures.someOverpayment();
                MortgageType expected = MortgageType.CONSTANT;
                MortgageType notexpected = MortgageType.DECREASING;
                MortgageType expected2 = MortgageType.DECREASING;
//                                                      .withCapitalAmount(BigDecimal.valueOf(773.23))
//                                                      .withInterestAmount(BigDecimal.valueOf(743.50))
//                                                      .withInstallmentAmount(BigDecimal.valueOf(1516.73));
        
                // when
                MortgageType result = inputData.installmentType();
                MortgageType result2 = inputData2.installmentType();
        
                // then
                Assertions.assertEquals(expected, result);
                Assertions.assertEquals(expected2, result2);
                Assertions.assertNotEquals(notexpected,result);
                
                
        }
        
//        @Test
//        void testCalculate() {
//        }
}