package com.sj.bd_3_exp_prog.aspects;

import com.sj.bd_3_exp_prog.aspects.errors.LayerViolationException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WebLayerPolicyEnforcementAspect {

    @Before(
        "com.sj.bd_3_exp_prog.aspects.PCA.WebLayers.repositoryLayerExecution()" +
        "&& com.sj.bd_3_exp_prog.aspects.PCA.SpringSecurity.authentication()" +
        "&& !com.sj.bd_3_exp_prog.aspects.PCA.WebLayers.inRepositoryLayer()" +
        "&& !com.sj.bd_3_exp_prog.aspects.PCA.WebLayers.inServiceLayer()")
    public void repositoryMethodExecutionViolation(){
        throw new LayerViolationException("Repository method executed outside repository or service layer");
    }

    @Before(
        "com.sj.bd_3_exp_prog.aspects.PCA.WebLayers.serviceLayerExecution()" +
        "&& !com.sj.bd_3_exp_prog.aspects.PCA.WebLayers.inServiceLayer()" +
        "&& !com.sj.bd_3_exp_prog.aspects.PCA.WebLayers.inControllerLayer()")
    public void serviceMethodExecutionViolation(){
        throw new LayerViolationException("Service method executed outside service or controller layer");
    }

    @Before(
        "com.sj.bd_3_exp_prog.aspects.PCA.WebLayers.controllerLayerExecution()" +
        "&& !com.sj.bd_3_exp_prog.aspects.PCA.WebLayers.inControllerLayer()")
    public void controllerMethodExecutionViolation(){
        throw new LayerViolationException("Controller method executed outside controller layer");
    }
}
