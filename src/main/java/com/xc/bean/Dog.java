package com.xc.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Dog implements ApplicationContextAware {

    ApplicationContext applicationContext;

    public Dog() {
        System.out.println( "dog constructor......." );
    }

    //在对象创建并且赋值后调用
    @PostConstruct
    public void init() {
        System.out.println( "dog.......@PostConstruct..." );
    }

    //在容器销毁bean之前
    @PreDestroy
    public void destroy() {
        System.out.println( "dog ....@PreDetroy...." );
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
