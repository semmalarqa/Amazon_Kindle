package com.Automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    Properties properties;

    public Properties loadAllProperties(String filePath) throws IOException {
        try {
            properties = new Properties();
            properties.load(new FileInputStream(new File(filePath)));
        }catch(Exception e){
            System.out.println("Unable to load properties file,\n something wrong with the path,\n pls check the path: "+filePath+"");
        }
        return properties;
    }

    public String getProperty(String propertyName) {

        try {
            String propertyValue;
            propertyValue = properties.getProperty(propertyName);
            return propertyValue;
        } catch (Exception e) {
            System.out.println("Missing Property [" + propertyName + "] or Something wrong, pls check properties file");
            throw e;
        }
    }

}
