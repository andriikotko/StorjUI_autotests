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
import testsSatellite.BaseTest;

import java.util.concurrent.TimeUnit;

public class LoginPositiveTests extends BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
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