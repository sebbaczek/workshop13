package org.tests;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class ExParamsCoreImplTest {
        
        @InjectMocks
        private ExParamsCoreImpl exParamsCoreImpl;
        
        @Mock
        private ParamsService paramsService;
        
        @ParameterizedTest
        @MethodSource
        void executeParamsMethod(String val1, String val2) {
        
        //given
                //mockowanie własnymi wartościami ze streama metod z klasy wstrzykiwanej
                Mockito.when(paramsService.method1()).thenReturn(val1);
                Mockito.when(paramsService.method2()).thenReturn(val2);

        //when
                //wywołanie metody z klasy testowanej, która wywołuje wstrzykiwane metody
        String result = exParamsCoreImpl.executeParamsMethod();
        
        //then
                //sprawdzenie czy wywołane metody z zaślepkami nie dają błędów
        Mockito.verify(paramsService,Mockito.times(1)).method1();
        Mockito.verify(paramsService,Mockito.times(1)).method2();
       
        }
               static Stream<Arguments> executeParamsMethod(){
               return Stream.of(
                       Arguments.of("a","b"),
                       Arguments.of("c","d"),
                       Arguments.of("e","r")
               );
       }
       
       
       
       
}