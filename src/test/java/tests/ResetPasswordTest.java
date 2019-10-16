package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Flows.ResetPasswordFlow;
import pages.HomePage;
import pages.LoginPage;


import java.util.concurrent.TimeUnit;

public class ResetPasswordTest {
    public static WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}
   @Test
   public void ResetPasswordTest() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);


    driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.HOMEURL);

        Thread.sleep(3000);
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage= PageFactory.initElements(driver, pages.LoginPage.class);
        ResetPasswordFlow ResetPasswordFlow = PageFactory.initElements(driver, pages.Flows.ResetPasswordFlow.class);
        LoginPage.linkForgotPassword.click();
        ResetPasswordFlow.Reset_Password_input.sendKeys(pages.HomePage.ACCOUNT);
        ResetPasswordFlow.Submit_Reset_Password.click();
       WebDriverWait wait = new WebDriverWait(driver,10);
       wait.until(ExpectedConditions.visibilityOf(ResetPasswordFlow.Notification_Reset_email_Success));
       //wait.until(ExpectedConditions.visibilityOf(HomePage.Error_Notification));
        Assert.assertEquals(ResetPasswordFlow.Notification_Reset_email_Success.getText(),"Please look for instructions at your email");


}
}
