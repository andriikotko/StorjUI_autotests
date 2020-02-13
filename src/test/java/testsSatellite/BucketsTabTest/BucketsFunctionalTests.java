package testsSatellite.BucketsTabTest;

import org.openqa.selenium.By;
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

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BucketsFunctionalTests {
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
    public void gotoDocumentation() {
        BucketsTab bucketsTab = PageFactory.initElements(driver, BucketsTab.class);

        if (bucketsTab.bucketsDiv.getAttribute("class").startsWith("no-buckets-area")) {

            //case without  buckets
            bucketsTab.noBucketsCreateFirstButton.click();
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Assert.assertEquals(driver.getCurrentUrl(),"https://documentation.tardigrade.io/api-reference/uplink-cli");
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__GITBOOK__ROOT__\"]/div/div[2]/div/div[1]/div[3]/div/div[1]/div[1]/div[1]/div/div/div[1]/div[1]/h1/span")).getText(), "Uplink CLI");
        }

    }

    @Test
    public void gotoS3() {
        BucketsTab bucketsTab = PageFactory.initElements(driver, BucketsTab.class);

        if (bucketsTab.bucketsDiv.getAttribute("class").startsWith("no-buckets-area")) {

            //case without  buckets
            bucketsTab.noBucketsLinkToWhy.click();
            ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs2.get(1));
            Assert.assertEquals(driver.getCurrentUrl(),"https://support.tardigrade.io/hc/en-us/articles/360035332472-Why-can-t-I-upload-from-the-browser-");
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"article-container\"]/article/header/h1")).getText(),"Why can’t I upload from the browser?");
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}





















