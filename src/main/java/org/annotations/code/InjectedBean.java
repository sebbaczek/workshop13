package org.annotations.code;

import org.springframework.stereotype.Service;

@Service
public class InjectedBean {
        public InjectedBean() {
                System.out.println("InjectedBean");
        }
        
        public void method(){
                System.out.println("injected method");
        }
        
}
