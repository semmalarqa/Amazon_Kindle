package com.Automation.utils.core;

import com.Automation.utils.PropertiesUtil;

import java.io.IOException;
import java.util.Properties;

public class ObjectRepoReader {

    public static Properties loadAllLocators() throws IOException {
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        Properties properties =propertiesUtil.loadAllProperties(System.getProperty("user.dir")
                +"/src/main/resources/objectrepository/OR.properties");
        return properties;
    }

    public static void main(String[] args) throws IOException {
        loadAllLocators();
    }


}
