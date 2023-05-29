package com.sj.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ChangingAspect {

    @Around("execution(* com.sj.utils.SimpleLogging.printLog(..)) && this(proxy) && target(target)")
    public void firstAround(ProceedingJoinPoint pjp, Object proxy, Object target) throws Throwable {
        System.out.println("[Proxy: " + proxy + "],[Target: " + target + "]");
        System.out.println("Original params: " + Arrays.toString(pjp.getArgs()));
        pjp.proceed(new Object[]{"It is working!!!", 5});
        //Doesn't work, throw an error: Expecting 2 arguments to proceed, but was passed 4 arguments
        // pjp.proceed(new Object[]{"It is working!!!", 5});
    }

}
