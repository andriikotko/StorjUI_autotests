package testsSatellite.AccountProfileTest;

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
import pages.AccountTab_Profile;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;

import java.util.concurrent.TimeUnit;

import static pages.HomePage.PASSWORD;

public class AccountProfileTextsTest {
    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
        homePage.profileTab.click();

    }

    @Test
    public void AccountProfileElementsTextsTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);

        Assert.assertEquals(accountTabProfile.accountProfileHeader.getText(),"Account Settings");
//        Assert.assertEquals(accountTabProfile.accountProfileProfileTab.getText(),"Profile");
//        Assert.assertTrue(accountTabProfile.accountProfileProfileTab.getAttribute("href").endsWith("/account/profile"));
//        Assert.assertEquals(accountTabProfile.accountProfileBillingTab.getText(),"Billing");
//        Assert.assertTrue(accountTabProfile.accountProfileBillingTab.getAttribute("href").endsWith("/account/billing"));
//        Assert.assertEquals(accountTabProfile.accountProfilePaymentTab.getText(),"Payment Methods");
//        Assert.assertTrue(accountTabProfile.accountProfilePaymentTab.getAttribute("href").endsWith("/account/payment-methods"));
        Assert.assertEquals(accountTabProfile.editProfileHeader.getText(),"Edit Profile");
        Assert.assertEquals(accountTabProfile.editProfileText.getText(),"This information will be visible to all users");
        Assert.assertEquals(accountTabProfile.changePasswordHeader.getText(),"Change Password");
        Assert.assertEquals(accountTabProfile.changePasswordText.getText(),"6 or more characters");
        //Assert.assertTrue(accountTabProfile.userEmailText.isDisplayed());
       // Assert.assertEquals(accountTabProfile.deleteAccountButton.getText(),"Delete Account");  -  TEMPORARY

    }

    @Test
    public void AccountProfileEditProfileElementsTextsTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.editProfileButton.click();

        Assert.assertEquals(accountTabProfile.editProfilePopupHeader.getText(),"Edit Profile");
        Assert.assertEquals(accountTabProfile.fullNameInputHeader.getText(), "Full Name");
        Assert.assertEquals(accountTabProfile.nicknameInputHeader.getText(),"Nickname");
        Assert.assertEquals(accountTabProfile.updateAccountButton.getText(),"Update");
        Assert.assertEquals(accountTabProfile.cancelUpdateAccountButton.getText(),"Cancel");

    }


    @Test
    public void AccountProfileEditPasswordElementsTextsTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.editPasswordButton.click();

        Assert.assertEquals(accountTabProfile.editPasswordPopupHeader.getText(),"Change Password");
        Assert.assertEquals(accountTabProfile.oldPasswordInputHeader.getText(),"Old Password");
        Assert.assertTrue(accountTabProfile.oldPasswordInput.getAttribute("placeholder").endsWith("Enter Old Password"));
        Assert.assertTrue(accountTabProfile.newPasswordInput.getAttribute("placeholder").endsWith("Enter New Password"));
        Assert.assertEquals(accountTabProfile.newPasswordInputHeader.getText(),"New Password");
        Assert.assertTrue(accountTabProfile.confirmPasswordInput.getAttribute("placeholder").endsWith("Confirm Password"));
        Assert.assertEquals(accountTabProfile.confirmPasswordInputHeader.getText(),"Confirm Password");
        Assert.assertEquals(accountTabProfile.updatePasswordButton.getText(),"Update");
        Assert.assertEquals(accountTabProfile.cancelUpdatePasswordButton.getText(),  "Cancel");

    }

    @Test
    public void EditProfileErrorTextTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.editProfileButton.click();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys(" ");
        accountTabProfile.updateAccountButton.click();


        Assert.assertEquals(accountTabProfile.errorOnNameChange.getText(),"Full name expected");

    }

    @Test
    public void EditPasswordErrorTextsTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys(PASSWORD);
        accountTabProfile.newPasswordInput.sendKeys("asd");
        accountTabProfile.confirmPasswordInput.sendKeys("zzzzzzz");
        accountTabProfile.updatePasswordButton.click();

        Assert.assertEquals(accountTabProfile.newPasswordError.getText(),"Invalid password. Use 6 or more characters");
        Assert.assertEquals(accountTabProfile.confirmPasswordError.getText(),"Password not match to new one");

    }

    @Test
    public void EditPasswordNotificationErrorTextsTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys("dddfdfd");
        accountTabProfile.newPasswordInput.sendKeys("asdasd");
        accountTabProfile.confirmPasswordInput.sendKeys("asdasd");
        accountTabProfile.updatePasswordButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(accountTabProfile.errorOnPasswordChange));

        Assert.assertEquals(accountTabProfile.errorOnPasswordChange.getText(),"old password is incorrect, please try again");

    }
    @Ignore //  TEMPORARY
    @Test
    public void DeleteAccountDialogTextsTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.deleteAccountButton.click();

        Assert.assertEquals(accountTabProfile.deleteAccountDialogHeader.getText(), "Delete account");
        Assert.assertEquals(accountTabProfile.deleteAccountDialogText.getText(),"Are you sure you want to delete your account? If you do so, all your information, projects and API Keys will be deleted forever (drop from the satellite).");
        Assert.assertEquals(accountTabProfile.deleteAccountDialogEmailInputHeader.getText(),"Enter your password");
        Assert.assertTrue(accountTabProfile.deleteAccountDialogInput.getAttribute("placeholder").endsWith("Your Password"));
        Assert.assertEquals(accountTabProfile.deleteAccountDialogCancelButton.getText(),"Cancel");
        Assert.assertEquals(accountTabProfile.deleteAccountDialogDeleteButton.getText(),"Delete");
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
