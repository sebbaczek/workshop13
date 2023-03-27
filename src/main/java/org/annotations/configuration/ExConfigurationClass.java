package org.annotations.configuration;

import org.annotations.Main;
import org.annotations.code.Marker;
import org.example.AnotherInjectedBean;
import org.example.ExBean;
import org.example.InjectedBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "org.annotations.code")
//@ComponentScan(basePackageClasses = Marker.class) //szukaj beanów w paczce gdzie jest interfejs marker
@ComponentScan(basePackageClasses = Main.class) //szukaj beanów w paczce gdzie jest Main
public class ExConfigurationClass {

}
