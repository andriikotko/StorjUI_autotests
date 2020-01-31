package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountTab_Profile {
    public static WebDriver driver;


    @FindBy(how= How.XPATH,using = "//*[@class=\"profile-container__title\"]")
    public WebElement accountProfileHeader;
//    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/a[1]")
//    public WebElement accountProfileProfileTab;
//    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/a[2]")
//    public WebElement accountProfileBillingTab;
//    @FindBy(how= How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/a[3]")
//    public WebElement accountProfilePaymentTab;
    @FindBy(how= How.XPATH,using = "//*[@class=\"profile-container__edit-profile__avatar\"]")
    public WebElement editProfileIcon;
    @FindBy(how= How.XPATH,using = "//*[text() = \"Edit Profile\"]")
    public WebElement editProfileHeader;
    @FindBy(how= How.XPATH,using = "//*[text() = \"This information will be visible to all users\"]")
    public WebElement editProfileText;
    @FindBy(how= How.CSS,using = "#app > div > div > div.dashboard-container__wrap__column > div.dashboard-container__main-area > div > div > div > div.profile-container__edit-profile.no-margin > svg")
    public WebElement editProfileButton;
    @FindBy(how= How.XPATH,using = "//*[@class=\"profile-container__secondary-container__img\"]")
    public WebElement editPasswordIcon;
     @FindBy(how= How.XPATH,using = "//*[text() = \"Change Password\"]")
    public WebElement changePasswordHeader;
     @FindBy(how= How.XPATH,using = "//*[text() = \"6 or more characters\"]")
    public WebElement changePasswordText;
     @FindBy(how= How.CSS,using = "#app > div > div > div.dashboard-container__wrap__column > div.dashboard-container__main-area > div > div > div > div.profile-container__secondary-container > div.profile-container__secondary-container__change-password > svg")
    public WebElement editPasswordButton;
     @FindBy(how= How.XPATH,using = "//*[@class=\"profile-container__secondary-container__email-container__text-container\"]/h2")
    public WebElement userEmailText;
    @FindBy(how= How.XPATH,using = "//*[@class=\"payment-methods-area__title text\"]")
    public WebElement deleteAccountButton;



    //EDIT PROFILE POPUP
    @FindBy(how=How.XPATH,using="//*[@class=\"edit-profile-popup__form-container__main-label-text\"]")
    public WebElement editProfilePopupHeader;
    @FindBy(how=How.XPATH,using="//*[@id=\"Full Name\"]")
    public WebElement fullNameInput;
    @FindBy(how=How.XPATH,using="//*[text() = \"Full Name\"]")
    public WebElement fullNameInputHeader;

    @FindBy(how=How.XPATH,using="//*[@id=\"Nickname\"]")
    public WebElement nicknameInput;
    @FindBy(how=How.XPATH,using="//*[text() = \"Nickname\"]")
    public WebElement nicknameInputHeader;

    @FindBy(how=How.XPATH,using ="//*[text() = \"Update\"]")
    public WebElement updateAccountButton;
    @FindBy(how=How.XPATH,using ="//*[text() = \"Cancel\"]")
    public WebElement cancelUpdateAccountButton;
    @FindBy(how=How.XPATH,using ="//*[@class=\"edit-profile-popup__close-cross-container\"]")
    public WebElement closeUpdateAccountDialogButton;
    @FindBy(how=How.XPATH,using="//*[@class=\"label-container__error\"]")
    public WebElement errorOnNameChange;




    //EDIT CHANGE PASSWORD POPUP
    @FindBy(how=How.XPATH,using="//*[@class=\"change-password-popup__form-container__main-label-text\"]")
    public WebElement editPasswordPopupHeader;
    @FindBy(how=How.XPATH,using="//*[@class=\"headerless-input password\" and @placeholder=\"Enter Old Password\"]")
    public WebElement oldPasswordInput;
    @FindBy(how=How.XPATH,using="//*[text() = \"Old Password\"]")
    public WebElement oldPasswordInputHeader;

    @FindBy(how=How.XPATH,using="//*[@class=\"headerless-input password\" and @placeholder=\"Enter New Password\"]")
    public WebElement newPasswordInput;
    @FindBy(how=How.XPATH,using="//*[text() = \"New Password\"]")
    public WebElement newPasswordInputHeader;

    @FindBy(how=How.XPATH,using="//*[@class=\"headerless-input password\" and @placeholder=\"Confirm Password\"]")
    public WebElement confirmPasswordInput;
    @FindBy(how=How.XPATH,using="//*[text() = \"Confirm Password\"]")
    public WebElement confirmPasswordInputHeader;

    @FindBy(how=How.XPATH,using ="//*[text() = \"Update\"]")
    public WebElement updatePasswordButton;
    @FindBy(how=How.XPATH,using ="//*[text() = \"Cancel\"]")
    public WebElement cancelUpdatePasswordButton;
    @FindBy(how=How.XPATH,using ="//*[@class=\"change-password-popup__close-cross-container\"]")
    public WebElement closeUpdatePasswordDialogButton;

    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/div[3]/div/div")
    public WebElement newPasswordError;
    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/div[4]/div")
    public WebElement confirmPasswordError;
    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div/div/div[3]/div/div[1]/div[2]/div")
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
    @FindBy(how=How.XPATH,using ="//*[@id=\"deleteAccountPopup\"]/div[2]/div[1]/div")
    public WebElement emptyPasswordError;







    public AccountTab_Profile(WebDriver driver)

    {
        this.driver = driver;
    }
}
