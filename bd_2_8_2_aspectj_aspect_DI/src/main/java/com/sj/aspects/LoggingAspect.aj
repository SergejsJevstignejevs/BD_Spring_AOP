package com.sj.aspects;

import com.sj.utilities.Example;

public aspect LoggingAspect {

    private Example example;

    public void setExample(Example example) {
            this.example = example;
    }

    private boolean isExecuting = false;

    public LoggingAspect() {}

    pointcut beforeExampleMethods() :
        execution(* Example.*(..)) &&
        !within(LoggingAspect);

    before() : beforeExampleMethods() {
        if(isExecuting == true){
            return;
        }
        isExecuting = true;

        System.out.println("Before: " + thisJoinPointStaticPart);
        System.out.println("Which name is: ");
        System.out.print("\t");
        this.example.printName();

        isExecuting = false;
    }

}