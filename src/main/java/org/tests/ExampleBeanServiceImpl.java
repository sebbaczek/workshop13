package org.tests;

public class ExampleBeanServiceImpl implements  ExampleBeanService{
        private InjectedBeanService injectedBeanService;
        
        @Override
        public void setInjectedBeanService(InjectedBeanService injectedBeanService) {
        this.injectedBeanService = injectedBeanService;
        }
        
        @Override
        public String sampleMethod2(String some) {
                return injectedBeanService.sampleMethod(some);
        }
}
