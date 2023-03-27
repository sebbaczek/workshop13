package org.tests;

import java.time.LocalTime;

public class StaticClass {
        public  int getNano(){
                LocalTime now = getNow();
                return now.getNano();
        }
        
        // LocalTime.now() jest metodą statyczną którą owrapowaliśmy zwykłą metodą aby zrobić test bo wtedy można dopiero wywołać ją na obiekcie
        public LocalTime getNow() {
                return LocalTime.now();
        }
}
