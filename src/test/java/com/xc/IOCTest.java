package com.xc;

import com.xc.bean.Person;
import com.xc.config.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

public class IOCTest {

    public static void main(String[] args) {

    }


    private void printBeans(ApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println( definitionName );
        }
    }

    @Test
    public void test01() {
        ApplicationContext context = new AnnotationConfigApplicationContext( MainConfig01.class );
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println( definitionName );
        }
    }

    @Test
    public void test02() {
        ApplicationContext context = new AnnotationConfigApplicationContext( MainConfig02.class );
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String definitionName : beanDefinitionNames) {
            System.out.println( definitionName );
        }
    }


    @Test
    public void test03() {
        ApplicationContext context = new AnnotationConfigApplicationContext( MainConfig03.class );
        System.out.println( "IOC 容器创建完成.........." );
//        Object person1 = context.getBean( "person" );
//        Object person2 = context.getBean( "person" );
//        System.out.println(person1==person2);

    }

    @Test
    public void test04() {
        ApplicationContext context = new AnnotationConfigApplicationContext( MainConfig04.class );
        String[] beanNamesForType = context.getBeanNamesForType( Person.class );
        for (String name : beanNamesForType) {
            System.out.println( name );
        }

        Map<String, Person> beansOfType = context.getBeansOfType( Person.class );
        System.out.println( beansOfType );

        Environment environment = context.getEnvironment();//获取环境变量
        String property = environment.getProperty( "os.name" );
        System.out.println( property );
    }

    @Test
    public void testImport() {
        ApplicationContext context = new AnnotationConfigApplicationContext( MainConfig05.class );
        printBeans( context );
        Object colorFactoryBean = context.getBean( "colorFactoryBean" );
        Object colorFactoryBeanFactory = context.getBean( "&colorFactoryBean" );
        System.out.println( "colorFactoryBean的类型：" + colorFactoryBean.getClass() );
        System.out.println( "colorFactoryBeanFactory的类型：" + colorFactoryBeanFactory.getClass() );
    }
}
