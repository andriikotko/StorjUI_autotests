package tests.HomePageTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class HomePageElementsTextsTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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