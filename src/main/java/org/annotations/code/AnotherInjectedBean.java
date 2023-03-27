package org.annotations.code;

import org.springframework.stereotype.Component;

@Component
public class AnotherInjectedBean {
        public AnotherInjectedBean() {
                System.out.println("AnotherInjectedBean");
        }
}
