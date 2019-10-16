package tests.OverviewTab;

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
import pages.Tabs.OverviewTab_Details;
import pages.Tabs.OverviewTab_Report;

import java.util.concurrent.TimeUnit;

public class OverviewTabReportElementsTextsTab {

    public WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
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
        Assert.assertTrue(overviewTabReport.currentRollUpPeriod.getText().startsWith("Current Roll Up Period"));
        Assert.assertEquals(overviewTabReport.downloadAdvancedReportHeader.getText(), "Download Advanced Report");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
