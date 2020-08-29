package com.xc.config;

import com.xc.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * bean的生命周期
 * bean的创建----初始化----销毁的过程
 * 容器管理bean的生命周期
 * 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候调用我们自定义的初始化和销毁方法
 * <p>
 * 构造
 * 单实例bean在容器启动的时候创建
 * 多实例在bean调用的时候创建
 * 初始化：
 * 对象创建完成并赋值后，调用初始化方法
 * 销毁：
 * 容器关闭的时候调用销毁方法（多实例的bean不会调用销毁方法）
 * 1，指定初始化和销毁方法
 * 通过@Bean指定init-method和destroy-method
 * <p>
 * 2,通过让bean实现InitializingBean 定义初始化逻辑，
 * DisposableBean销毁容器
 * <p>
 * 3,使用JSR250
 *
 * @PosConstruct ，在bean创建并且属性赋值完成，进行初始化
 * @PreDestroy ，在容器销毁bean之前通知回调该方法进行销毁
 * <p>
 * 4,BeanPostProcessor 执行顺序
 * 构造
 * BeanPostProcessor.postProcessBeforeInitialization
 * 初始化
 * BeanPostProcessor.postProcessAfterInitialization
 * 销毁
 * 前置处理器 postProcessBeforeInitialization 在任何初始化之前调用工作
 * 后置处理器 postProcessAfterInitialization 在任何初始化方式之后工作
 */
@ComponentScan(value = {"com.xc.bean"})
@Configuration
public class MainConfigOfLifeCycle {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Car car() {
        return new Car();
    }
}
