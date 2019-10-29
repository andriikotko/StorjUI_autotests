package testsSatellite.AccountBillingTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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

public class AccountBillingElementsVisibilityTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
       // driver.manage().window().maximize();
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
    public void billingTabelementsVisibilityTest (){
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);

        Assert.assertTrue(accountTab_billing.accountBalanceHeader.isDisplayed());
        Assert.assertTrue(accountTab_billing.accountBalanceHint.isDisplayed());
        Assert.assertTrue(accountTab_billing.accountBalanceBalance.isDisplayed());
        Assert.assertTrue(accountTab_billing.accountBalanceEarnCreditsButton.isDisplayed());
        Assert.assertTrue(accountTab_billing.currentMonthHeader.isDisplayed());
        Assert.assertTrue(accountTab_billing.currentMonthTitle.isDisplayed());
        Assert.assertTrue(accountTab_billing.currentMonthContentTitle.isDisplayed());
        Assert.assertTrue(accountTab_billing.usageCharges.isDisplayed());
        Assert.assertTrue(accountTab_billing.referralCredits.isDisplayed());
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
