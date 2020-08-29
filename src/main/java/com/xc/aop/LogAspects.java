package com.xc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;

import java.text.MessageFormat;
import java.util.Arrays;

@Aspect
public class LogAspects {

    @Pointcut("execution(public Integer com.xc.aop.MathCalculator.*(..))")
    public void pointCut() {
    }


    //@Before 在目标防范之前切入,切入点表达式(指定在那个方法切入)
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();//参数
        Signature signature = joinPoint.getSignature();//方法名
        System.out.println( MessageFormat.format( "@Before..方法名 :{0}....参数列表{1}...正常运行之前....", signature, Arrays.asList( args ) ) );
    }

    @After("pointCut()")
    public void logEnd() {
        System.out.println( "@After正常结束.... " );
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        System.out.println( MessageFormat.format( "@AfterReturning正常返回....返回结果:{0}", result ) );
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(Exception exception) {
        System.out.println( MessageFormat.format( "@AfterThrowing异常....异常信息:{0}", exception ) );
    }
}
