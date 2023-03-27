package org.annotations;

import org.annotations.code.InjectedBean;
import org.annotations.code.Prototype;
import org.annotations.code.Singleton;
import org.annotations.configuration.ExConfigurationClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
        public static void main(String[] args) {
                ApplicationContext context = new AnnotationConfigApplicationContext(ExConfigurationClass.class);
        
                // singleton jest scopem domyślnym
                InjectedBean injectedBean = context.getBean(InjectedBean.class);
                injectedBean.method();
        
                //ten sam obiekt, jeden stan, jedna instancja; singleton jest scopem domyślnym
                Singleton singleton1 = context.getBean(Singleton.class);
                Singleton singleton2 = context.getBean(Singleton.class);
                
                //różne obiekty, można przechowywać różne stany
                Prototype prototype1 = context.getBean(Prototype.class);
                Prototype prototype2 = context.getBean(Prototype.class);
                
                boolean isInjectedbeanassingleton =
                        injectedBean == singleton1.getInjectedBean() &&
                        injectedBean == singleton2.getInjectedBean() &&
                        injectedBean == prototype1.getInjectedBean() &&
                        injectedBean == prototype2.getInjectedBean();
                System.out.println("isInjectefbeanassingleton "+isInjectedbeanassingleton);
        }
}
