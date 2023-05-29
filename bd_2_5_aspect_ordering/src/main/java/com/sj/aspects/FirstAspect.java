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
public class FirstAspect implements Ordered {

    @Override
    public int getOrder() {
        return 1;
    }

    @Before("execution(* com.sj.utilities.Example.*(..))")
    public void firstBefore(){
        System.out.println(" I'm first before!");
    }

    @Around("execution(* com.sj.utilities.Example.*(..))")
    public void firstAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("I'm first around before!");
        pjp.proceed();
        System.out.println("I'm first around after!");
    }

    @After("execution(* com.sj.utilities.Example.*(..))")
    public void firstAfter(){
        System.out.println(" I'm first after!");
    }

}
