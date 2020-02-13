package testsSatellite.AccountBillingTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.AccountTab_Billing;
import pages.Tabs.AccountTab_PaymentMethods;

import java.util.concurrent.TimeUnit;

public class AccountBillingElementsVisibilityTest {
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
    public void billingTabelementsVisibilityTest (){
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);

        Assert.assertTrue(accountTab_billing.accountBalanceHeader.isDisplayed());
        Assert.assertTrue(accountTab_billing.accountBalanceHint.isDisplayed());
        Assert.assertTrue(accountTab_billing.accountBalanceBalance.isDisplayed());
     //   Assert.assertTrue(accountTab_billing.accountBalanceEarnCreditsButton.isDisplayed());
        Assert.assertTrue(accountTab_billing.currentMonthHeader.isDisplayed());
        Assert.assertTrue(accountTab_billing.currentMonthTitle.isDisplayed());
        Assert.assertTrue(accountTab_billing.currentMonthContentTitle.isDisplayed());
        Assert.assertTrue(accountTab_billing.usageCharges.isDisplayed());
      //  Assert.assertTrue(accountTab_billing.referralCredits.isDisplayed());
        Assert.assertTrue(accountTab_billing.depositBillingHeader.isDisplayed());
        Assert.assertTrue(accountTab_billing.depositHistoryViewAllButton.isDisplayed());
        Assert.assertTrue(accountTab_billing.depositHistoryDateHeader.isDisplayed());
        Assert.assertTrue(accountTab_billing.depositHistoryDescriptionHeader.isDisplayed());
        Assert.assertTrue(accountTab_billing.depositHistoryStatusHeader.isDisplayed());
        Assert.assertTrue(accountTab_billing.depositHistoryAmountHeader.isDisplayed());

    }


    @Test
    public void hintVisibilityTest (){
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);

        Actions action = new Actions(driver);
        action.moveToElement(accountTab_billing.accountBalanceHint).click().perform();


        Assert.assertTrue(accountTab_billing.accountBalanceHintText.isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
