package testsSatellite.LoginRelatedTests;

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
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;

import java.util.concurrent.TimeUnit;

public class NegativeLoginTest {
    public static WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

    }
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @Test(priority = 1)
    public void NegativeLoginTest() {
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.userNameField.sendKeys("badEmail@bad.email");
        loginPage.passwordField.sendKeys("badPassword123");
        loginPage.btn_Login.click();
        Assert.assertTrue(loginPage.notificationArea.isEnabled());
//        Thread.sleep(2000);
//        Assert.assertTrue(loginPage.notification_area.isDisplayed());
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));
        Assert.assertTrue(loginPage.notificationArea.getText().endsWith("your email or password was incorrect, please try again"));
       // Assert.assertEquals(loginPage.notification_area.getText(),"Your email or password was incorrect, please try again");
    }

    @Test
    public void loginValidationEmptyFelds(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.userNameField.sendKeys("");
        loginPage.passwordField.sendKeys("");
        loginPage.btn_Login.click();

        Assert.assertEquals(loginPage.emailValidationError.getText(), "Invalid Email");
        Assert.assertEquals(loginPage.passwordValidationError.getText(), "Invalid Password");
    }

    @Test
    public void loginValidationShortFelds(){
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.userNameField.sendKeys("12");
        loginPage.passwordField.sendKeys("22");
        loginPage.btn_Login.click();

        Assert.assertEquals(loginPage.emailValidationError.getText(), "Invalid Email");
        Assert.assertEquals(loginPage.passwordValidationError.getText(), "Invalid Password");
    }

}
