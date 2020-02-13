package testsSatellite.BucketsTabTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.BucketsTab;

import java.util.concurrent.TimeUnit;

public class BucketsTabElementsVisibilityTest {
    public WebDriver driver;



    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
        homePage.buckets.click();

    }


    @Test
    public void bucketsElementsVisibilityTest (){
        BucketsTab bucketsTab = PageFactory.initElements(driver, BucketsTab.class);

        if (bucketsTab.bucketsDiv.getAttribute("class").startsWith("no-buckets-area")){

        //case without  buckets
        //Assert.assertTrue(bucketsTab.noBucketsHeaderIcon.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsHeader.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsHeaderNotification.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsStepsImage.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsHowCreateHeader1.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsHowCreateHeader2.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsHowCreateHeader3.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsSetupContainer1.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsSetupContainer2.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsSetupContainer3.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsCreateFirstButton.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsLinkToWhy.isDisplayed());}


        else{
        //case with buckets
        Assert.assertTrue(bucketsTab.bucketsHeader.isDisplayed());
        //Assert.assertTrue(bucketsTab.bucketsNotificationIcon.isDisplayed());
        Assert.assertTrue(bucketsTab.bucketsNOtificationText.isDisplayed());
        Assert.assertTrue(bucketsTab.bucketsSearch.isDisplayed());
        Assert.assertTrue(bucketsTab.bucketNameHeader.isDisplayed());
        Assert.assertTrue(bucketsTab.storageUsedHeader.isDisplayed());
        Assert.assertTrue(bucketsTab.egressUsedHeader.isDisplayed());
        Assert.assertTrue(bucketsTab.objectsStoredHeader.isDisplayed());
        Assert.assertTrue(bucketsTab.firstBucketNameValue.isDisplayed());
        Assert.assertTrue(bucketsTab.firstBucketStorageUsed.isDisplayed());
        Assert.assertTrue(bucketsTab.firstBucketEgressUsed.isDisplayed());
        Assert.assertTrue(bucketsTab.firstBucketObjectsStored.isDisplayed());}




    }




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
