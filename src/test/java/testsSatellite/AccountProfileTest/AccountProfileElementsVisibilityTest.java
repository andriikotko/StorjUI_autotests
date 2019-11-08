package testsSatellite.AccountProfileTest;

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

import java.util.concurrent.TimeUnit;

public class AccountProfileElementsVisibilityTest {

    public WebDriver driver;


    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")){
            chosingOS = "";
        }
        if (OS.substring(0,4).equals("Windo")){
            chosingOS = ".exe";
        }
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH+chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH+chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH+chosingOS);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
       // driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.profileTab.click();

    }

    @Test
    public void AccountProfileElementsVisibility() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);

        Assert.assertTrue(accountTabProfile.accountProfileHeader.isDisplayed());
       // Assert.assertTrue(accountTabProfile.accountProfileProfileTab.isDisplayed());
      //  Assert.assertTrue(accountTabProfile.accountProfileBillingTab.isDisplayed());
       // Assert.assertTrue(accountTabProfile.accountProfilePaymentTab.isDisplayed());
        Assert.assertTrue(accountTabProfile.editProfileIcon.isDisplayed());
        Assert.assertTrue(accountTabProfile.editProfileHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.editProfileText.isDisplayed());
        Assert.assertTrue(accountTabProfile.editProfileButton.isDisplayed());
        Assert.assertTrue(accountTabProfile.changePasswordHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.changePasswordText.isDisplayed());
        Assert.assertTrue(accountTabProfile.editPasswordButton.isDisplayed());
        Assert.assertTrue(accountTabProfile.userEmailText.isDisplayed());
        //Assert.assertTrue(accountTabProfile.deleteAccountButton.isDisplayed());  - TEMPORARY!!!!!

    }

    @Test
    public void AccountProfileEditProfileElementsVisibility() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.editProfileButton.click();

        Assert.assertTrue(accountTabProfile.editProfilePopupHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.fullNameInput.isDisplayed());
        Assert.assertTrue(accountTabProfile.fullNameInputHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.nicknameInput.isDisplayed());
        Assert.assertTrue(accountTabProfile.nicknameInputHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.updateAccountButton.isDisplayed());
        Assert.assertTrue(accountTabProfile.cancelUpdateAccountButton.isDisplayed());
        Assert.assertTrue(accountTabProfile.closeUpdateAccountDialogButton.isDisplayed());

    }


    @Test
    public void AccountProfileEditPasswordElementsVisibility() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.editPasswordButton.click();

        Assert.assertTrue(accountTabProfile.editPasswordPopupHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.oldPasswordInput.isDisplayed());
        Assert.assertTrue(accountTabProfile.oldPasswordInputHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.newPasswordInput.isDisplayed());
        Assert.assertTrue(accountTabProfile.newPasswordInputHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.confirmPasswordInput.isDisplayed());
        Assert.assertTrue(accountTabProfile.confirmPasswordInputHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.updatePasswordButton.isDisplayed());
        Assert.assertTrue(accountTabProfile.cancelUpdatePasswordButton.isDisplayed());
        Assert.assertTrue(accountTabProfile.closeUpdatePasswordDialogButton.isDisplayed());

    }
    @Ignore // TEMPORARY
    @Test
    public void DeleteAccountDialogElementsVisibility() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.deleteAccountButton.click();

        Assert.assertTrue(accountTabProfile.deleteAccountDialogHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.deleteAccountDialogText.isDisplayed());
        Assert.assertTrue(accountTabProfile.deleteAccountDialogEmailInputHeader.isDisplayed());
        Assert.assertTrue(accountTabProfile.deleteAccountDialogInput.isDisplayed());
        Assert.assertTrue(accountTabProfile.deleteAccountDialogCancelButton.isDisplayed());
        Assert.assertTrue(accountTabProfile.deleteAccountDialogDeleteButton.isDisplayed());
        Assert.assertTrue(accountTabProfile.deleteAccountDialogCloseButton.isDisplayed());
        }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
