package com.AmazonAutomation;

import com.Automation.utils.core.ConfigReader;
import com.Automation.utils.core.WebActions;
import org.openqa.selenium.WebDriver;

public class AmazonPage extends WebActions {

    WebDriver driver;
    public AmazonPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public AmazonPage navigateToWebsite(){
        driver.get(ConfigReader.appUrl);
        return this;
    }

    public AmazonPage clickKindle() throws Exception {
        clickOn("AmazonPage.clickAll");
        clickOn("AmazonPage.clickKindle");
        clickOn("AmazonPage.clickSubKindle");
        return this;
    }

    public AmazonPage clickOnBuy() throws Exception {
        clickOn("AmazonPage.clickBuy");
        return this;
    }

    public boolean isEmailDisplayed() throws Exception {
        return isWebElementDisplayed("AmazonPage.checkEmail");
    }
}
