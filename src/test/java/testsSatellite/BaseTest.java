package testsSatellite;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
    }

    @Test
    public void BaseTest() throws InterruptedException {

        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);

        HomePage.toggleAccount_DropDown.click();
        HomePage.button_LogOut.click();
        Assert.assertEquals(driver.getCurrentUrl(), pages.HomePage.HOMEURL);

    }

    @AfterMethod
    public void tearDown()
    {driver.quit();}
}