package com.sj.aspects;

import com.sj.interfaces.LoggingRecorder;
import com.sj.interfaces.impl.LoggingRecorderImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class IntroductionAspect {

    @DeclareParents(
        value = "com.sj.utilities.Example",
        defaultImpl = LoggingRecorderImpl.class)
    public static LoggingRecorder loggingRecorder;

    @Before("execution(* com.sj.utilities.Example.*(..)) && this(proxy)")
    public void beforeExampleMethodsExecution(JoinPoint jp, LoggingRecorder proxy){
        proxy.printMessage(
                "This is printed by proxy object!" +
                "\nBefore execution of: " + jp.getSignature());
        //Same functionality with using JoinPoint reflection
//        LoggingRecorder lr = (LoggingRecorder) jp.getThis();
//        lr.printMessage(
//          "This is printed by proxy object!" +
//          "\nBefore execution of: " + jp.getSignature());
    }

}
