package com.Automation.utils.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.*;

public class WebActions implements IWebActions {
    public WebDriver driver;

    public WebActions(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public By getBy(String locatorType, String locatorValue) throws Exception {
        By by = null;
        if (locatorType.equalsIgnoreCase("id")) {
            by = By.id(locatorValue);
        } else if (locatorType.equalsIgnoreCase("name")) {
            by = By.name(locatorValue);
        } else if (locatorType.equalsIgnoreCase("class")) {
            by = By.className(locatorValue);
        } else if (locatorType.equalsIgnoreCase("lt")) {
            by = By.linkText(locatorValue);
        } else if (locatorType.equalsIgnoreCase("plt")) {
            by = By.partialLinkText(locatorValue);
        } else if (locatorType.equalsIgnoreCase("xpath")) {
            by = By.xpath(locatorValue);
        } else if (locatorType.equalsIgnoreCase("css")) {
            by = By.cssSelector(locatorValue);
        } else if (locatorType.equalsIgnoreCase("tag")) {
            by = By.tagName(locatorValue);
        } else {
            throw new Exception("Invalid locator type [" + locatorType + "] provided, pls check the valid options");
        }
        return by;
    }




    @Override
    public WebElement findWebElement(String elementName) throws Exception {
        WebElement element = null;
        try {
            Properties properties = ObjectRepoReader.loadAllLocators();
            String propertyValue = properties.getProperty(elementName);
            String locatorType = propertyValue.split(";")[0];
            String locatorValue = propertyValue.split(";")[1];
            By by = getBy(locatorType, locatorValue);
            WebDriverWait wait =
                    new WebDriverWait(driver, ConfigReader.longWaitTime);
             element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            scrollToElement(element);
        }catch(Exception e){
            Reporter.logFailedStep("Unable to find element ["+elementName+"], pls check the value");
        }
        return element;
    }


    @Override
    public void launchUrl(String url){
        try {
            driver.get(url);
            Reporter.logPassedStep("Url["+url+"] Launched successfully");

        }catch(Exception e){
            Reporter.logFailedStep("Unable to launch Url["+url+"]");

        }
    }

    @Override
    public void clickOn(String elementName) throws Exception {
        try {
            WebElement element = findWebElement(elementName);
            new WebDriverWait(driver, ConfigReader.longWaitTime)
                    .until(ExpectedConditions.elementToBeClickable(element))
                    .click();
            Reporter.logPassedStep("Clicked on element[ "+elementName+"] successfully");
        }catch(Exception e){
            Reporter.logFailedStep("Unable to click on element[ "+elementName+"]");

        }
    }



    @Override
    public boolean isWebElementDisplayed(String elementName) throws Exception{
        WebElement element = findWebElement(elementName);
        return element.isDisplayed();
    }


    @Override
    public String takeScreenshot() throws IOException {
        if(ConfigReader.takeScreenshot) {
            TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
            String image = takeScreenshot.getScreenshotAs(OutputType.BASE64);
            return "data:image/png;base64,"+image;
        }
        return "";
    }

    @Override
    public void scrollToElement(WebElement elementName) throws Exception{
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",elementName);
    }


}
