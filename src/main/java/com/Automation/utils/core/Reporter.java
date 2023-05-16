package com.Automation.utils.core;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporter {

    public static void logPassedStep(String message) {
        ExtentTestManager.getTest().log(LogStatus.PASS, message);
    }

    public static void logFailedStep(String message) {
        ExtentTestManager.getTest().log(LogStatus.FAIL, message);
    }

    public static void logStepWithScreenshot(String message,String base64Text) {
        ExtentTestManager.getTest().log(LogStatus.PASS, "Screenshot Captured: <br>: " + ExtentTestManager.getTest().addScreenCapture(base64Text));}


}