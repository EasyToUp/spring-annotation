package com.xc.config;

import com.xc.bean.Person;
import com.xc.condition.LinuxCondition;
import com.xc.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

//配置类等于配置文件

@Configuration //告诉spring 这是一个配置类
public class MainConfig04 {


    @Bean(value = "person")
    public Person person() {
        return new Person( "王五", 20 );
    }

    @Conditional(WindowsCondition.class)
    @Bean("bill")
    public Person person01() {
        return new Person( "bill Gates", 62 );
    }

    @Conditional(LinuxCondition.class)
    @Bean("linus")
    public Person person02() {
        return new Person( "linus", 59 );
    }

}
