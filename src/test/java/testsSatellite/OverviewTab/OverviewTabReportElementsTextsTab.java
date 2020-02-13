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

public class OverviewTabReportElementsTextsTab {

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
    public void overviewReportElementsTextsTest () {

        OverviewTab_Report overviewTabReport = PageFactory.initElements(driver, OverviewTab_Report.class);

        Assert.assertEquals(overviewTabReport.reportTabHeader.getText(), "Report");
        Assert.assertEquals(overviewTabReport.currentBillingPeriod.getText(), "Current Billing Period");
        Assert.assertEquals(overviewTabReport.previousBillingPeriod.getText(), "Previous Billing Period");
        Assert.assertEquals(overviewTabReport.customDateRange.getText(), "Custom Date Range");
        Assert.assertEquals(overviewTabReport.storageHeader.getText(), "Storage, GB x Hours");
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
