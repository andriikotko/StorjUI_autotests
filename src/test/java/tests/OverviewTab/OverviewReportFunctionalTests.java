package tests.OverviewTab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.OverviewTab_Details;
import pages.Tabs.OverviewTab_Report;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class OverviewReportFunctionalTests {
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
    public void overviewReportAdvancedReportLinkTest () {

        OverviewTab_Report overviewTabReport = PageFactory.initElements(driver, OverviewTab_Report.class);

        overviewTabReport.downloadAdvancedReportButton.click();

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
//        driver.close();
//        driver.switchTo().window(tabs2.get(0));

        Assert.assertTrue(driver.getCurrentUrl().startsWith("http://localhost:14002/usage-report/?projectID="));

    }
    @Ignore
    @Test
    public void overviewReportAdvancedReportTest () {

        OverviewTab_Report overviewTabReport = PageFactory.initElements(driver, OverviewTab_Report.class);

        overviewTabReport.downloadAdvancedReportButton.click();

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
//        driver.close();
//        driver.switchTo().window(tabs2.get(0));

      //  Assert.assertEquals(driver.findElement(By.xpath("").ge ,""));

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
