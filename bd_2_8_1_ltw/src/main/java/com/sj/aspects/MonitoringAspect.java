package com.sj.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitoringAspect {

    @Pointcut("execution(* com.sj.utilities.Watch.*(..))")
    public void monitoringOperation(){}

    @Around("monitoringOperation()")
    public Object aroundAdvice(ProceedingJoinPoint pjp)
            throws Throwable {
        System.out.println("Before " + pjp.getSignature() + " execution!");

        long startTime = System.nanoTime();
        Object retVal = pjp.proceed();
        long endTime = System.nanoTime();
        long executingTime = endTime - startTime;
        System.out.println("Method's execution time:\n"
                + "\t" + executingTime + " ns\n"
                + "\t" + (executingTime / 1000) + " μs\n"
                + "\t" + (executingTime / 1000000) + " ms\n"
                + "\t" + (executingTime / 1000000000) + " s");
        System.out.println("After " + pjp.getSignature() + " execution!");

        return retVal;
    }

}
