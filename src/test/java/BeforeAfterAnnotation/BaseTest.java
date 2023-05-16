package BeforeAfterAnnotation;

import com.Automation.utils.core.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
public class BaseTest implements ITestListener {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public IWebActions actions;
    public ResultSet rs = null;

    @BeforeSuite(alwaysRun = true)
    public void loadAllConfigurations() throws IOException {
        ExtentManager.getReporter();
        ConfigReader.loadFrameworkProperties();
    }

    @BeforeMethod(alwaysRun = true)
    public void initialiseBrowser(Method method) throws Exception {
        ExtentTestManager.startTest(method.getName(),"");
        driver.set(DriverManager.launchBrowser());
        actions = new WebActions(driver.get());
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUpTests() throws Exception {
        Reporter.logStepWithScreenshot("Test Case finished",actions.takeScreenshot());
        driver.get().close();
        ExtentTestManager.stopTest();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDownEverything() throws Exception{
        ExtentManager.getReporter().flush();
        ExtentManager.getReporter().close();
    }
}
