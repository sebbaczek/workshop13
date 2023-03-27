package org.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class StaticClassTest {
        
        @Spy
        private  StaticClass staticClass = new StaticClass();
        @Test
        void testGetNano() {
                LocalTime now1 = LocalTime.now();
                int now = now1.getNano();
                LocalTime earilier = now1.minusNanos(100);
                int nanoEarlier = earilier.getNano();
                Mockito.when(staticClass.getNow()).thenReturn(earilier);
                
                
                int res = staticClass.getNano();
                
                Assertions.assertNotEquals(res,now);
                Assertions.assertEquals(res,nanoEarlier);
        }
}