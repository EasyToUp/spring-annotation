package com.xc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xc.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;


/**
 * profile:
 * 可以根据当前提供的环境动态的激活和切换一系列组件的功能
 * 开发环境 测试环境 生产环境
 * 数据源 A，B，C
 *
 * @Profile 指定组件在那个环境中才能被注册到IOC容器中
 * 默认是default
 * 写在配置类上，只有是指定的环境，整个配置类才有效
 */

@Configuration
@PropertySource("classpath:config/dbConfig")
public class MainConfigProfile implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;

    private String driveClass;

    @Bean
    public Yellow yellow() {
        return new Yellow();
    }


    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser( user );
        dataSource.setPassword( pwd );
        dataSource.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
        dataSource.setDriverClass( driveClass );
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser( user );
        dataSource.setPassword( pwd );
        dataSource.setJdbcUrl( "jdbc:mysql://localhost:3306/db1" );
        dataSource.setDriverClass( driveClass );
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser( user );
        dataSource.setPassword( pwd );
        dataSource.setJdbcUrl( "jdbc:mysql://localhost:3306/xhe" );
        dataSource.setDriverClass( driveClass );
        return dataSource;
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        this.resolver = resolver;
        this.driveClass = resolver.resolveStringValue( "${db.driveClass}" );
    }
}
