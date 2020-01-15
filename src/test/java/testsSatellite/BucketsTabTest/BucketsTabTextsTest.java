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

public class BucketsTabTextsTest {
    public WebDriver driver;


    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")){
            chosingOS = "";
        }
        if (OS.substring(0,4).equals("Windo")){
            chosingOS = ".exe";
        }
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH+chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH+chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH+chosingOS);
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
    public void bucketsElementsTextsTest() {
        BucketsTab bucketsTab = PageFactory.initElements(driver, BucketsTab.class);

        if (bucketsTab.bucketsDiv.getAttribute("class").startsWith("no-buckets-area")) {

            //case without  buckets
            Assert.assertEquals(bucketsTab.noBucketsHeader.getText(), "Bucket Usage");
            Assert.assertEquals(bucketsTab.noBucketsHeaderNotification.getText(), "Create Buckets & Upload Objects from the Command Line");
            Assert.assertEquals(bucketsTab.noBucketsHowCreateHeader1.getText(), "Set Up The Uplink CLI");
            Assert.assertEquals(bucketsTab.noBucketsHowCreateHeader2.getText(), "Upload Data Securely");
            Assert.assertEquals(bucketsTab.noBucketsHowCreateHeader3.getText(), "View Usage Here");
            Assert.assertEquals(bucketsTab.noBucketsCreateFirstButtonText.getText(), "Create My First Bucket");
            Assert.assertTrue(bucketsTab.noBucketsLinkToWhy.getAttribute("href").startsWith("https://support.tardigrade.io/hc/en-us/articles/360035332472-Why-can-t-I-upload-from-the-browser-"));
            Assert.assertTrue(bucketsTab.noBucketsCreateFirstButton.getAttribute("href").startsWith("https://documentation.tardigrade.io/api-reference/uplink-cli"));
            Assert.assertEquals(bucketsTab.noBucketsLinkToWhy.getText(), "Why can't I upload from the browser?");
            Assert.assertEquals(bucketsTab.noBucketsSetupStep1.getText(), "Please enter numeric choice or enter satellite address manually [1]: 1");
            Assert.assertEquals(bucketsTab.noBucketsSetupStep2.getText(), "Enter your API key:");
            Assert.assertEquals(bucketsTab.noBucketsSetupStep3.getText(), "13YqgbUXRiavXB1qHMtKkHGNHPydtTBgXoZeeofy6aY4n1ewBMDoBS7eV7726nsgVQDfqeL9gQRqjQTyMUGDCFC6yWGPUEHGxJsT");
            Assert.assertEquals(bucketsTab.noBucketsUploadStep1.getText(), "./uplink mb sj://sample");
            Assert.assertEquals(bucketsTab.noBucketsUploadStep2.getText(), "\"Sample\" Bucket Created");
            Assert.assertEquals(bucketsTab.noBucketsUploadStep3.getText(), "./uplink cp ~/Desktop/your-large-file.mp4 sj://bucket-name");
            Assert.assertEquals(bucketsTab.noBucketsUploadStep4.getText(), "\"your-large-file.mp4\" Successfully uploaded");

        } else {
            //case with buckets
            Assert.assertEquals(bucketsTab.bucketsHeader.getText(), "Buckets");
            Assert.assertEquals(bucketsTab.bucketsNOtificationText.getText(), "Usage will appear within an hour of activity.");
            Assert.assertTrue(bucketsTab.bucketsSearch.getAttribute("placeholder").startsWith("Search Buckets"));
            Assert.assertEquals(bucketsTab.bucketNameHeader.getText(), "Bucket Name");
            Assert.assertEquals(bucketsTab.storageUsedHeader.getText(), "Storage Used, GB");
            Assert.assertEquals(bucketsTab.egressUsedHeader.getText(), "Egress Used, GB");
            Assert.assertEquals(bucketsTab.objectsStoredHeader.getText(), "Objects Stored");
        }


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
