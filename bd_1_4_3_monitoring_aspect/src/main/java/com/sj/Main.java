package com.sj;

import com.sj.config.AOPConfig;
import com.sj.utilities.Watch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);

        Watch watch = context.getBean(Watch.class);
        watch.sleeping(3000);
    }
}