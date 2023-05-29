package com.sj.aspects;

import com.sj.aspects.abstracts.AbstractInspectorAspect;
import com.sj.interfaces.Product;
import com.sj.interfaces.impl.QualityProduct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class InventoryInspectorAspect extends AbstractInspectorAspect {
    @Pointcut("execution(* com.sj.interfaces.impl.ProductShop.addProduct(..)) && args(product)")
    public void inspecting(Product product) {
    }

    @Around("inspecting(product)")
    public void aroundProductAdding(ProceedingJoinPoint pjp, Product product) throws Throwable {
        QualityProduct qp = (QualityProduct) product;
        if(qp.getQuality() <= 75) {
            System.out.println("Before: " + pjp.getSignature());
            System.out.println("\t[Product: " + qp.getName() + "] quality doesn't meet requirements!");
            System.out.println("\tProduct quality must be >75!");
            return;
        }
        pjp.proceed();
        System.out.println("After: " + pjp.getSignature());
        System.out.println("\t[Product: " + qp.getName() + "] was successfully added!");
    }

}
