package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountTab_Profile {
    public static WebDriver driver;


    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/h1")
    public WebElement accountProfileHeader;
//    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/a[1]")
//    public WebElement accountProfileProfileTab;
//    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/a[2]")
//    public WebElement accountProfileBillingTab;
//    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/a[3]")
//    public WebElement accountProfilePaymentTab;
    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div/div[1]")
    public WebElement editProfileIcon;
    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/h2")
    public WebElement editProfileHeader;
    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/h3")
    public WebElement editProfileText;
    @FindBy(how= How.CSS,using = "#app > div > div > div.dashboard-container__wrap__column > div.dashboard-container__main-area > div > div > div.profile-container__edit-profile.no-margin > svg")
    public WebElement editProfileButton;
     @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div/h2")
    public WebElement changePasswordHeader;
     @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div/h3")
    public WebElement changePasswordText;
     @FindBy(how= How.CSS,using = "#app > div > div > div.dashboard-container__wrap__column > div.dashboard-container__main-area > div > div > div.profile-container__secondary-container > div.profile-container__secondary-container__change-password > svg")
    public WebElement editPasswordButton;
     @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/h2")
    public WebElement userEmailText;
    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div")
    public WebElement deleteAccountButton;



    //EDIT PROFILE POPUP
    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[1]/h2")
    public WebElement editProfilePopupHeader;
    @FindBy(how=How.XPATH,using="//*[@id=\"Full Name\"]")
    public WebElement fullNameInput;
    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[2]/div/h3[1]")
    public WebElement fullNameInputHeader;

    @FindBy(how=How.XPATH,using="//*[@id=\"Nickname\"]")
    public WebElement nicknameInput;
    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[3]/div/h3[1]")
    public WebElement nicknameInputHeader;

    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[4]/div[2]")
    public WebElement updateAccountButton;
    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[4]/div[1]")
    public WebElement cancelUpdateAccountButton;
    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[2]")
    public WebElement closeUpdateAccountDialogButton;
    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[2]/div/h3")
    public WebElement errorOnNameChange;




    //EDIT CHANGE PASSWORD POPUP
    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[1]/h2")
    public WebElement editPasswordPopupHeader;
    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[2]/input")
    public WebElement oldPasswordInput;
    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[2]/div/h3")
    public WebElement oldPasswordInputHeader;

    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[3]/input")
    public WebElement newPasswordInput;
    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[3]/div/h3")
    public WebElement newPasswordInputHeader;

    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[4]/input")
    public WebElement confirmPasswordInput;
    @FindBy(how=How.XPATH,using="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[4]/div/h3")
    public WebElement confirmPasswordInputHeader;

    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[5]/div[2]")
    public WebElement updatePasswordButton;
    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[5]/div[1]")
    public WebElement cancelUpdatePasswordButton;
    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[2]")
    public WebElement closeUpdatePasswordDialogButton;

    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[3]/div/h3")
    public WebElement newPasswordError;
    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[4]/div/h3")
    public WebElement confirmPasswordError;
    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div/div[1]/div[2]/div/h3")
    public WebElement changePasswordEmptyError;
    @FindBy(how=How.XPATH,using ="//*[@id=\"notificationArea\"]/div/div[1]")
    public WebElement errorOnPasswordChange;

    // DELETE ACCOUNT DIALOG
    @FindBy(how=How.XPATH,using ="//*[@id=\"deleteAccountPopup\"]/div[1]/h2")
    public WebElement deleteAccountDialogHeader;
    @FindBy(how=How.XPATH,using ="//*[@id=\"deleteAccountPopup\"]/div[2]/p")
    public WebElement deleteAccountDialogText;
    @FindBy(how=How.XPATH,using ="//*[@id=\"deleteAccountPopup\"]/div[2]/div[1]/div/h3[1]")
    public WebElement deleteAccountDialogEmailInputHeader;
    @FindBy(how=How.XPATH,using ="//*[@id=\"Enter your password\"]")
    public WebElement deleteAccountDialogInput;
    @FindBy(how=How.XPATH,using ="//*[@id=\"deleteAccountPopup\"]/div[2]/div[2]/div[1]")
    public WebElement deleteAccountDialogCancelButton;
    @FindBy(how=How.XPATH,using ="//*[@id=\"deleteAccountPopup\"]/div[2]/div[2]/div[2]")
    public WebElement deleteAccountDialogDeleteButton;
    @FindBy(how=How.XPATH,using ="//*[@id=\"deleteAccountPopup\"]/div[3]")
    public WebElement deleteAccountDialogCloseButton;







    public AccountTab_Profile(WebDriver driver)

    {
        this.driver = driver;
    }
}
