package testsSatellite.AccountRelatedTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AccountTab_Profile;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.PaymentsTab;

import java.util.concurrent.TimeUnit;

public class NegativeNameChangeTest {
    public static WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();
    }
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
        driver.get(HomePage.HOMEURL);
    }

    @Test
    public void NegativeNameChangeTest() throws InterruptedException {
        Thread.sleep(2000);
        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        AccountTab_Profile AccountTab_Profile =PageFactory.initElements(driver, AccountTab_Profile.class);
        PaymentsTab PaymmentsTab =PageFactory.initElements(driver, PaymentsTab.class);
        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4000);
        HomePage.toggleAccount_DropDown.click();
        HomePage.account_Settings.click();
        AccountTab_Profile.editProfileButton.click();
        AccountTab_Profile.fullNameInput.clear();
        AccountTab_Profile.fullNameInput.sendKeys("");
        AccountTab_Profile.nicknameInput.clear();
        AccountTab_Profile.nicknameInput.sendKeys("");
        AccountTab_Profile.updateAccountButton.click();
        Assert.assertTrue(AccountTab_Profile.errorOnNameChange.getText().equals("Full name expected"));



    }
}
