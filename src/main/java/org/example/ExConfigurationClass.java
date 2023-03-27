package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExConfigurationClass {

        @Bean
        public ExBean exBean(InjectedBean injectedBean, AnotherInjectedBean anotherInjectedBean) {
                return new ExBean(injectedBean,anotherInjectedBean);
        }
        
        @Bean
        InjectedBean injectedBean(){
                return new InjectedBean();
        }
        
        @Bean
        AnotherInjectedBean anotherInjectedBean(){
                return new AnotherInjectedBean();
        }
        
}
