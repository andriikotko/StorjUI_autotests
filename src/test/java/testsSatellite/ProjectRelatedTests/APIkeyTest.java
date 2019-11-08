package testsSatellite.ProjectRelatedTests;

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
import pages.Flows.NewProjectFlow;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.APIKeysTab;

import java.util.concurrent.TimeUnit;

public class APIkeyTest {
    static WebDriver driver;
    @AfterMethod()
    public void tearDown()
    {driver.quit();}
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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);

        Thread.sleep(4000);

        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, pages.LoginPage.class);
        APIKeysTab APIkeysTab = PageFactory.initElements(driver, APIKeysTab.class);
        NewProjectFlow newProjectFlow = PageFactory.initElements(driver, NewProjectFlow.class);
        // Once both classes Initialised, use their Web Element Objects
        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();

        Thread.sleep(5000);
    }
        @Test(invocationCount = 1)
        public void TestforTest(){
        int random = (int )(Math.random() * 10000000 + 1);
        String randomNumber= Integer.toString(random);
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, pages.LoginPage.class);
        APIKeysTab APIkeysTab = PageFactory.initElements(driver, APIKeysTab.class);
        HomePage.API_Keys_Tab.click();
        try {
            APIkeysTab.createNewAPIkeyButton.click();
        } catch (Exception e) {}
        try {APIkeysTab.newAPIkeyCreateButtonEmpty.click();}
        catch (Exception e){}

        APIkeysTab.newAPIkeyNameInput.sendKeys(randomNumber);
        APIkeysTab.confirmAPIKeyCreation.click();
//      APIkeysTab.CrossButtonOnPopUp.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(HomePage.Error_Notification));
        Assert.assertTrue(HomePage.Error_Notification.getText().endsWith("Successfully created new api key"));

    }
}