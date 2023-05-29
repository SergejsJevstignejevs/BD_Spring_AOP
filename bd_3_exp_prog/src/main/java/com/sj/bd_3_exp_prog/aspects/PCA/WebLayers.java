package com.sj.bd_3_exp_prog.aspects.PCA;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class WebLayers {

    @Pointcut("execution(* com.sj.bd_3_exp_prog.controllers..*.*(..))")
    public void controllerLayerExecution(){};

    @Pointcut("within(com.sj.bd_3_exp_prog.controllers..*)")
    public void inControllerLayer(){};

    @Pointcut("execution(* com.sj.bd_3_exp_prog.services..*.*(..))")
    public void serviceLayerExecution(){};

    @Pointcut("within(com.sj.bd_3_exp_prog.services..*)")
    public void inServiceLayer(){};

    @Pointcut("execution(* com.sj.bd_3_exp_prog.repositories..*.*(..))")
    public void repositoryLayerExecution(){};

    @Pointcut("within(com.sj.bd_3_exp_prog.repositories..*)")
    public void inRepositoryLayer(){};
}
