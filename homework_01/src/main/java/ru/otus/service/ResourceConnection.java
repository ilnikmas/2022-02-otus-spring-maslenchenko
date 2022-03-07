package ru.otus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ResourceConnection {
    private File resourceFile;

    @Autowired
    public void setResourceFile(Resource resource) {
        try {
            resourceFile = resource.getFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public File getResourceFile() {
        return resourceFile;
    }
}
