package com.Automation.utils.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public interface IWebActions {


    public WebElement findWebElement(String elementName) throws Exception;

    void launchUrl(String url);

    public abstract void clickOn(String element) throws Exception;

    public abstract By getBy(String locatorType, String locatorValue) throws Exception;

    boolean isWebElementDisplayed(String elementName) throws Exception;

    String takeScreenshot() throws IOException;

    void scrollToElement(WebElement elementName) throws Exception;

}
