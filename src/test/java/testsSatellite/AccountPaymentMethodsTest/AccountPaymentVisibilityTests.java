package testsSatellite.AccountPaymentMethodsTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.AccountTab_PaymentMethods;

import java.util.concurrent.TimeUnit;

public class AccountPaymentVisibilityTests {
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
