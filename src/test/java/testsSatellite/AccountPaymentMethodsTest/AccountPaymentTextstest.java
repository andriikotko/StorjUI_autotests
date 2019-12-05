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
import pages.Tabs.AccountTab_Billing;
import pages.Tabs.AccountTab_PaymentMethods;

import java.util.concurrent.TimeUnit;

public class AccountPaymentTextstest {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")){
            chosingOS = "";
        }
        if (OS.substring(0,4).equals("Windo")){
            chosingOS = ".exe";
        }
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH+chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH+chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH+chosingOS);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
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

    @Test
    public void paymentElementsTextsTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);

//
//        Assert.assertTrue(accountTab_billing.cardContainer.isDisplayed());
//       // Assert.assertTrue(accountTab_billing.cardContainerstorjLogo.isDisplayed());
//        Assert.assertTrue(accountTab_billing.cardContainerCardInfo.isDisplayed());
//        Assert.assertTrue(accountTab_billing.cardContainerCardExpire.isDisplayed());
//    //    Assert.assertTrue(accountTab_billing.cardContainerCardAddedDate.isDisplayed());
//        Assert.assertTrue(accountTab_billing.cardContainerMakeCardDefaultButton.isDisplayed());
//        Assert.assertTrue(accountTab_billing.addNewCardButton.isDisplayed());


        Assert.assertEquals(accountTab_paymentMethods.paymentMethodsHeader.getText(), "Payment Methods");
        Assert.assertEquals(accountTab_paymentMethods.addNewCardButton.getText(),"Add Card");
        Assert.assertEquals(accountTab_paymentMethods.addStorjPayButton.getText(),"Add STORJ");

    }

    @Test
    public void paymentStorjElementsTextsTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",accountTab_billing.depositHistoryViewAllButton);
        accountTab_paymentMethods.addStorjPayButton.click();


        Assert.assertEquals(accountTab_paymentMethods.depositStorjHeader.getText(),"Payment Methods");
        Assert.assertEquals(accountTab_paymentMethods.depositStorjNotification.getText(),"Deposit STORJ Tokens via Coin Payments");
        Assert.assertEquals(accountTab_paymentMethods.paymentSelectButton.getText(),"USD $20");
        Assert.assertEquals(accountTab_paymentMethods.continueToCoinPaymentsButton.getText(),"Continue to Coin Payments");
        Assert.assertEquals(accountTab_paymentMethods.paymentMethodsCancelButton.getText(),"Cancel");
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
