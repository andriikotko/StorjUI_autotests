package tests.AccountRelatedTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class NegativeNewAccountCreationTest {
//    public static WebDriver driver;
//    @AfterMethod
//    public void tearDown()
//    {driver.quit();}
//
//    @Test
//    public void NewAccountCreationTest() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
//        driver.get(HomePage.REGISTERURL);
//        Thread.sleep(2000);
//
//        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
//        registrationPage.createAccountButton.click();
//        Thread.sleep(1000);
//        Assert.assertTrue(registrationPage.checkBoxValidationError.isDisplayed());
//        Assert.assertTrue(registrationPage.emailValidationError.getText().endsWith("Invalid Email"));
//        Assert.assertTrue(registrationPage.fullNameValidationError.getText().endsWith("Invalid Name"));
//        Assert.assertTrue(registrationPage.passwordValidationError.getText().endsWith("Invalid Password"));
//
//
//
//    }
}