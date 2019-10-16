package tests.LoginRelatedTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class NegativeLoginTest {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);
    }
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @Test(priority = 1)
    public void NegativeLoginTest() {
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.userNameField.sendKeys("badEmail@bad.email");
        loginPage.passwordField.sendKeys("badPassword123");
        loginPage.btn_Login.click();
        Assert.assertTrue(loginPage.notificationArea.isEnabled());
//        Thread.sleep(2000);
//        Assert.assertTrue(loginPage.notification_area.isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));
        Assert.assertTrue(loginPage.notificationArea.getText().endsWith("Your email or password was incorrect, please try again"));
       // Assert.assertEquals(loginPage.notification_area.getText(),"Your email or password was incorrect, please try again");
    }

    @Test
    public void loginValidationEmptyFelds(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.userNameField.sendKeys("");
        loginPage.passwordField.sendKeys("");
        loginPage.btn_Login.click();

        Assert.assertEquals(loginPage.emailValidationError.getText(), "Invalid Email");
        Assert.assertEquals(loginPage.passwordValidationError.getText(), "Invalid Password");
    }

    @Test
    public void loginValidationShortFelds(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.userNameField.sendKeys("12");
        loginPage.passwordField.sendKeys("22");
        loginPage.btn_Login.click();

        Assert.assertEquals(loginPage.emailValidationError.getText(), "Invalid Email");
        Assert.assertEquals(loginPage.passwordValidationError.getText(), "Invalid Password");
    }

}
