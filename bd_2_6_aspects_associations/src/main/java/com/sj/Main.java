package com.sj;

import com.sj.config.AOPConfig;
import com.sj.utilities.Example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
        Example exm1 = context.getBean(Example.class);
        exm1.doSomething();
        exm1.doNothing();
        Example exm2 = context.getBean(Example.class);
        exm2.doSomething();
        exm2.doNothing();
    }
}