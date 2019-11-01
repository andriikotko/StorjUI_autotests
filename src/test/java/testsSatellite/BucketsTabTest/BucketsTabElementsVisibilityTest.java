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
import pages.Tabs.BucketsTab;

import java.util.concurrent.TimeUnit;

public class BucketsTabElementsVisibilityTest {
    public WebDriver driver;



    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        //driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.buckets.click();

    }


    @Test
    public void bucketsElementsVisibilityTest (){
        BucketsTab bucketsTab = PageFactory.initElements(driver, BucketsTab.class);

        if (bucketsTab.bucketsDiv.getAttribute("class").startsWith("no-buckets-area__header")){

        //case without  buckets
        //Assert.assertTrue(bucketsTab.noBucketsHeaderIcon.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsHeader.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsHeaderNotification.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsHowCreateHeader.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsUplinkCLI.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsCreateUplinkNotification.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsLinkToDocumentation.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsImage.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsLinkToS3.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsNextStepHeader.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsNextStepText.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsTextBeforeLinkS3.isDisplayed());
        Assert.assertTrue(bucketsTab.noBucketsIconNextStep.isDisplayed());}

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
