package org.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
        public static void main(String[] args) {
                ApplicationContext context = new AnnotationConfigApplicationContext(ExConfigurationClass.class);
                
                ExBean exBean = context.getBean("exBean", ExBean.class);
                
        }
}