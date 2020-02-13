package testsSatellite;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Flows.ResetPasswordFlow;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;


import java.util.concurrent.TimeUnit;

public class ResetPasswordTest {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void ResetPasswordTest() throws InterruptedException {


        LoginPage LoginPage = PageFactory.initElements(driver, pages.LoginPage.class);
        ResetPasswordFlow ResetPasswordFlow = PageFactory.initElements(driver, pages.Flows.ResetPasswordFlow.class);
        LoginPage.linkForgotPassword.click();
        ResetPasswordFlow.Reset_Password_input.sendKeys(pages.HomePage.ACCOUNT);
        ResetPasswordFlow.Submit_Reset_Password.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(ResetPasswordFlow.Notification_Reset_email_Success));
        //wait.until(ExpectedConditions.visibilityOf(HomePage.Error_Notification));
        Assert.assertEquals(ResetPasswordFlow.Notification_Reset_email_Success.getText(), "Please look for instructions at your email");


    }
}
