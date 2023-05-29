package com.sj.bd_3_exp_prog.application.runners;

import com.sj.bd_3_exp_prog.utilities.SQLScriptWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements ApplicationRunner {

    private ResourceLoader resourceLoader;

    @Autowired
    public AppStartupRunner(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SQLScriptWriter sqlScriptWriter = new SQLScriptWriter(resourceLoader);

        String destinationScriptPath = "/sql/data.sql";
        String sourceScriptPath = "/sql/data-added.sql";

        sqlScriptWriter.writeFromOneToAnother(destinationScriptPath, sourceScriptPath);
    }
}
