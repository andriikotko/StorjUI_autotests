package testsSatellite.ForgotPasswordTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordTextsTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
       // driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.linkForgotPassword.click();

    }

    @Test
    public void forgotPasswordTextsTest(){

        ForgotPasswordPage forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);

        Assert.assertTrue(forgotPasswordPage.storjLogo.getAttribute("class").endsWith("forgot-password-container__logo"));
        Assert.assertEquals(forgotPasswordPage.backToLoginButton.getText(),"Back to Login");
        Assert.assertEquals(forgotPasswordPage.forgotPasswordHeader.getText(), "Forgot Password");
        Assert.assertEquals(forgotPasswordPage.forgotPasswordNotification.getText(),"Enter your email address below and we'll get you back on track.");
        Assert.assertTrue(forgotPasswordPage.inputEmailField.getAttribute("placeholder").endsWith("Enter Your Email"));
        Assert.assertEquals(forgotPasswordPage.resetPasswordButton.getText(),"Reset Password");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
