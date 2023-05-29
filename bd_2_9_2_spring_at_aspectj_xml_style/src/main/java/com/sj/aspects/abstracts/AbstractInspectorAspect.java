package com.sj.aspects.abstracts;

import com.sj.interfaces.Product;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
public abstract class AbstractInspectorAspect {

    @Pointcut
    public abstract void inspecting(Product product);

}
