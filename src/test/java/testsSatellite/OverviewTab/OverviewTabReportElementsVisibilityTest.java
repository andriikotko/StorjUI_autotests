package testsSatellite.OverviewTab;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.OverviewTab_Details;
import pages.Tabs.OverviewTab_Report;

import java.util.concurrent.TimeUnit;

public class OverviewTabReportElementsVisibilityTest {

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
        //driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.overview_tab.click();

        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.reportTab.click();

    }

    @Test
    public void overviewReportTabElementsVisibilityTest (){
       OverviewTab_Report overviewTabReport = PageFactory.initElements(driver, OverviewTab_Report.class);


        Assert.assertTrue(overviewTabReport.reportTabHeader.isDisplayed());
        Assert.assertTrue(overviewTabReport.currentBillingPeriod.isDisplayed());
        Assert.assertTrue(overviewTabReport.previousBillingPeriod.isDisplayed());
        Assert.assertTrue(overviewTabReport.customDateRange.isDisplayed());
       // Assert.assertTrue(overviewTabReport.customDateRangeIcon.isDisplayed());
        Assert.assertTrue(overviewTabReport.storageHeader.isDisplayed());
        Assert.assertTrue(overviewTabReport.storageValue.isDisplayed());
        Assert.assertTrue(overviewTabReport.egressHeader.isDisplayed());
        Assert.assertTrue(overviewTabReport.egressValue.isDisplayed());
        Assert.assertTrue(overviewTabReport.objectHoursHeader.isDisplayed());
        Assert.assertTrue(overviewTabReport.objectHoursValue.isDisplayed());
        Assert.assertTrue(overviewTabReport.currentRollUpPeriod.isDisplayed());
        Assert.assertTrue(overviewTabReport.downloadAdvancedReportHeader.isDisplayed());
      //  Assert.assertTrue(overviewTabReport.downloadAdvancedReportButton.isDisplayed());

    }





    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
