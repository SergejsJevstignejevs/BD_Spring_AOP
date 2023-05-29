package com.sj;

import com.sj.config.AOPConfig;
import com.sj.utilities.Example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
        Example exm = context.getBean(Example.class);
        exm.doSomething();
    }
}