package org.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;


@ExtendWith(MockitoExtension.class)
class ExampleBeanServiceImplTest {
       
       @InjectMocks
       private ExampleBeanServiceImpl exampleBeanService;
       
       @Mock
       //ta zaślepka zwraca null, jeśli jej nie zdefiniujemy w when
       private InjectedBeanService injectedBeanService;
       
       //    @BeforeEach możemy użyć zamiast  @InjectMocks i  @Mock
//       @BeforeEach
//       void init(){
//               this.injectedBeanService = Mockito.mock(InjectedBeanService.class);
//               this.exampleBeanService = new ExampleBeanServiceImpl();
//               this.exampleBeanService.setInjectedBeanService((injectedBeanService));
//
//       }
       
       
//       @ParameterizedTest
//       @MethodSource
//       void paramMethod(String val1, String val2){
//
//               Mockito.when(injectedBeanService.sampleMethod("some2")).thenReturn(val1);
//               Mockito.when(injectedBeanService.sampleMethod("some2")).thenReturn(val2);
//
//               String res = exampleBeanService.sampleMethod2("cos");
//
//               Mockito.verify(injectedBeanService,Mockito.times(1)).sampleMethod("nic");
//
//
//
//       }
//       static Stream<Arguments> paramMethod(){
//               return Stream.of(
//                       Arguments.of("a","b"),
//                       Arguments.of("c","d"),
//                       Arguments.of("e","r")
//               );
//       }
       
       
       
       
        
//        @Test
//        void sampleMethod2(){
//
//
//                //jeśli wpadnie cokolwiek - any() - do metody w miejsce zaślepki, toto zwróc taką wartość "my stub
//                // value"
////                eq("val1)",anyString()) - uzycie przy kilku argumentach
//                //jeśli wartości są niedopasowane to zwraca null
//
//                Mockito.when(injectedBeanService.sampleMethod(ArgumentMatchers.any())).thenReturn("my stub value");
//
////                ExampleBeanService exampleBeanService = new ExampleBeanServiceImpl();
//
////                //implementacja klasą statyczną bez mockito
////                exampleBeanService.setInjectedBeanService(new stubInjectedBeanService());
////                //można też implementować lambdą bez mockito:
////                exampleBeanService.setInjectedBeanService(()->true);
//
////                boolean res = exampleBeanService.sampleMethod2();
//
//                String res1 = exampleBeanService.sampleMethod2("val1");
//                String res2 = exampleBeanService.sampleMethod2("val2");
//                String res3 = exampleBeanService.sampleMethod2("val3");
//
//
//                Assertions.assertEquals(true,res1);
//
//
//        };
        
//        static class stubInjectedBeanService implements InjectedBeanService{
//
//                @Override
//                public boolean sampleMethod() {
//                        return true;
//                }
//        }

}