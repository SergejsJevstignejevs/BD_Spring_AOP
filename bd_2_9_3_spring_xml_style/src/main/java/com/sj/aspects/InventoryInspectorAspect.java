package com.sj.aspects;

import com.sj.interfaces.Product;
import com.sj.interfaces.impl.QualityProduct;
import org.aspectj.lang.ProceedingJoinPoint;

public class InventoryInspectorAspect {

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
