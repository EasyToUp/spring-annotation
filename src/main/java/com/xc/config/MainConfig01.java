package com.xc.config;

import com.xc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//配置类等于配置文件

@Configuration //告诉spring 这是一个配置类
@ComponentScan(value = "com.xc",
//        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, Service.class})},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Repository.class})}
)
//value 指定要扫描的包
//excludeFilters 指定要排除的组件
//includeFilters 指定包含那些组件
//FilterType.ASSIGNABLE_TYPE 指定规则
public class MainConfig01 {

    /**
     * 类型为返回值类型
     * id默认为方法名
     * 默认单实例
     * value属性修改bean id
     */

    @Bean(value = "person") //给容器中注册一个bean
    public Person person() {
        return new Person( "lisi", 18 );
    }
}
