package org.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

//użycie biblioteki inline do mocka na metodzie statycznej; nie potrzeba już używać Spy

@ExtendWith(MockitoExtension.class)
class StaticClass2Test {
        
        @Spy
        private  StaticClass2 staticClass2 = new StaticClass2();
        @Test
        void testGetNano() {
                LocalTime now1 = LocalTime.now();
                int now = now1.getNano();
                LocalTime earilier = now1.minusNanos(100);
                int nanoEarlier = earilier.getNano();
                
//                Mockito.when(staticClass2.getNow()).thenReturn(earilier);
        
        
                int res;
                try(MockedStatic<LocalTime> timeMock =
                        Mockito.mockStatic(LocalTime.class)) {
                        timeMock.when(LocalTime::now).thenReturn(earilier);
        
                         res = staticClass2.getNano();
                }
                
                Assertions.assertNotEquals(res,now);
                Assertions.assertEquals(res,nanoEarlier);
        }
}