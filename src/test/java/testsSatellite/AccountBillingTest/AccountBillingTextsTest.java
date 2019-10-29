package testsSatellite.AccountBillingTest;

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
import pages.Tabs.AccountTab_Billing;
import pages.Tabs.AccountTab_PaymentMethods;

import java.util.concurrent.TimeUnit;

public class AccountBillingTextsTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        //driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.billingTab.click();

    }

    @Test
    public void billingTabelementsVisibility (){
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);

        Assert.assertEquals(accountTab_billing.accountBalanceHeader.getText(),"Account Balance");
        Assert.assertTrue(accountTab_billing.accountBalanceBalance.getText().startsWith("Balance"));
        Assert.assertEquals(accountTab_billing.accountBalanceEarnCreditsButton.getText(), "Earn Credits");
        Assert.assertEquals(accountTab_billing.currentMonthHeader.getText(),"Current Month");
        //Assert.assertTrue(accountTab_billing.currentMonthTitle.isDisplayed());
        Assert.assertEquals(accountTab_billing.currentMonthContentTitle.getText(),"DETAILED SUMMARY");
        Assert.assertEquals(accountTab_billing.usageCharges.getText(),"Usage Charges");
        Assert.assertEquals(accountTab_billing.referralCredits.getText(),"Referral Credits");
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
