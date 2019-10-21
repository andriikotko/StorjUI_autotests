package tests.BucketsTabTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.BucketsTab;

import java.util.concurrent.TimeUnit;

public class BucketsTabTextsTest {
    public WebDriver driver;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.manage().window().maximize();
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
    public void bucketsElementsTextsTest() {
        BucketsTab bucketsTab = PageFactory.initElements(driver, BucketsTab.class);

        if (bucketsTab.bucketsDiv.getAttribute("class").startsWith("no-buckets-area__header")) {

            //case without  buckets
            Assert.assertEquals(bucketsTab.noBucketsHeader.getText(), "Buckets");
            Assert.assertEquals(bucketsTab.noBucketsHeaderNotification.getText(), "To create a bucket, please use the following CLI documentation. We will soon enable client-side encryption through the browser, at which time you will be able to create buckets and upload objects directly from this dashboard.");
            Assert.assertEquals(bucketsTab.noBucketsHowCreateHeader.getText(), "Create Buckets and Upload Objects from the Command Line");
            Assert.assertEquals(bucketsTab.noBucketsUplinkCLI.getText(), "Uplink CLI");
            Assert.assertEquals(bucketsTab.noBucketsCreateUplinkNotification.getText(), "One of the ways you can interact with the network to upload and download files");
            Assert.assertEquals(bucketsTab.noBucketsLinkToDocumentation.getText(), "Documentation");
            Assert.assertTrue(bucketsTab.noBucketsLinkToDocumentation.getAttribute("href").startsWith("https://github.com/storj/storj/wiki/Uplink-CLI"));
            Assert.assertTrue(bucketsTab.noBucketsLinkToS3.getAttribute("href").startsWith("https://github.com/storj/storj/wiki/S3-Gateway"));
            Assert.assertEquals(bucketsTab.noBucketsLinkToS3.getText(), "Try our S3 Gateway");
            Assert.assertEquals(bucketsTab.noBucketsNextStepHeader.getText(), "Next step");
            Assert.assertEquals(bucketsTab.noBucketsNextStepText.getText(), "After you create a bucket using the CLI, you will be able to see your buckets and usage here. This happens within 10 minutes of creating your first bucket.");
            Assert.assertTrue(bucketsTab.noBucketsTextBeforeLinkS3.getText().startsWith("Familiar with AWS S3?"));
        } else {
            //case with buckets
            Assert.assertEquals(bucketsTab.bucketsHeader.getText(), "Buckets");
            Assert.assertEquals(bucketsTab.bucketsNOtificationText.getText(), "Usage will appear within an hour of activity.");
            Assert.assertTrue(bucketsTab.bucketsSearch.getAttribute("placeholder").startsWith("Search Buckets"));
            Assert.assertEquals(bucketsTab.bucketNameHeader.getText(), "Bucket Name");
            Assert.assertEquals(bucketsTab.storageUsedHeader.getText(), "Storage Used, GBh");
            Assert.assertEquals(bucketsTab.egressUsedHeader.getText(), "Egress Used, GB");
            Assert.assertEquals(bucketsTab.objectsStoredHeader.getText(), "Objects Stored");
        }


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
