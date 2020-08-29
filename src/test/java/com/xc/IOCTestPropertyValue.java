package com.xc;

import com.xc.bean.Person;
import com.xc.config.MainConfigPropertyValue;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTestPropertyValue {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( MainConfigPropertyValue.class );


    @Test
    public void test01() {
        printBeanNames( context );
        System.out.println( "=====================" );
        Person person = context.getBean( Person.class );
        System.out.println( person );
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty( "person.nickName" );
        System.out.println( "person.nickName:" + property );
    }

    private void printBeanNames(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println( beanDefinitionName );
        }
    }
}
