package testsSatellite;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SystemParams;

import java.util.concurrent.TimeUnit;

public class NewAccountCreationTest {
    public static WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

    }
    @AfterMethod
    public void tearDown()
    {driver.quit();}
    @Test
    public void NewAccountCreationTest () throws InterruptedException {

        driver.get(HomePage.REGISTERURL);

        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.fullNameInput.sendKeys("testFullName");
//        registrationPage.nicknameInput.sendKeys("testShortName");
        registrationPage.emailInput.sendKeys("testNewEmail@gmail.com");
        registrationPage.passwordInput.sendKeys("Welcome123");
        registrationPage.repeatPasswordInput.sendKeys("Welcome123");
        registrationPage.termsConditionsCheckbox.click();
        registrationPage.createAccountButton.click();

        Thread.sleep(1000);
        Assert.assertTrue(registrationPage.errorNotification.getText().endsWith("we are unable to create your account. This is an invite-only alpha, please join our waitlist to receive an invitation"));


    }
}
