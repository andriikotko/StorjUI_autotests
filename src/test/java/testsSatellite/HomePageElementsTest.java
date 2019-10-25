package testsSatellite;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class HomePageElementsTest {
    WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}
    @Test
    public void HomePageElementsTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.HOMEURL);

        Thread.sleep(3000);
        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        // Once both classes Initialised, use their Web Element Objects
        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);
        Assert.assertTrue(HomePage.team_tab.isDisplayed());
        Assert.assertTrue(HomePage.team_tab.getAttribute("class").endsWith("navigation-area__item-container"));
        Assert.assertTrue(HomePage.API_Keys_Tab.getAttribute("class").endsWith("navigation-area__item-container"));
        Assert.assertTrue(HomePage.buckets.getAttribute("class").endsWith("navigation-area__item-container"));
        Assert.assertTrue(HomePage.docs_Tab.getAttribute("href").endsWith("https://github.com/storj/docs/blob/master/Vanguard-Release-Setup-Instructions.md"));
        Assert.assertTrue(HomePage.support_Tab.isEnabled());
        HomePage.toggleAccount_DropDown.click();
        Assert.assertTrue(HomePage.account_Settings.isDisplayed());
    }

}
