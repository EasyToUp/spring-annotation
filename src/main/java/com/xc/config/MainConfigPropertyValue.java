package com.xc.config;

import com.xc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @PropertySource 读取外部配置文件的k/v保存到运行的环境变量中，加载完后可以使用${}取出配置文件的值
 */
@PropertySource(value = "classpath:config/person.properties",encoding = "utf-8")
@Configuration
public class MainConfigPropertyValue {

    @Bean
    Person person() {
        return new Person( "zhangsan", 19 );
    }

}
