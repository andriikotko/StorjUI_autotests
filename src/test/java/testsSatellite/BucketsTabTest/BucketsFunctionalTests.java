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
import pages.Tabs.BucketsTab;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BucketsFunctionalTests {
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





















