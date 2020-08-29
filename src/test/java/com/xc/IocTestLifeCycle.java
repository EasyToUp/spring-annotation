package com.xc;

import com.xc.config.MainConfigOfLifeCycle;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTestLifeCycle {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( MainConfigOfLifeCycle.class );
        System.out.println( "容器初始化完成、、、、、、、、" );
        context.close();
    }
}
