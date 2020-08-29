package com.xc.config;

import com.xc.aop.LogAspects;
import com.xc.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * AOP[动态代理]
 * 指在程序运行期间动态的将某段代码切入到指定的方法指定位置进行运行的编程方式
 * 1.导入aop模块
 * 定义被切的业务类
 * 定义切面类
 * 通知方法
 *
 * @Before 前置通知;在目标方法运行之前运行
 * @After 后置通知:在目标方法运行之后运行
 * @AfterReturing 返回通知:目标方法正常结束后运行
 * @AfterThrowing 异常通知:目标方法异常以后通知
 * @Around 环绕通知
 * 给目标方法标注解(通知注解)
 * 将切面类和业务逻辑类都加入到容器中
 * 必须告诉spring那个切面类(@Aspect)
 * 配置类中添加注解(@EnableAspectJAutoProxy)开启AOP功能
 * JointPoint 参数 必须放在第一位
 * AOP原理:
 * 1,EnableAspectJAutoProxy
 *  @Import(AspectJAutoProxyRegistrar.class); 给容器中导入AspectJAutoProxyRegistrar.class
 *  利用ApectJAutoProxyRegistrar给容器中注册组件
 *
 *
 *
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigAop {
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
