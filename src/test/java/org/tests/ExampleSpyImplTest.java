package org.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExampleSpyImplTest {
        
        @InjectMocks
        private ExampleSpyImpl exampleSpy;
        
        //Spy działa na prawdziwym obiekcie który utworzymy, dlatego tworzymy tutaj new ArrayList; jeśli tego nie
        // zrobimy mockito wstawi swoją implementację, a nie null jak w przypadku mocków
//        jeśli wywołalibyśmy tutaj Mock a nie Spy, to test nie przejdzie bo mock nie tworzy prawdziwej listy, i jej
//        długość będzie zatem 0
        @Spy
        private List<String> sampleList = new ArrayList<>();
        
        //spy nie zwraca nulla jeśli nie podamy wartości, ale stosuje implementację
        
        
        @Test
        void thatSampleMethod_whenOneValueToAdd() {
        String testVal = "testVal";
        
        exampleSpy.sampleMethod(testVal);
        
                Mockito.verify(sampleList).add(Mockito.anyString());
                Mockito.verify(sampleList).add(testVal);
                Assertions.assertEquals(1,sampleList.size());
                
        }
        @Test
        void thatSampleMethod_whenTwoValuesToAdd() {
        
                String testVal1 = "testVal1";
                String testVal2 = "testVal2";
                
                exampleSpy.sampleMethod(testVal1,testVal2);
        
                //domyślnie times(1)
                Mockito.verify(sampleList,Mockito.times(2)).add(Mockito.anyString());
                Mockito.verify(sampleList).add(testVal1);
                Mockito.verify(sampleList).add(testVal2);
                Assertions.assertEquals(2,sampleList.size());
        }
}