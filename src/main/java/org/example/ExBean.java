package org.example;

public class ExBean {
        
        private final InjectedBean injectedBean;
        private final AnotherInjectedBean anotherInjectedBean;
        
        public ExBean(InjectedBean injectedBean, AnotherInjectedBean anotherInjectedBean) {
                this.injectedBean = injectedBean;
                this.anotherInjectedBean = anotherInjectedBean;
        }
}
