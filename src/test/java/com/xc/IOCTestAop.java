package com.xc;

import com.xc.aop.MathCalculator;
import com.xc.bean.Yellow;
import com.xc.config.MainConfigAop;
import com.xc.config.MainConfigProfile;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.sql.DataSource;

public class IOCTestAop {


    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( MainConfigAop.class );
        MathCalculator mathCalculator = context.getBean( MathCalculator.class );
        Integer div = mathCalculator.div( 1, 1);

    }

    private void printBeanNames(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println( beanDefinitionName );
        }
    }
}
