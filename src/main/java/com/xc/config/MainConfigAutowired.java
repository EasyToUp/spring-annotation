package com.xc.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动装配：
 * spring利用依赖注入（DI），完成IOC容器中各个组件的依赖关系赋值
 * <p>
 * 1，@Autowired
 * 1),默认优先按照类型去容器中找对应的组件，application.getBean（BookDao.class），找到就赋值
 * 2），如果找到多个相同类型 的组件，在将按照属性的名称作为组件的id去容器中查找application.getBean（"bookDao"）
 * 3),使用@Quelifier(),指定装配的bean
 * 4），默认是一定要将属性赋值好，否则报错
 * 5），使用属性required属性设置为false 非必须一定装配
 *
 * @Primary 首选默认装配，也可以继续使用@Quelifier 指定装配那个
 * <p>
 * <p>
 * class BookService {
 * @Autowired BookDao bookDao;
 * }
 * <p>
 * 2，spring 还支持使用@Resource（JSR250）和@Inject（JSR330)【java规范的注解】@Autowire是spring注解
 * @Resource 也能完成自动注入，但是默认按照组件名称为装配，没有支持@Primary的功能，和@Quelifier的功能
 * @Inject 和@Autowire的功能一样，没有required=false的功能
 * @Autowire： 可以标注于 构造器，方法，参数，属性
 * <p>
 * 标注在方法上；spring容器创建当前对象，就会调用方法，完成赋值 方法使用的参数，自定义类型的值就会到ioc容器中获取
 * 构造器：容器启动会调用无参构造器创建对象，在进行初始化赋值等操作，构造器要用的组件都是从容器中获取，
 * 标在有参构造器，如果组件只有一个有参构造器，这个有参构造器的@Autowire可以省略，参数的组件还是可以注入进来
 * 参数：@Bean标注的方法创建对象的时候，方法参数的值从容器中获取
 * <p>
 * 自定义组件想要使用spring容器底层的一些组件（applicationContext，BeanFactory，xxx。。）
 * 自定义组件实现xxxAware，在创建对象的时候，会调用接口规定的方法注入相关的组件,把spring底层一些组件注入到自定义的bean中
 * xxxAware功能是使用xxxProcessor（后置处理器）
 *  ApplicationContextAware===》ApplicationContextAwareProcessor
 */
@Configuration
@ComponentScan(value = {"com.xc.service", "com.xc.dao", "com.xc.controller", "com.xc.bean"})
public class MainConfigAutowired {

}
