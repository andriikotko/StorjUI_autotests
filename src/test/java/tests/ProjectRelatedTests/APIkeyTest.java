package tests.ProjectRelatedTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
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
    @BeforeTest
    public void CreateNewAPIKey() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
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