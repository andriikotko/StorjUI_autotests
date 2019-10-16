package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.PaymentsTab;

import java.util.concurrent.TimeUnit;

public class AddPaymentCardTest {
    public WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @Ignore
    @Test
    public void AddPaymentCardTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);

        Thread.sleep(3000);
        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        PaymentsTab PaymmentsTab =PageFactory.initElements(driver, PaymentsTab.class);
        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(5000);
        PaymmentsTab.Payment_Tab.click();
        Thread.sleep(2000);
        driver.switchTo().frame(PaymmentsTab.STRIPE_IFRAME);
        Thread.sleep(1000);
        PaymmentsTab.Card_Input.sendKeys("4242424242424242233323326000");
        driver.switchTo().defaultContent();
        PaymmentsTab.Save_Card_Button.click();
        

    }
}
