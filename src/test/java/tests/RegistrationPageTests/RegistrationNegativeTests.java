package tests.RegistrationPageTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegistrationNegativeTests {
    public static WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.REGISTERURL);
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @Test
    public void registrationFieldsValidationErrorsMessagesTextsTest() throws InterruptedException {

        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.createAccountButton.click();
        Thread.sleep(1000);
        Assert.assertTrue(registrationPage.checkBoxValidationError.isDisplayed());
        Assert.assertTrue(registrationPage.emailValidationError.getText().endsWith("Invalid Email"));
        Assert.assertTrue(registrationPage.fullNameValidationError.getText().endsWith("Invalid Name"));
        Assert.assertTrue(registrationPage.passwordValidationError.getText().endsWith("Invalid Password"));

    }

    @Test
    public void registrationErrorNotificationTextTest() throws InterruptedException {

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

    @Test
    public void registrationConfirmationPassErrorTextTest() {

        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.fullNameInput.sendKeys("testFullName");
        registrationPage.nicknameInput.sendKeys("testShortName");
        registrationPage.emailInput.sendKeys("testNewEmail@gmail.com");
        registrationPage.passwordInput.sendKeys("Welcome123");
        registrationPage.repeatPasswordInput.sendKeys("Welcome12");
        registrationPage.termsConditionsCheckbox.click();
        registrationPage.createAccountButton.click();

        Assert.assertTrue(registrationPage.confirmPasswordValidationError.getText().endsWith("Password doesn't match"));
    }
}
