package testsSatellite.ForgotPasswordTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.PasswordRecoveryFlow;

import java.util.concurrent.TimeUnit;

public class PasswordRecoveryFlowTests {
    WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")){
            chosingOS = "";
        }
        if (OS.substring(0,4).equals("Windo")){
            chosingOS = ".exe";
        }
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH+chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH+chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH+chosingOS);
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
    @Ignore
    @Test
    public void passwordRecoveryFlowTest () throws InterruptedException {
//        PasswordRecoveryFlow passwordRecoveryFlow = PageFactory.initElements(driver,PasswordRecoveryFlow.class);
//
//        passwordRecoveryFlow.inputEmailField.sendKeys("andrii@storj.io");
//        passwordRecoveryFlow.resetPasswordButton.click();
//
//        Thread.sleep(5000);
//
//        driver.navigate().to("https://www.google.com/");
//
//        Thread.sleep(15000);
//
//        passwordRecoveryFlow.gmailOpen.click();
//        passwordRecoveryFlow.storjLetter.click();
//        passwordRecoveryFlow.emailResetPasswordLink.click();

        driver.get("https://www.google.com/");
        Thread.sleep(1300000);

    }




    @AfterMethod
    public void tearDown()
    {driver.quit();}
}
