package testsSatellite.RegistrationPageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegistrationPage;
import pages.SystemParams;

public class RegistrationPageElementsVisibilityTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        driver.get(HomePage.REGISTERURL);
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(registrationPage.logoStorj));
    }

    @Test
    public void registrationElementsVisibilityTest(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

        Assert.assertTrue(registrationPage.fullNameInput.isDisplayed());
 //       Assert.assertTrue(registrationPage.nicknameInput.isDisplayed());
        Assert.assertTrue(registrationPage.emailInput.isDisplayed());
        Assert.assertTrue(registrationPage.passwordInput.isDisplayed());
        Assert.assertTrue(registrationPage.repeatPasswordInput.isDisplayed());
        Assert.assertTrue(registrationPage.termsConditionsCheckbox.isDisplayed());
        Assert.assertTrue(registrationPage.createAccountButton.isDisplayed());
        Assert.assertTrue(registrationPage.logoStorj.isDisplayed());
        Assert.assertTrue(registrationPage.loginButton.isDisplayed());
        Assert.assertTrue(registrationPage.signUpHeader.isDisplayed());
        Assert.assertTrue(registrationPage.fullNameHeader.isDisplayed());
      //  Assert.assertTrue(registrationPage.nicknameHeader.isDisplayed());
        Assert.assertTrue(registrationPage.emailHeader.isDisplayed());
        Assert.assertTrue(registrationPage.passwordHeader.isDisplayed());
        Assert.assertTrue(registrationPage.confirmPasswordHeader.isDisplayed());
      //  Assert.assertTrue(registrationPage.hintBoxPassword.isDisplayed());
        //Assert.assertTrue(registrationPage.passwordInfoButton.isDisplayed());
      //  Assert.assertTrue(registrationPage.hintBoxConfirmPassword.isDisplayed());
       // Assert.assertTrue(registrationPage.confirmPasswordInfoButton.isDisplayed());
        Assert.assertTrue(registrationPage.termsConditionsHeader.isDisplayed());
        Assert.assertTrue(registrationPage.termsConditionsLink.isDisplayed());
    }




    @AfterMethod
    public void tearDown()
    {driver.quit();}


}
