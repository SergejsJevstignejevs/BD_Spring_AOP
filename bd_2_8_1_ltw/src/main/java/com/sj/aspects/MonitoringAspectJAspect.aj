package com.sj.aspects;

public aspect MonitoringAspectJAspect {

    pointcut monitoringOperation() :
        execution(* com.sj.utilities.Watch.*(..));

    Object around() throws InterruptedException :
        monitoringOperation() {
        System.out.println("Before " + thisJoinPoint.getSignature() + " execution!");

        long startTime = System.nanoTime();
        Object retVal = proceed();
        long endTime = System.nanoTime();
        long executingTime = endTime - startTime;
        System.out.println("Method's execution time:\n"
                + "\t" + executingTime + " ns\n"
                + "\t" + (executingTime / 1000) + " μs\n"
                + "\t" + (executingTime / 1000000) + " ms\n"
                + "\t" + (executingTime / 1000000000) + " s");
        System.out.println("After " + thisJoinPoint.getSignature() + " execution!");

        return retVal;
    }
}
