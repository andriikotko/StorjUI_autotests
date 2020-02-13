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

public class AccountTabTest {
    public WebDriver driver;
    int random = (int )(Math.random() * 10000000 + 1);
    String randomNumber= Integer.toString(random);

    @AfterMethod
    public void tearDown() {
        driver.quit();
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
    public void AccountTabTest() throws InterruptedException {

        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        AccountTab_Profile AccountTab_Profile =PageFactory.initElements(driver, AccountTab_Profile.class);
        PaymentsTab PaymmentsTab =PageFactory.initElements(driver, PaymentsTab.class);

        HomePage.toggleAccount_DropDown.click();
        HomePage.account_Settings.click();
        AccountTab_Profile.editProfileButton.click();
        AccountTab_Profile.fullNameInput.clear();
        AccountTab_Profile.fullNameInput.sendKeys(randomNumber);
        AccountTab_Profile.nicknameInput.clear();
        AccountTab_Profile.nicknameInput.sendKeys(randomNumber);
        AccountTab_Profile.updateAccountButton.click();
        Thread.sleep(2000);
        AccountTab_Profile.editProfileButton.click();

        Assert.assertEquals(AccountTab_Profile.fullNameInput.getAttribute("value"), randomNumber);
        Assert.assertEquals(AccountTab_Profile.nicknameInput.getAttribute("value"), randomNumber);


    }
}