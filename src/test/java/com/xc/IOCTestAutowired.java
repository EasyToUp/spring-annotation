package com.xc;

import com.xc.bean.Person;
import com.xc.config.MainConfigAutowired;
import com.xc.config.MainConfigPropertyValue;
import com.xc.dao.BookDao;
import com.xc.service.BookService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTestAutowired {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( MainConfigAutowired.class );


    @Test
    public void test01() {
        BookService bookService = context.getBean( BookService.class );
        System.out.println(bookService);
        BookDao bookDao = context.getBean( BookDao.class );
        System.out.println(bookDao);
    }

    private void printBeanNames(AnnotationConfigApplicationContext context) {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println( beanDefinitionName );
        }
    }
}
