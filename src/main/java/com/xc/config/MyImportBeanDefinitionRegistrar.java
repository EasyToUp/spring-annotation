package com.xc.config;

import com.xc.bean.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition( "com.xc.bean.Red" );
        boolean color = registry.containsBeanDefinition( "com.xc.bean.Color" );
        if (red && color) {
            RootBeanDefinition rootBeanDefinition = new RootBeanDefinition( RainBow.class );//指定bean的定义信息 （bean类型，scope........)
            registry.registerBeanDefinition( "rainbow", rootBeanDefinition );
        }
    }
}
