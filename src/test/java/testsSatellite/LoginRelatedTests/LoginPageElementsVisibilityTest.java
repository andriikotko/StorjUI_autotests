package testsSatellite.LoginRelatedTests;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;


import java.util.concurrent.TimeUnit;
public class LoginPageElementsVisibilityTest {
    public static WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

    }


    @Test
    public void elementsVisabilityTest () throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        Thread.sleep(3000);
        Assert.assertTrue(LoginPage.eye_Symbol.isDisplayed());
        Assert.assertTrue(LoginPage.btnCreateAccount.isDisplayed());
        Assert.assertTrue(LoginPage.storjLogo.isDisplayed());
        Assert.assertTrue(LoginPage.linkForgotPassword.isDisplayed());
        Assert.assertTrue(LoginPage.linkToTermsAndConditions.isDisplayed());
        Assert.assertTrue(LoginPage.linkToSupport.isDisplayed());
        Assert.assertTrue(LoginPage.userNameField.isDisplayed());
        Assert.assertTrue(LoginPage.passwordField.isDisplayed());
        Assert.assertTrue(LoginPage.loginFormHeader.isDisplayed());
        Assert.assertTrue(LoginPage.footerLogoText.isDisplayed());

    }

}
