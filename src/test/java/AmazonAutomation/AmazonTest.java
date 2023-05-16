package AmazonAutomation;
import com.AmazonAutomation.AmazonPage;
import BeforeAfterAnnotation.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {
    @Test
    public void launchbrowser() throws Exception {
        AmazonPage amazon=new AmazonPage(driver.get());
        amazon.navigateToWebsite().clickKindle().clickOnBuy();
        Assert.assertTrue(amazon.isEmailDisplayed(),"Testcase Passed");
        Thread.sleep(500);
    }
}
