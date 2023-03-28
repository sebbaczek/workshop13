package org.ex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.tests.AnotherSomeClass;
import org.tests.SomeClass;

@ExtendWith(MockitoExtension.class)
public class SomeClassTest {

        @InjectMocks
        private SomeClass someClass;
        
        @Mock
//        @Spy
        private AnotherSomeClass anotherSomeClass;
        
//        @Test
//        void someTest(){
//                Mockito.when(anotherSomeClass);
//        }
        
        @Test
        void someTest2(){
                //stub, żeby był mock trzeba jeszcze zdefiniować verify
                Mockito.when(anotherSomeClass.someOtherMethod()).thenReturn("ttt");
                // w teście będzie zaślepka ttt zamiast wyniku metody someOtherMethod
                someClass.someMethod();
        }
}
