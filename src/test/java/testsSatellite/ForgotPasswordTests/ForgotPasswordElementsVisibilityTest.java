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

public class ForgotPasswordElementsVisibilityTest {
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
    public void forgotPasswordElementsVisibilityTest(){

        ForgotPasswordPage forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);

        Assert.assertTrue(forgotPasswordPage.storjLogo.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.backToLoginButton.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.forgotPasswordHeader.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.forgotPasswordNotification.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.inputEmailField.isDisplayed());
        Assert.assertTrue(forgotPasswordPage.resetPasswordButton.isDisplayed());
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
