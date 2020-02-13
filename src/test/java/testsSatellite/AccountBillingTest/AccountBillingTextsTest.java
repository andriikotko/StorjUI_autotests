package testsSatellite.AccountBillingTest;

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
import pages.SystemParams;
import pages.Tabs.AccountTab_Billing;
import pages.Tabs.AccountTab_PaymentMethods;

import java.util.concurrent.TimeUnit;

public class AccountBillingTextsTest {
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
    public void billingTabelementsTextsTest (){
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);

        Assert.assertEquals(accountTab_billing.accountBalanceHeader.getText(),"Account Balance");
        Assert.assertTrue(accountTab_billing.accountBalanceBalance.getText().startsWith("Balance"));
  //      Assert.assertEquals(accountTab_billing.accountBalanceEarnCreditsButton.getText(), "Earn Credits");
        Assert.assertEquals(accountTab_billing.currentMonthHeader.getText(),"Current Month");
        //Assert.assertTrue(accountTab_billing.currentMonthTitle.isDisplayed());
        Assert.assertEquals(accountTab_billing.currentMonthContentTitle.getText(),"DETAILED SUMMARY");
        Assert.assertEquals(accountTab_billing.usageCharges.getText(),"Usage Charges");
 //       Assert.assertEquals(accountTab_billing.referralCredits.getText(),"Referral Credits");
        Assert.assertEquals(accountTab_billing.depositBillingHeader.getText(),"Deposit & Billing History");
        Assert.assertEquals(accountTab_billing.depositHistoryViewAllButton.getText(),"View All");
        Assert.assertEquals(accountTab_billing.depositHistoryDateHeader.getText(),"Date");
        Assert.assertEquals(accountTab_billing.depositHistoryDescriptionHeader.getText(),"Description");
        Assert.assertEquals(accountTab_billing.depositHistoryStatusHeader.getText(),"Status");
        Assert.assertEquals(accountTab_billing.depositHistoryAmountHeader.getText(),"Amount");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
