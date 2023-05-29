package com.sj;

import com.sj.config.AOPConfig;
import com.sj.utils.SimpleLogging;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
        SimpleLogging sl = context.getBean(SimpleLogging.class);
        sl.printLog("Is it working???", 25);
    }
}