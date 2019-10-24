package testsSatellite.AccountRelatedTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AccountTab_Profile;
import pages.HomePage;
import pages.LoginPage;
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

    @BeforeTest
    public void SetUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);

    }
    @Test
    public void AccountTabTest() throws InterruptedException {
        Thread.sleep(2000);
        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        AccountTab_Profile AccountTab_Profile =PageFactory.initElements(driver, AccountTab_Profile.class);
        PaymentsTab PaymmentsTab =PageFactory.initElements(driver, PaymentsTab.class);
        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4000);
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