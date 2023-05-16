package com.Automation.utils.core;

import com.Automation.utils.PropertiesUtil;

import java.io.IOException;

public class ConfigReader {

    public static String browserName;
    public static boolean takeScreenshot;
    public static String chromeBinaryPath;
    public static String firefoxBinaryPath;
    public static String edgeBinaryPath;
    public static int mediumWaitTime;
    public static int longWaitTime;
    public static int shortWaitTime;
    public static String appUrl;
    public static boolean headlessMode;
    public static void loadFrameworkProperties() throws IOException {
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        propertiesUtil.loadAllProperties(System.getProperty("user.dir")
                +"/src/main/resources/config/config.properties");
        browserName = propertiesUtil.getProperty("browserName");
        chromeBinaryPath = propertiesUtil.getProperty("chromeBinaryPath");
        takeScreenshot = Boolean.parseBoolean(propertiesUtil.getProperty("takeScreenshot"));
        firefoxBinaryPath = propertiesUtil.getProperty("firefoxBinaryPath");
        edgeBinaryPath = propertiesUtil.getProperty("edgeBinaryPath");
        longWaitTime = Integer.parseInt(propertiesUtil.getProperty("longWaitTime"));
        mediumWaitTime = Integer.parseInt(propertiesUtil.getProperty("mediumWaitTime"));
        shortWaitTime = Integer.parseInt(propertiesUtil.getProperty("shortWaitTime"));
        appUrl = propertiesUtil.getProperty("appUrl");
        headlessMode = Boolean.parseBoolean(propertiesUtil.getProperty("headlessMode"));
    }

    public static void main(String[] args) throws IOException {
        ConfigReader.loadFrameworkProperties();
    }
}
