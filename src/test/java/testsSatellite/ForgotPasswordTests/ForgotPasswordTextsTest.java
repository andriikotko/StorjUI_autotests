package testsSatellite.ForgotPasswordTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ForgotPasswordPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordTextsTest {
    public WebDriver driver;

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
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
       // driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.linkForgotPassword.click();

    }

    @Test
    public void forgotPasswordTextsTest(){

        ForgotPasswordPage forgotPasswordPage = PageFactory.initElements(driver, ForgotPasswordPage.class);

        Assert.assertTrue(forgotPasswordPage.storjLogo.getAttribute("class").endsWith("forgot-password-container__logo"));
        Assert.assertEquals(forgotPasswordPage.backToLoginButton.getText(),"Back to Login");
        Assert.assertEquals(forgotPasswordPage.forgotPasswordHeader.getText(), "Forgot Password");
        Assert.assertEquals(forgotPasswordPage.forgotPasswordNotification.getText(),"Enter your email address below and we'll get you back on track.");
        Assert.assertTrue(forgotPasswordPage.inputEmailField.getAttribute("placeholder").endsWith("Enter Your Email"));
        Assert.assertEquals(forgotPasswordPage.resetPasswordButton.getText(),"Reset Password");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
