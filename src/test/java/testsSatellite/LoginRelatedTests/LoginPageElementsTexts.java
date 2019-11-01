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

import java.util.concurrent.TimeUnit;

public class LoginPageElementsTexts {
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
