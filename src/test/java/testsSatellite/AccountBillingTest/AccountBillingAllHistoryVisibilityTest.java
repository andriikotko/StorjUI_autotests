package testsSatellite.AccountBillingTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.AccountTab_AllBillingHistory;
import pages.Tabs.AccountTab_Billing;

import java.util.concurrent.TimeUnit;

public class AccountBillingAllHistoryVisibilityTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
        homePage.billingTab.click();
    }

    @Test
    public void billingHiistoryElementsVisibility () {
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",accountTab_billing.depositHistoryViewAllButton);
        accountTab_billing.depositHistoryViewAllButton.click();
        AccountTab_AllBillingHistory accountTab_allBillingHistory = PageFactory.initElements(driver, AccountTab_AllBillingHistory.class);

        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryDateHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryDescriptionHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryStatusHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryAmountHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryBackButton.isDisplayed());
    //    Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryPaginator.isDisplayed());


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
