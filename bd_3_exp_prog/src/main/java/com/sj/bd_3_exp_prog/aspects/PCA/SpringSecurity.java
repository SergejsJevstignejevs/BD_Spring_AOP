package com.sj.bd_3_exp_prog.aspects.PCA;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SpringSecurity {

    @Pointcut("within(org.springframework.security.authentication..*)")
    public void inAuthentication(){};

    @Pointcut("execution(* org.springframework.security.authentication..*.*(..))")
    public void authenticationExecution(){};

    @Pointcut("inAuthentication() && authenticationExecution()")
    public void authentication(){};

}
