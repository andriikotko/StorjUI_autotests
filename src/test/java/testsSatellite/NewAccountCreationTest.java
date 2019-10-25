package testsSatellite;

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

public class NewAccountCreationTest {
    public static WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}
    @Test
    public void NewAccountCreationTest () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.REGISTERURL);

        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.fullNameInput.sendKeys("testFullName");
        registrationPage.nicknameInput.sendKeys("testShortName");
        registrationPage.emailInput.sendKeys("testNewEmail@gmail.com");
        registrationPage.passwordInput.sendKeys("Welcome123");
        registrationPage.repeatPasswordInput.sendKeys("Welcome123");
        registrationPage.termsConditionsCheckbox.click();
        registrationPage.createAccountButton.click();

        Thread.sleep(1000);
        Assert.assertTrue(registrationPage.errorNotification.getText().endsWith("We are unable to create your account. This is an invite-only alpha, please join our waitlist to receive an invitation"));


    }
}
