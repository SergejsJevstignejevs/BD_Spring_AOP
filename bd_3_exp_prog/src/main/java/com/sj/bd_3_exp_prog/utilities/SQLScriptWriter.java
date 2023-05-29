package com.sj.bd_3_exp_prog.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class SQLScriptWriter {

    private final String RESOURCE_LOCATION_PREFIX = "file:src/main/resources";

    private ResourceLoader resourceLoader;

    @Autowired
    public SQLScriptWriter(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void writeResource(String path, String script) throws IOException {
        Resource resource = resourceLoader.getResource(RESOURCE_LOCATION_PREFIX + path);
        File file = resource.getFile();
        FileWriter writer = new FileWriter(file, true);
        writer.write(script);
        writer.close();
    }

    public void writeFromOneToAnother(String destinationScriptPath, String sourceScriptPath) throws IOException {
        Resource destination = resourceLoader.getResource(RESOURCE_LOCATION_PREFIX + destinationScriptPath);
        Resource source = resourceLoader.getResource(RESOURCE_LOCATION_PREFIX + sourceScriptPath);

        File destinationFile = destination.getFile();
        File sourceFile = source.getFile();

        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
        FileWriter writer = new FileWriter(destinationFile, true);

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(line + "\n");
        }

        reader.close();
        writer.close();

        clearContent(sourceFile);
    }

    private void clearContent(File targetFile) throws IOException {
        FileWriter targetWriter = new FileWriter(targetFile);
        targetWriter.write("");
        targetWriter.close();
    }

}
