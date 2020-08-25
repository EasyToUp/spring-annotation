package com.xc;

import com.xc.bean.Person;
import com.xc.config.MainConfig01;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext( MainConfig01.class );
        Person bean = context.getBean( Person.class );
        System.out.println( bean );
        String[] beanNamesForType = context.getBeanNamesForType( Person.class );
        for (String name : beanNamesForType) {
            System.out.println( name );
        }
    }
}
