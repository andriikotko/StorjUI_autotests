package testsSatellite.ForgotPasswordTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.PasswordRecoveryFlow;
import pages.SystemParams;

import java.util.concurrent.TimeUnit;

public class PasswordRecoveryFlowTests {
    WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.linkForgotPassword.click();

    }
    @Ignore
    @Test
    public void passwordRecoveryFlowTest () throws InterruptedException {
//        PasswordRecoveryFlow passwordRecoveryFlow = PageFactory.initElements(driver,PasswordRecoveryFlow.class);
//
//        passwordRecoveryFlow.inputEmailField.sendKeys("andrii@storj.io");
//        passwordRecoveryFlow.resetPasswordButton.click();
//
//        Thread.sleep(5000);
//
//        driver.navigate().to("https://www.google.com/");
//
//        Thread.sleep(15000);
//
//        passwordRecoveryFlow.gmailOpen.click();
//        passwordRecoveryFlow.storjLetter.click();
//        passwordRecoveryFlow.emailResetPasswordLink.click();

        driver.get("https://www.google.com/");
        Thread.sleep(1300000);

    }




    @AfterMethod
    public void tearDown()
    {driver.quit();}
}
