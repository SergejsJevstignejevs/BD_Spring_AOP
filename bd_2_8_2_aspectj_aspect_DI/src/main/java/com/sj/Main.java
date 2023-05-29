package com.sj;

import com.sj.utilities.Example;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config/aop-xml-config.xml");
        Example exm = context.getBean(Example.class);
        exm.doSomething();
    }
}