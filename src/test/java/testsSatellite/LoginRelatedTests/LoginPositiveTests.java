package testsSatellite.LoginRelatedTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import testsSatellite.BaseTest;

import java.util.concurrent.TimeUnit;

public class LoginPositiveTests extends BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.HOMEURL);

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