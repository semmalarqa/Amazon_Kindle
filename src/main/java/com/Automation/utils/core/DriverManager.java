package com.Automation.utils.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public static WebDriver launchBrowser() throws Exception {
        WebDriver driver = null;
        try {
            String browserName = ConfigReader.browserName;
            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(ConfigReader.headlessMode);
                System.setProperty(Constants.CHROME_DRIVER_PROPERTY, ConfigReader.chromeBinaryPath);
                driver = new ChromeDriver(chromeOptions);
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                System.setProperty(Constants.FIREFOX_DRIVER_PROPERTY, ConfigReader.firefoxBinaryPath);
                driver = new FirefoxDriver(firefoxOptions);
            } else if (browserName.equalsIgnoreCase("Edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                System.setProperty(Constants.EDGE_DRIVER_PROPERTY, ConfigReader.edgeBinaryPath);
                driver = new EdgeDriver(edgeOptions);
            }
            driver.manage().timeouts().pageLoadTimeout(ConfigReader.mediumWaitTime, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(ConfigReader.longWaitTime, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            Reporter.logPassedStep("Launched Browser [" + ConfigReader.browserName + "] successfully");
        } catch (Exception e) {
            Reporter.logFailedStep("Failed to launch browser [" + ConfigReader.browserName + "]. Exception Occured:  "+ e);

        }
        return driver;
    }
}
