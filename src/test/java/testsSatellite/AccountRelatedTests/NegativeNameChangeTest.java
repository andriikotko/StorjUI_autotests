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
import pages.SystemParams;
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
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);

    }

    @Test
    public void NegativeNameChangeTest() throws InterruptedException {
        Thread.sleep(2000);
        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        AccountTab_Profile AccountTab_Profile =PageFactory.initElements(driver, AccountTab_Profile.class);
        PaymentsTab PaymmentsTab =PageFactory.initElements(driver, PaymentsTab.class);

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
