package com.sj.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecondAspect implements Ordered {

    @Override
    public int getOrder() {
        return 2;
    }

    @Before("execution(* com.sj.utilities.Example.*(..))")
    public void secondBefore(){
        System.out.println("   I'm second before!");
    }

    @Around("execution(* com.sj.utilities.Example.*(..))")
    public void secondAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("  I'm second around before!");
        pjp.proceed();
        System.out.println("  I'm second around after!");
    }
    @After("execution(* com.sj.utilities.Example.*(..))")
    public void secondAfter(){
        System.out.println("   I'm second after!");
    }
}
