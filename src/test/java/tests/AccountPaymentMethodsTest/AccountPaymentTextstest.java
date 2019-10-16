package tests.AccountPaymentMethodsTest;

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

public class AccountPaymentTextstest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.billingTab.click();

    }
    @Ignore
    @Test
    public void billingTabelementsVisibility (){
        AccountTab_PaymentMethods accountTab_billing = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);


     //   Assert.assertTrue(accountTab_billing.cardContainerstorjLogo.getAttribute("src").endsWith("/static/dist/img/Logo.a3cba3e8.svg"));
        Assert.assertEquals(accountTab_billing.cardContainerMakeCardDefaultButton.getText(),"Default");
        Assert.assertEquals(accountTab_billing.addNewCardButton.getText(),"Add Card");
        Assert.assertEquals(accountTab_billing.cardDeleteCardButton.getText(), "Delete");
        Assert.assertEquals(accountTab_billing.addStorjPayButton.getText(),"Add STORJ");




    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
