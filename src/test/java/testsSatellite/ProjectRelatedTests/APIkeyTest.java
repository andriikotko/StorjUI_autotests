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
import pages.SystemParams;
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
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
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