package testsSatellite.RegistrationPageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationPageTextsTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.get(HomePage.REGISTERURL);
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(registrationPage.logoStorj));
    }

    @Test
    public void registrationElementsVisibilityTest(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

        Assert.assertTrue(registrationPage.fullNameInput.getAttribute("placeholder").endsWith("Enter Full Name"));
        Assert.assertTrue(registrationPage.nicknameInput.getAttribute("placeholder").endsWith("Enter Nickname"));
        Assert.assertTrue(registrationPage.emailInput.getAttribute("placeholder").endsWith("Enter Email"));
        Assert.assertTrue(registrationPage.passwordInput.getAttribute("placeholder").endsWith("Enter Password"));
        Assert.assertTrue(registrationPage.repeatPasswordInput.getAttribute("placeholder").endsWith("Confirm Password"));
        Assert.assertEquals(registrationPage.createAccountButton.getText(),"Create Account");
        Assert.assertEquals(registrationPage.loginButton.getText(),"Login");
        Assert.assertEquals(registrationPage.signUpHeader.getText(),"Sign Up to Storj");
        Assert.assertEquals(registrationPage.fullNameHeader.getText(), "Full Name");
        Assert.assertEquals(registrationPage.nicknameHeader.getText(),"Nickname");
        Assert.assertEquals(registrationPage.emailHeader.getText(),"Email");
        Assert.assertEquals(registrationPage.passwordHeader.getText(),"Password");
        Assert.assertEquals(registrationPage.confirmPasswordHeader.getText(), "Confirm Password");
//        Assert.assertTrue(registrationPage.hintBoxPassword.isDisplayed());
//        Assert.assertTrue(registrationPage.passwordInfoButton.isDisplayed());
//        Assert.assertTrue(registrationPage.hintBoxConfirmPassword.isDisplayed());  - in special test
//        Assert.assertTrue(registrationPage.confirmPasswordInfoButton.isDisplayed());
        Assert.assertEquals(registrationPage.termsConditionsHeader.getText(),"I agree to the Terms & Conditions");
        Assert.assertTrue(registrationPage.termsConditionsLink.getAttribute("href").endsWith("https://tardigrade.io/terms-of-use/"));
    }

    @Test
    public void registrationPasswordHintTextTest(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        Actions actions = new Actions(driver);
        actions.moveToElement(registrationPage.hintBoxPassword).click().perform();

        Assert.assertEquals(registrationPage.passwordInfoButton.getText(), "Use 6 or more characters with a mix of letters, numbers & symbols");
    }
    @Test
    public void registrationConfirmPasswordHintTextTest(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        Actions actions = new Actions(driver);
        actions.moveToElement(registrationPage.hintBoxConfirmPassword).click().perform();

        Assert.assertEquals(registrationPage.confirmPasswordInfoButton.getText(), "Use 6 or more characters with a mix of letters, numbers & symbols");
    }




    @AfterMethod
    public void tearDown()
    {driver.quit();}


}