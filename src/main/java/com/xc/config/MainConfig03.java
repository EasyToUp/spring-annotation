package com.xc.config;

import com.xc.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

//配置类等于配置文件

@Configuration //告诉spring 这是一个配置类
public class MainConfig03 {

    /**
     * Specifies the name of the scope to use for the annotated component/bean.
     * <p>Defaults to an empty string ({@code ""}) which implies
     * {@link ConfigurableBeanFactory#SCOPE_SINGLETON SCOPE_SINGLETON}.
     *
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     * @see #value
     * @since 4.2
     */
    @Lazy
    @Scope(SCOPE_SINGLETON)
    @Bean(value = "person") //给容器中注册一个bean
    public Person person() {
        System.out.println( "给容器中添加person........." );
        return new Person( "张三", 20 );
    }
}
