package com.sj.utilities;

import org.springframework.stereotype.Component;

@Component
public class Example {

    private String name = "Exmatel";

    public void doSomething(){
        System.out.println("_I'm doing something_");
    }

    public void printName() {
        System.out.println("My name is " + this.name);
    }

}
