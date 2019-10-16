package tests.AccountProfileTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountTab_Profile;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

import static pages.HomePage.PASSWORD;

public class AccountProfileFunctionalTests {
    public WebDriver driver;


    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        //driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.profileTab.click();

    }

    @Test
    public void editAccountPositiveTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.editProfileButton.click();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("12345");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.nicknameInput.sendKeys("54321");
        accountTabProfile.updateAccountButton.click();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertEquals(homePage.currentUserName.getText(), "54321");
    }

    @Test
    public void editAccountNickEmptyPositiveTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.editProfileButton.click();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("12345");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.updateAccountButton.click();

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertEquals(homePage.currentUserName.getText(), "12345");
    }

    @Test
    public void editAccountCancelTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        String previous_name = homePage.currentUserName.getText();
        accountTabProfile.editProfileButton.click();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("NewNAme");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.nicknameInput.sendKeys("NewNick");
        accountTabProfile.cancelUpdateAccountButton.click();

        Assert.assertEquals(homePage.currentUserName.getText(), previous_name);
    }

    @Test
    public void editAccountCloseTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        String previous_name = homePage.currentUserName.getText();
        accountTabProfile.editProfileButton.click();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("NewNAme");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.nicknameInput.sendKeys("NewNick");
        accountTabProfile.closeUpdateAccountDialogButton.click();

        Assert.assertEquals(homePage.currentUserName.getText(), previous_name);
    }

    @Test
    public void editAccountFullNameEmptyTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        String previous_name = homePage.currentUserName.getText();
        accountTabProfile.editProfileButton.click();
        accountTabProfile.fullNameInput.clear();
        accountTabProfile.fullNameInput.sendKeys("");

        accountTabProfile.nicknameInput.clear();
        accountTabProfile.nicknameInput.sendKeys("NewNick");
        accountTabProfile.updateAccountButton.click();

        Assert.assertEquals(accountTabProfile.errorOnNameChange.getText(),"Full name expected");
        accountTabProfile.closeUpdateAccountDialogButton.click();
        Assert.assertEquals(homePage.currentUserName.getText(), previous_name);
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

        Assert.assertEquals(loginPage.notificationArea.getText(),"unauthorized error: Your email or password was incorrect, please try again");
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

        Assert.assertEquals(accountTabProfile.errorOnPasswordChange.getText(),"Old password is incorrect, please try again");

        Thread.sleep(4000);

        accountTabProfile.closeUpdatePasswordDialogButton.click();
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormHeader));

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys("asdasd");
        loginPage.btn_Login.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));

        Assert.assertEquals(loginPage.notificationArea.getText(),"unauthorized error: Your email or password was incorrect, please try again");
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

        Assert.assertEquals(loginPage.notificationArea.getText(),"unauthorized error: Your email or password was incorrect, please try again");
        Assert.assertEquals(loginPage.loginFormHeader.getText(),"Login to Storj");

    }

    @Test
    public void EditPasswordEmptyFildsTest() {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys("");
        accountTabProfile.newPasswordInput.sendKeys("");
        accountTabProfile.confirmPasswordInput.sendKeys("");
        accountTabProfile.updatePasswordButton.click();

        Assert.assertEquals(accountTabProfile.newPasswordError.getText(),"Invalid password. Use 6 or more characters");
        Assert.assertEquals(accountTabProfile.confirmPasswordError.getText(),"Password required");
        Assert.assertEquals(accountTabProfile.changePasswordEmptyError.getText(),"Password required");

        accountTabProfile.closeUpdatePasswordDialogButton.click();
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFormHeader));

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys(PASSWORD);
        loginPage.btn_Login.click();

        wait.until(ExpectedConditions.visibilityOf(homePage.currentUserName));

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

        Assert.assertEquals(loginPage.notificationArea.getText(),"unauthorized error: Your email or password was incorrect, please try again");
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

        wait.until(ExpectedConditions.visibilityOf(homePage.currentUserName));

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/project-overview/details"));

        //AFTER TEST
        homePage.profileTab.click();
        accountTabProfile.editPasswordButton.click();
        accountTabProfile.oldPasswordInput.sendKeys("qweqwe");
        accountTabProfile.newPasswordInput.sendKeys(PASSWORD);
        accountTabProfile.confirmPasswordInput.sendKeys(PASSWORD);
        accountTabProfile.updatePasswordButton.click();
    }

    @Test
    public void DeleteAccountEmptyPasswordTest() throws InterruptedException {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);
        accountTabProfile.deleteAccountButton.click();
        accountTabProfile.deleteAccountDialogInput.sendKeys("");
        accountTabProfile.deleteAccountDialogDeleteButton.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(accountTabProfile.errorOnPasswordChange));

        Assert.assertEquals(accountTabProfile.errorOnPasswordChange.getText(),"unauthorized error: Old password is incorrect, please try again");

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/account/profile"));

       }
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

    @Test
    public void DeleteAccountCancelTest() throws InterruptedException {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);

        accountTabProfile.deleteAccountButton.click();
        accountTabProfile.deleteAccountDialogInput.sendKeys(PASSWORD);
        accountTabProfile.deleteAccountDialogCancelButton.click();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/account/profile"));
    }

    @Test
    public void DeleteAccountCloseTest()  {
        AccountTab_Profile accountTabProfile = PageFactory.initElements(driver, AccountTab_Profile.class);

        accountTabProfile.deleteAccountButton.click();
        accountTabProfile.deleteAccountDialogInput.sendKeys(PASSWORD);
        accountTabProfile.deleteAccountDialogCloseButton.click();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/account/profile"));
    }

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