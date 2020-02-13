package testsSatellite.ForgotPasswordTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordTextsTest {
    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

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
