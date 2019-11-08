package testsSatellite.HomePageTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class HomePageElementsTextsTest {
    public WebDriver driver;
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
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);
    }


    @Test
    public void homePageElementsTextsTest (){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Assert.assertEquals(homePage.btn_New_Project.getText(), "+ New Project");

        Assert.assertEquals(homePage.projectHeader.getText(), "PROJECT");
        Assert.assertEquals(homePage.accountHeader.getText(), "ACCOUNT");
        Assert.assertEquals(homePage.resourcesHeader.getText(), "RESOURCES");


        Assert.assertEquals(homePage.overview_tab.getText(), "Overview");
        Assert.assertEquals(homePage.team_tab.getText(), "Team");
        Assert.assertEquals(homePage.API_Keys_Tab.getText(), "API Keys");
        Assert.assertEquals(homePage.buckets.getText(), "Buckets");
        Assert.assertEquals(homePage.docs_Tab.getText(), "Docs");
        Assert.assertEquals(homePage.support_Tab.getText(), "Support");
        Assert.assertEquals(homePage.profileTab.getText(), "Profile");
        Assert.assertEquals(homePage.billingTab.getText(), "Billing");
   //     Assert.assertEquals(homePage.paymentMethodsTab.getText(), "Payment Methods");  - moved to Biiling tab
    }

    @Test
    public void hideResoursesButtonTextTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Actions action = new Actions(driver);
        action.moveToElement(homePage.resoursesContainer).click().perform();

        Assert.assertEquals(homePage.resoursesHide_Show.getText(), "Hide");
    }
    @Test
    public void hideAccountButtonTextTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Actions action = new Actions(driver);
        action.moveToElement(homePage.accountContainer).click().perform();

        Assert.assertEquals(homePage.accountHide_Show.getText(), "Hide");
    }
    @Test
    public void accountSettingsButtonTextTest (){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Actions action = new Actions(driver);
        action.moveToElement(homePage.toggleAccount_DropDown).click().perform();

        Assert.assertEquals(homePage.account_Settings_text.getText(), "Account Settings");
    }
    @Test
    public void accountLogOutButtonTextTest () {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Actions action = new Actions(driver);
        action.moveToElement(homePage.toggleAccount_DropDown).click().perform();


        Assert.assertEquals(homePage.button_LogOut.getText(), "Log Out");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
