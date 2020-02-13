package testsSatellite.OverviewTab;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.OverviewTab_Details;
import pages.Tabs.OverviewTab_Report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class OverviewReportFunctionalTests {
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
    public void overviewReportAdvancedReportLinkTest () throws Exception {

        OverviewTab_Report overviewTabReport = PageFactory.initElements(driver, OverviewTab_Report.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        overviewTabReport.downloadAdvancedReportButton.click();

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
//        driver.close();
//        driver.switchTo().window(tabs2.get(0));

        Assert.assertTrue(driver.getCurrentUrl().startsWith("http://localhost:"+ (homePage.satellitePort()) +"/usage-report?projectID="));

    }

    @Test
    public void overviewReportAdvancedReportTest () {

        OverviewTab_Report overviewTabReport = PageFactory.initElements(driver, OverviewTab_Report.class);

        overviewTabReport.downloadAdvancedReportButton.click();

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
//        driver.close();
//        driver.switchTo().window(tabs2.get(0));

        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/table/thead/tr[1]/th[1]")).getText() ,"Bucket Name");

    }

    @Test
    public void overviewReportTabCalendarVisibilityTest (){
        OverviewTab_Report overviewTabReport = PageFactory.initElements(driver, OverviewTab_Report.class);

        overviewTabReport.customDateRange.click();

        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(overviewTabReport.calendarForCustomDataRange));

        Assert.assertTrue(overviewTabReport.calendarForCustomDataRange.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
