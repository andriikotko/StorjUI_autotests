package testsSatellite.AccountPaymentMethodsTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Flows.NewProjectFlow;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.AccountTab_Billing;
import pages.Tabs.AccountTab_PaymentMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccountPaymentFunctionalTests {


    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
        homePage.billingTab.click();

    }

    @Test
    public void paymentStorjDroplistDisplayedTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", accountTab_billing.depositHistoryViewAllButton);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();


        Assert.assertTrue(accountTab_paymentMethods.paymentOptionsDroplist.isDisplayed());

    }

    @Test
    public void paymentStorjDroplistLengthTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", accountTab_billing.depositHistoryViewAllButton);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();

        ArrayList<WebElement> list1 = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[@id=\"paymentSelect\"]/div")));

        Assert.assertEquals(list1.size(), 6);
    }

    @Test
    public void paymentStorjDroplistValuesTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", accountTab_billing.depositHistoryViewAllButton);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"paymentSelect\"]/div[6]")));

        ArrayList<WebElement> list1 = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[@id=\"paymentSelect\"]/div")));
        ArrayList<String> list2 = new ArrayList<>();
        for (WebElement webElement : list1) {
            list2.add(webElement.getText());
        }
        List<String> list3 = new ArrayList<>(Arrays.asList("USD $20", "USD $5", "USD $10", "USD $100", "USD $1000", "Custom Amount"));
        System.out.println(list2);
        System.out.println(list3);

        Assert.assertEquals(list2, list3);
    }

    @Test
    public void paymentStorjDroplistSelectNotDefaultTest() throws InterruptedException {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", accountTab_billing.depositHistoryViewAllButton);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();

        ArrayList<WebElement> list1 = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[@id=\"paymentSelect\"]/div")));

        js.executeScript("arguments[0].scrollIntoView();", accountTab_billing.depositHistoryViewAllButton);
        list1.get(2).click();
        Assert.assertEquals(accountTab_paymentMethods.paymentSelectButton.getText(), "USD $10");
    }

    @Test
    public void paymentStorjDroplistSelectCustomTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", accountTab_billing.depositHistoryViewAllButton);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();

        ArrayList<WebElement> list1 = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[@id=\"paymentSelect\"]/div")));

        js.executeScript("arguments[0].scrollIntoView();", accountTab_billing.depositHistoryViewAllButton);
        list1.get(5).click();
        Assert.assertTrue(accountTab_paymentMethods.customInput.getAttribute("placeholder").startsWith("Enter Amount"));

    }

    @Test
    public void addCreditCardTest() throws InterruptedException {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", accountTab_billing.depositHistoryViewAllButton);
        accountTab_paymentMethods.addCreditCard();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));
        Assert.assertEquals(loginPage.notificationArea.getText(), "Card successfully added");

    }

    @Test
    public void proceedingToBillingWithNoPaymentMethods () throws InterruptedException {
        Thread.sleep(5500);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.userNameField.sendKeys("test999@g.com"); //without added card account
        loginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        loginPage.btn_Login.click();
        Thread.sleep(4500);

        homePage.bannerLinkToBilling.click();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/account/billing"));
    }


    @Test
    public void presence_disapearingAddCardNotification() throws InterruptedException {
        Thread.sleep(5500);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.userNameField.sendKeys("test444@g.com"); //without added card account
        loginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        loginPage.btn_Login.click();
        Thread.sleep(4500);

        Assert.assertTrue(homePage.bannerAddCard.isDisplayed());
        Assert.assertEquals(homePage.bannerAddCardHeader.getText(), "We’ve Now Added Billing!");
        Assert.assertEquals(homePage.bannerAddCardText.getText(), "Your attention is required. Add a credit card to set up your account.");
        Assert.assertTrue(homePage.bannerAddCardIcon.isDisplayed());

        homePage.profileTab.click();
        Assert.assertTrue(homePage.bannerAddCard.isDisplayed());

//        homePage.referralTab.click();
//        Assert.assertTrue(homePage.bannerAddCard.isDisplayed());

        homePage.billingTab.click();
        Assert.assertTrue(homePage.bannerOnBilling.isDisplayed());

        //ADD CARD
        accountTab_paymentMethods.addCreditCard();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));

        homePage.profileTab.click();

        Thread.sleep(5000);

        //Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dashboard-container__main-area\"]/div")).getAttribute("class").equals("dashboard-container__main-area__content"));

        List<WebElement> list =  driver.findElements(By.xpath("//*[@class=\"dashboard-container__main-area__banner-area\"]/div"));
        Assert.assertEquals(list.size(),0);


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}