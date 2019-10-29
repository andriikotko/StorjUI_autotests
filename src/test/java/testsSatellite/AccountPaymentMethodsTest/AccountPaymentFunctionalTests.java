package testsSatellite.AccountPaymentMethodsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.AccountTab_PaymentMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AccountPaymentFunctionalTests {


    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    @Test
    public void paymentStorjDroplistDisplayedTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();


        Assert.assertTrue(accountTab_paymentMethods.paymentOptionsDroplist.isDisplayed());

    }
    @Test
    public void paymentStorjDroplistLengthTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();

        ArrayList<WebElement> list1 = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[@id=\"paymentSelect\"]/div")));

        Assert.assertEquals(list1.size(),6);
    }
    @Test
    public void paymentStorjDroplistValuesTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();

        ArrayList<WebElement> list1 = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[@id=\"paymentSelect\"]/div")));
        ArrayList<String > list2 = new ArrayList<>();
        for (WebElement webElement : list1) {
            list2.add(webElement.getText());
        }
        List<String> list3 = new ArrayList<>(Arrays.asList("US $20 (+5 Bonus)", "US $5", "US $10 (+2 Bonus)", "US $100 (+20 Bonus)", "US $1000 (+200 Bonus)", "Custom Amount"));

        Assert.assertEquals(list2,list3);
    }
    @Test
    public void paymentStorjDroplistSelectNotDefaultTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();

        ArrayList<WebElement> list1 = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[@id=\"paymentSelect\"]/div")));

        list1.get(2).click();
        Assert.assertEquals(accountTab_paymentMethods.paymentSelectButton.getText(),"US $10 (+2 Bonus)");
    }
    @Test
    public void paymentStorjDroplistSelectCustomTest() {
        AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
        accountTab_paymentMethods.addStorjPayButton.click();
        accountTab_paymentMethods.paymentSelectButton.click();

        ArrayList<WebElement> list1 = new ArrayList<WebElement>(driver.findElements(By.xpath("//*[@id=\"paymentSelect\"]/div")));

        list1.get(5).click();
        Assert.assertTrue(accountTab_paymentMethods.customInput.getAttribute("placeholder").startsWith("Enter Amount"));

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}