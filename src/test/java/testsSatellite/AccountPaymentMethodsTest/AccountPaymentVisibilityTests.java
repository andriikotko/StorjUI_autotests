package testsSatellite.AccountPaymentMethodsTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

public class AccountPaymentVisibilityTests {
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
    public void paymentElementsVisibilityTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);

//
//        Assert.assertTrue(accountTab_billing.cardContainer.isDisplayed());
//       // Assert.assertTrue(accountTab_billing.cardContainerstorjLogo.isDisplayed());
//        Assert.assertTrue(accountTab_billing.cardContainerCardInfo.isDisplayed());
//        Assert.assertTrue(accountTab_billing.cardContainerCardExpire.isDisplayed());
//    //    Assert.assertTrue(accountTab_billing.cardContainerCardAddedDate.isDisplayed());
//        Assert.assertTrue(accountTab_billing.cardContainerMakeCardDefaultButton.isDisplayed());
//        Assert.assertTrue(accountTab_billing.addNewCardButton.isDisplayed());


        Assert.assertTrue(accountTab_paymentMethods.paymentMethodsHeader.isDisplayed());
        Assert.assertTrue(accountTab_paymentMethods.addNewCardButton.isDisplayed());
        Assert.assertTrue(accountTab_paymentMethods.addStorjPayButton.isDisplayed());

    }

    @Test
    public void paymentStorjElementsVisibilityTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",accountTab_billing.depositHistoryViewAllButton);
        accountTab_paymentMethods.addStorjPayButton.click();


        Assert.assertTrue(accountTab_paymentMethods.depositStorjHeader.isDisplayed());
        Assert.assertTrue(accountTab_paymentMethods.depositStorjNotification.isDisplayed());
        Assert.assertTrue(accountTab_paymentMethods.paymentSelectButton.isDisplayed());
        Assert.assertTrue(accountTab_paymentMethods.droplistTick.isDisplayed());
        Assert.assertTrue(accountTab_paymentMethods.continueToCoinPaymentsButton.isDisplayed());
        Assert.assertTrue(accountTab_paymentMethods.paymentMethodsCancelButton.isDisplayed());
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
