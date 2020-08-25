package com.xc.condition;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();//ioc 使用的beanfactory
        ClassLoader classLoader = context.getClassLoader();//类加载器
        Environment environment = context.getEnvironment();//获取当前环境信息
        BeanDefinitionRegistry registry = context.getRegistry();//获取到bean定义的注册类
        String osName = environment.getProperty( "os.name" );
        if (osName.contains( "Windows" )) {
            return true;
        }
        return false;
    }
}
