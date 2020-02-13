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

public class AccountProfileFunctionalTests {
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
    public void editAccountPositiveTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        accountTabProfile.editProfileButton.click();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("12345");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.nicknameInput.sendKeys("54321");
        accountTabProfile.updateAccountButton.click();

        accountTabProfile.editProfileButton.click();

        Assert.assertEquals(homePage.currentUserFirstSymbol.getText(), "5");
    }

    @Test
    public void editAccountNickEmptyPositiveTest() throws InterruptedException {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        accountTabProfile.editProfileButton.click();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("12345");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.updateAccountButton.click();
        accountTabProfile.editProfileButton.click();

        Assert.assertEquals(homePage.currentUserFirstSymbol.getText(), "1");
    }

    @Test
    public void editAccountCancelTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        accountTabProfile.editProfileButton.click();
        String previous_name = accountTabProfile.fullNameInput.getText();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("NewNAme");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.nicknameInput.sendKeys("NewNick");
        accountTabProfile.cancelUpdateAccountButton.click();

        accountTabProfile.editProfileButton.click();
        String current_name = accountTabProfile.fullNameInput.getText();
        Assert.assertEquals(current_name, previous_name);
    }

    @Test
    public void editAccountCloseTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        accountTabProfile.editProfileButton.click();
        String previous_name = accountTabProfile.fullNameInput.getText();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("NewNAme");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.nicknameInput.sendKeys("NewNick");
        accountTabProfile.closeUpdateAccountDialogButton.click();

        accountTabProfile.editProfileButton.click();
        String current_name = accountTabProfile.fullNameInput.getText();
        Assert.assertEquals(current_name, previous_name);
    }

    @Test
    public void editAccountFullNameEmptyTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        accountTabProfile.editProfileButton.click();
        String previous_name = accountTabProfile.fullNameInput.getText();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.nicknameInput.sendKeys("NewNick");
        accountTabProfile.updateAccountButton.click();

        Assert.assertEquals(accountTabProfile.errorOnNameChange.getText(),"Full name expected");
        accountTabProfile.closeUpdateAccountDialogButton.click();
        accountTabProfile.editProfileButton.click();
        String current_name = accountTabProfile.fullNameInput.getText();
        Assert.assertEquals(current_name, previous_name);
    }

    @Test
    public void EditPasswordNewInvalidTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys(PASSWORD);
        accountTabProfile.newPasswordInput.sendKeys("asd");
        accountTabProfile.confirmPasswordInput.sendKeys("zzzzzzz");
        accountTabProfile.updatePasswordButton.click();

        Assert.assertEquals(accountTabProfile.newPasswordError.getText(),"Invalid password. Use 6 or more characters");
        Assert.assertEquals(accountTabProfile.confirmPasswordError.getText(),"Password not match to new one");

        accountTabProfile.closeUpdatePasswordDialogButton.click();
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormHeader));

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys("asdasd");
        loginPage.btn_Login.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));

        Assert.assertEquals(loginPage.notificationArea.getText(),"your email or password was incorrect, please try again");
        Assert.assertEquals(loginPage.loginFormHeader.getText(),"Login to Storj");

    }

    @Test
    public void EditPasswordOldIncorrectTest() throws InterruptedException {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys("dddfdfd");
        accountTabProfile.newPasswordInput.sendKeys("asdasd");
        accountTabProfile.confirmPasswordInput.sendKeys("asdasd");
        accountTabProfile.updatePasswordButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(accountTabProfile.errorOnPasswordChange));

        Assert.assertEquals(accountTabProfile.errorOnPasswordChange.getText(),"old password is incorrect, please try again");

        Thread.sleep(4000);

        accountTabProfile.closeUpdatePasswordDialogButton.click();
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormHeader));

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys("asdasd");
        loginPage.btn_Login.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));

        Assert.assertEquals(loginPage.notificationArea.getText(),"your email or password was incorrect, please try again");
        Assert.assertEquals(loginPage.loginFormHeader.getText(),"Login to Storj");
    }

    @Test
    public void EditPasswordConfirmDoesntMatchTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys(PASSWORD);
        accountTabProfile.newPasswordInput.sendKeys("qweqwe");
        accountTabProfile.confirmPasswordInput.sendKeys("qweqweq");
        accountTabProfile.updatePasswordButton.click();

        Assert.assertEquals(accountTabProfile.confirmPasswordError.getText(),"Password not match to new one");

        accountTabProfile.closeUpdatePasswordDialogButton.click();
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormHeader));

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys("qweqwe");
        loginPage.btn_Login.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));

        Assert.assertEquals(loginPage.notificationArea.getText(),"your email or password was incorrect, please try again");
        Assert.assertEquals(loginPage.loginFormHeader.getText(),"Login to Storj");

    }

    @Test
    public void EditPasswordEmptyFildsTest() throws InterruptedException {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys("");
        accountTabProfile.newPasswordInput.sendKeys("");
        accountTabProfile.confirmPasswordInput.sendKeys("");
        accountTabProfile.updatePasswordButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(accountTabProfile.changePasswordEmptyError.getText(),"Invalid old password. Must be 6 or more characters");

        Assert.assertEquals(accountTabProfile.newPasswordError.getText(),"Invalid password. Use 6 or more characters");
        Assert.assertEquals(accountTabProfile.confirmPasswordError.getText(),"Password required");

        accountTabProfile.closeUpdatePasswordDialogButton.click();
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormHeader));

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys(PASSWORD);
        loginPage.btn_Login.click();

        wait.until(ExpectedConditions.visibilityOf(homePage.storjLogo));

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/project-overview/details"));

    }
    @Test
    public void EditPasswordCancelTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys(PASSWORD);
        accountTabProfile.newPasswordInput.sendKeys("qweqwe");
        accountTabProfile.confirmPasswordInput.sendKeys("qweqwe");
        accountTabProfile.cancelUpdatePasswordButton.click();


        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormHeader));

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys("qweqwe");
        loginPage.btn_Login.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));

        Assert.assertEquals(loginPage.notificationArea.getText(),"your email or password was incorrect, please try again");
        Assert.assertEquals(loginPage.loginFormHeader.getText(),"Login to Storj");

    }

    @Test
    public void EditPasswordPositiveTest() throws InterruptedException {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys(PASSWORD);
        accountTabProfile.newPasswordInput.sendKeys("qweqwe");
        accountTabProfile.confirmPasswordInput.sendKeys("qweqwe");
        accountTabProfile.updatePasswordButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(accountTabProfile.errorOnPasswordChange));

        Assert.assertEquals(accountTabProfile.errorOnPasswordChange.getText(),"Password successfully changed!");

        Thread.sleep(4000);
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormHeader));

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys("qweqwe");
        loginPage.btn_Login.click();

        Thread.sleep(4000);

       // wait.until(ExpectedConditions.visibilityOf(homePage.currentUserName));

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/project-overview/details"));

        //AFTER TEST
        homePage.profileTab.click();
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys("qweqwe");
        accountTabProfile.newPasswordInput.sendKeys(PASSWORD);
        accountTabProfile.confirmPasswordInput.sendKeys(PASSWORD);
        accountTabProfile.updatePasswordButton.click();
    }
    @Ignore //temporary
    @Test
    public void DeleteAccountEmptyPasswordTest() throws InterruptedException {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.deleteAccountButton.click();
        accountTabProfile.deleteAccountDialogInput.sendKeys("");
        accountTabProfile.deleteAccountDialogDeleteButton.click();


        Assert.assertEquals(accountTabProfile.emptyPasswordError.getText(),"Invalid password. Must be 6 or more characters");

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/account/profile"));

       }

    @Ignore //temporary
    @Test
    public void DeleteAccountWrongPasswordTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.deleteAccountButton.click();
        accountTabProfile.deleteAccountDialogInput.sendKeys("wrongPass");
        accountTabProfile.deleteAccountDialogDeleteButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(accountTabProfile.errorOnPasswordChange));

        Assert.assertEquals(accountTabProfile.errorOnPasswordChange.getText(),"unauthorized error: Old password is incorrect, please try again");

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/account/profile"));
    }
    @Ignore //temporary
    @Test
    public void DeleteAccountCancelTest() throws InterruptedException {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);

        accountTabProfile.deleteAccountButton.click();
        accountTabProfile.deleteAccountDialogInput.sendKeys(PASSWORD);
        accountTabProfile.deleteAccountDialogCancelButton.click();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/account/profile"));
    }
    @Ignore //temporary
    @Test
    public void DeleteAccountCloseTest()  {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);

        accountTabProfile.deleteAccountButton.click();
        accountTabProfile.deleteAccountDialogInput.sendKeys(PASSWORD);
        accountTabProfile.deleteAccountDialogCloseButton.click();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/account/profile"));
    }
    @Ignore //temporary
    @Test
    public void DeleteAccountPositiveTest() throws InterruptedException {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormHeader));

        loginPage.userNameField.sendKeys("test15@g.com");
        loginPage.passwordField.sendKeys(PASSWORD);
        loginPage.btn_Login.click();
        wait.until(ExpectedConditions.visibilityOf(homePage.projectHeader));
        homePage.profileTab.click();
        accountTabProfile.deleteAccountButton.click();
        accountTabProfile.deleteAccountDialogInput.sendKeys(PASSWORD);
        accountTabProfile.deleteAccountDialogDeleteButton.click();


        wait.until(ExpectedConditions.visibilityOf(accountTabProfile.errorOnPasswordChange));

        Assert.assertEquals(accountTabProfile.errorOnPasswordChange.getText(),"Account was successfully deleted");

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));

    }













    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
