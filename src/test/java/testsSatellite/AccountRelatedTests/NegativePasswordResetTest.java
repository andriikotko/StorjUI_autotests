package testsSatellite.AccountRelatedTests;

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
import pages.Flows.ResetPasswordFlow;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class NegativePasswordResetTest {
    public static WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}


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
        } driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension( HomePage.Width,HomePage.Height));
        driver.get(HomePage.HOMEURL);

        Thread.sleep(3000);}
    @Test
    public void ResetPasswordTest() throws InterruptedException {


        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage= PageFactory.initElements(driver, pages.LoginPage.class);
        ResetPasswordFlow ResetPasswordFlow = PageFactory.initElements(driver, pages.Flows.ResetPasswordFlow.class);
        LoginPage.linkForgotPassword.click();
        ResetPasswordFlow.Reset_Password_input.sendKeys(pages.HomePage.ACCOUNT);
        ResetPasswordFlow.Submit_Reset_Password.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(ResetPasswordFlow.Notification_Reset_email_Success));
        //wait.until(ExpectedConditions.visibilityOf(HomePage.Error_Notification));
        Assert.assertEquals(ResetPasswordFlow.Notification_Reset_email_Success.getText(),"Please look for instructions at your email");


    }
}

