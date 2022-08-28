package com.finaltest.selenium.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private Properties properties;
    private InputStream inputStream;
    private String path;

    public Configuration(String path){
        this.path = path;
    }

    public String getProperty(String propertyName) {
        String result = "";
        try {
            properties = new Properties();
            inputStream = new FileInputStream(path);
            properties.load(inputStream);
            result = properties.getProperty(propertyName);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file at " + path + "!");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("An error occurred while closing InputStream!");
            }
        }
        return result;
    }
}
