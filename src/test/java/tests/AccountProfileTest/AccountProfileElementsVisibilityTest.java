package tests.AccountProfileTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountTab_Profile;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class AccountProfileElementsVisibilityTest {

    public WebDriver driver;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
        Assert.assertTrue(accountTabProfile.deleteAccountButton.isDisplayed());

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
