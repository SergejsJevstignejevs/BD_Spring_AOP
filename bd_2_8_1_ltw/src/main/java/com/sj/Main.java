package com.sj;

import com.sj.config.AOPConfig;
import com.sj.utilities.Watch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.management.ManagementFactory;

//public class Main {
//    public static void main(String[] args) throws InterruptedException {
//        //Check used JVM arguments
//        System.out.println(ManagementFactory.getRuntimeMXBean().getInputArguments());
//        //Java class LTW config
//        ApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
//        //XML LTW config
//        //ApplicationContext context = new ClassPathXmlApplicationContext("config/aop-xml-conf.xml");
//        Watch watch = context.getBean(Watch.class);
//        watch.sleeping(3000);
//    }
//}

//Another syntax of configuration creation
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Check used JVM arguments
        System.out.println(ManagementFactory.getRuntimeMXBean().getInputArguments());
        //Java class LTW config
            new AnnotationConfigApplicationContext(AOPConfig.class);
        //XML LTW config
        //    new ClassPathXmlApplicationContext("config/aop-xml-conf.xml");
        Watch watch = new Watch();
        watch.sleeping(3000);
    }
}