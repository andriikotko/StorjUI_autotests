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
import pages.SystemParams;
import pages.Tabs.OverviewTab_Details;
import pages.Tabs.OverviewTab_Report;

import java.util.concurrent.TimeUnit;

public class OverviewTabReportElementsVisibilityTest {

    public WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
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
