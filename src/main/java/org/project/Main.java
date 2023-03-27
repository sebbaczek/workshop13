package org.project;

import org.project.configuration.ApplicationConfiguration;
import org.project.service.MainProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
        public static void main(String[] args) {
                ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
                MainProcessor mainProcessor = context.getBean(MainProcessor.class);
                mainProcessor.calc();
        }
}
