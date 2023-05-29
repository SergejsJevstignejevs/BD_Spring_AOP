package com.sj.config;

import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
//import com.sj.aspects.MonitoringAspectJAspect;

@Configuration
@EnableLoadTimeWeaving(aspectjWeaving = AspectJWeaving.ENABLED)
@ComponentScan("com.sj")
public class AOPConfig implements LoadTimeWeavingConfigurer {

    @Override
    public LoadTimeWeaver getLoadTimeWeaver() {
        return new InstrumentationLoadTimeWeaver();
    }

    @Bean
    public InstrumentationLoadTimeWeaver loadTimeWeaver()  throws Throwable {
        return new InstrumentationLoadTimeWeaver();
    }

//    @Bean
//    public MonitoringAspectJAspect monitoringAspectJAspect() {
//        return Aspects.aspectOf(MonitoringAspectJAspect.class);
//    }

}
