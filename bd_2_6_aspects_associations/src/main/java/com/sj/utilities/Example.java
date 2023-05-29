package com.sj.utilities;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Example {

    public void doSomething(){
        System.out.println("_I'm doing something_");
    }
    public void doNothing(){
        System.out.println("_I'm doing nothing_");
    }
}
