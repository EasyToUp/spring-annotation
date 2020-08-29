package com.xc;

import com.xc.bean.Yellow;
import com.xc.config.MainConfigProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;

public class IOCTestProfile {


    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment environment = context.getEnvironment();
        environment.setActiveProfiles( "dev" );
        context.register( MainConfigProfile.class );
        context.refresh();
        String[] beanNamesForType = context.getBeanNamesForType( DataSource.class );
        for (String name : beanNamesForType) {
            System.out.println( name );
        }
        Yellow yellow = context.getBean( Yellow.class );
        System.out.println( yellow );
    }

    private void printBeanNames(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println( beanDefinitionName );
        }
    }
}
