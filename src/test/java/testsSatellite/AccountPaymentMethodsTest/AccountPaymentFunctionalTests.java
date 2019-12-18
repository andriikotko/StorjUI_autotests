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

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")) {
            chosingOS = "";
        }
        if (OS.substring(0, 4).equals("Windo")) {
            chosingOS = ".exe";
        }
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("Firefox")) {
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH + chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("Chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH + chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if (browser.equalsIgnoreCase("Opera")) {
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH + chosingOS);
            driver = new OperaDriver();
        } else {
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
    public void presence_disapearingAddCardNotification() throws InterruptedException {
        Thread.sleep(5500);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.userNameField.sendKeys("test777@g.com"); //without added card account
        loginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        loginPage.btn_Login.click();
        Thread.sleep(4500);

        Assert.assertTrue(homePage.bannerAddCard.isDisplayed());
        Assert.assertEquals(homePage.bannerAddCardHeader.getText(), "You have no payment method added.");
        Assert.assertEquals(homePage.bannerAddCardText.getText(), "To start work with your account please add Credit Card or add $50.00 or more worth of STORJ tokens to your balance.");
        Assert.assertTrue(homePage.bannerAddCardIcon.isDisplayed());

        homePage.profileTab.click();
        Assert.assertTrue(homePage.bannerAddCard.isDisplayed());

        homePage.referralTab.click();
        Assert.assertTrue(homePage.bannerAddCard.isDisplayed());

        homePage.billingTab.click();
        Assert.assertTrue(homePage.bannerAddCard.isDisplayed());

        //ADD CARD
        accountTab_paymentMethods.addCreditCard();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));

        homePage.profileTab.click();

        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"dashboard-container__main-area\"]/div")).getAttribute("class").equals("dashboard-container__main-area__content"));


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}