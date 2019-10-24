package testsSatellite.BucketsTabTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BucketsFunctionalTests {
    public WebDriver driver;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
    public void gotoDocumentation() {
        BucketsTab bucketsTab = PageFactory.initElements(driver, BucketsTab.class);

        if (bucketsTab.bucketsDiv.getAttribute("class").startsWith("no-buckets-area__header")) {

            //case without  buckets
            bucketsTab.noBucketsLinkToDocumentation.click();
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Assert.assertEquals(driver.getCurrentUrl(),"https://github.com/storj/storj/wiki/Uplink-CLI");
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"wiki-body\"]/div/h1")).getText(), "Uplink CLI tutorial");
        }

    }

    @Test
    public void gotoS3() {
        BucketsTab bucketsTab = PageFactory.initElements(driver, BucketsTab.class);

        if (bucketsTab.bucketsDiv.getAttribute("class").startsWith("no-buckets-area__header")) {

            //case without  buckets
            bucketsTab.noBucketsLinkToS3.click();
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Assert.assertEquals(driver.getCurrentUrl(),"https://github.com/storj/storj/wiki/S3-Gateway");
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"wiki-body\"]/div/h1")).getText(),"S3 gateway tutorial");
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}





















