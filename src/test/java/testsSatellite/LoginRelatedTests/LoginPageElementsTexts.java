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

public class LoginPageElementsTexts {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

    }

    @Test
    public void elemntsTextsTest(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        Assert.assertEquals(loginPage.loginFormHeader.getText(), "Login to Storj");
        Assert.assertEquals(loginPage.footerLogoText.getText(), "Storj Labs Inc 2019.");
        Assert.assertEquals(loginPage.btnCreateAccount.getText(),"Create Account");
        Assert.assertEquals(loginPage.btn_Login.getText(), "Log In");
        Assert.assertEquals(loginPage.linkForgotPassword.getText(), "Forgot password?");
        Assert.assertEquals(loginPage.linkToTermsAndConditions.getText(),"Terms & Conditions");
        Assert.assertEquals(loginPage.linkToSupport.getText(), "Support");
        Assert.assertTrue(loginPage.userNameField.getAttribute("placeholder").endsWith("Email"));
        Assert.assertTrue(loginPage.passwordField.getAttribute("placeholder").endsWith("Password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
