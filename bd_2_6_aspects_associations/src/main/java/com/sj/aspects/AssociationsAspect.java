package com.sj.aspects;

import com.sj.utilities.Example;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//Multiple instances solution
//@Aspect("pertarget(com.sj.aspects.AssociationsAspect.exampleOperations())")
//@Component
//@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//public class AssociationsAspect {
//    public AssociationsAspect(){
//        System.out.println("Creating aspect instance!");
//    }
//
//    @Pointcut("execution(* com.sj.utilities.Example.*(..))")
//    public void exampleOperations(){};
//
//    @Before("exampleOperations()")
//    public void beforeExampleMethodsExecution(JoinPoint jp){
//        System.out.println(
//                "JoinPoint: " + jp.getStaticPart() +
//                "\n\taspect: " + this +
//                "\n\tproxy object: " + jp.getThis() +
//                "\n\ttarget object: " + jp.getTarget()
//        );
//    }
//
//}

//Singleton solution
//@Aspect
//@Component
//public class AssociationsAspect {
//    public AssociationsAspect(){
//        System.out.println("Creating aspect instance!");
//    }
//
//    @Pointcut("execution(* com.sj.utilities.Example.*(..))")
//    public void exampleOperations(){};
//
//    @Before("exampleOperations()")
//    public void beforeExampleMethodsExecution(JoinPoint jp){
//        System.out.println(
//                "JoinPoint: " + jp.getStaticPart() +
//                        "\n\taspect: " + this +
//                        "\n\tproxy object: " + jp.getThis() +
//                        "\n\ttarget object: " + jp.getTarget()
//        );
//    }
//
//}

//Not working solution
@Aspect("perthis(execution(* com.sj.utilities.Example.*(..)))")
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AssociationsAspect {
    public AssociationsAspect(){
        System.out.println("Creating aspect instance!");
    }

    @Pointcut("execution(* com.sj.utilities.Example.*(..))")
    public void exampleBeans(){};

    @Pointcut("execution(* com.sj.utilities.Example.*(..)) && this(bean)")
    public void exampleOperations(Object bean){};

    @Before(value = "exampleOperations(bean)", argNames = "jp,bean")
    public void beforeExampleMethodsExecution(JoinPoint jp, Object bean){
        System.out.println(
                "JoinPoint: " + jp.getStaticPart() +
                        "\n\taspect: " + this +
                        "\n\tobject: " + bean
        );
    }
}
