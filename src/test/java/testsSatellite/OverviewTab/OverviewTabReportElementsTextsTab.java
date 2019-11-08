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

public class OverviewTabReportElementsTextsTab {

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
        driver.manage().window().maximize();
        //driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
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
    public void overviewReportElementsTextsTest () {

        OverviewTab_Report overviewTabReport = PageFactory.initElements(driver, OverviewTab_Report.class);

        Assert.assertEquals(overviewTabReport.reportTabHeader.getText(), "Report");
        Assert.assertEquals(overviewTabReport.currentBillingPeriod.getText(), "Current Billing Period");
        Assert.assertEquals(overviewTabReport.previousBillingPeriod.getText(), "Previous Billing Period");
        Assert.assertEquals(overviewTabReport.customDateRange.getText(), "Custom Date Range");
        Assert.assertEquals(overviewTabReport.storageHeader.getText(), "Storage, GBh");
        Assert.assertEquals(overviewTabReport.egressHeader.getText(), "Egress, GB");
        Assert.assertEquals(overviewTabReport.objectHoursHeader.getText(), "Object Hours");
        Assert.assertTrue(overviewTabReport.currentRollUpPeriod.getText().startsWith("Roll Up Period"));
        Assert.assertEquals(overviewTabReport.downloadAdvancedReportHeader.getText(), "Download Advanced Report");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
