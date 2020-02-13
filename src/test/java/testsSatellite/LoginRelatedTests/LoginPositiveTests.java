package testsSatellite.LoginRelatedTests;

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
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import testsSatellite.BaseTest;

import java.util.concurrent.TimeUnit;

public class LoginPositiveTests {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

    }

    @Test
    public void gotoForgotPasword(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.linkForgotPassword.click();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/forgot-password"));
    }

    @Test
    public void gotoRegistrationPage(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.btnCreateAccount.click();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/register"));
    }

    @Test
    public void linkToTermsConditions(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        Assert.assertTrue(loginPage.linkToTermsAndConditions.getAttribute("href").endsWith("https://tardigrade.io/terms-of-use/"));
    }

    @Test
    public void linkToSupport(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        Assert.assertTrue(loginPage.linkToSupport.getAttribute("href").endsWith("mailto:support@storj.io"));
    }

    @Test
    public void loginPositiveTest() throws InterruptedException {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        loginPage.btn_Login.click();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//        HomePage page = new HomePage(driver);
//        page.loginToAccountWithValidCreds();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(homePage.storjLogo));
        System.out.println(driver.getCurrentUrl());

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/project-overview/details"));
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}