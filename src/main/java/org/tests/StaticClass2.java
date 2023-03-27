package org.tests;

import java.time.LocalTime;

public class StaticClass2 {
        public  int getNano(){
                LocalTime now = LocalTime.now();
                return now.getNano();
        }
        
        // LocalTime.now() jest metodą statyczną którą owrapowaliśmy zwykłą metodą aby zrobić test bo wtedy można dopiero wywołać ją na obiekcie
}
