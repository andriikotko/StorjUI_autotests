package testsSatellite.RegistrationPageTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegistrationPositiveTests {
    public static WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.REGISTERURL);
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @Test
    public void backToLoginPageTest(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

        registrationPage.loginButton.click();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }
    @Ignore
    @Test
    public void validRegistrationTest(){}
}
