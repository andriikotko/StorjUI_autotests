package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    final WebDriver driver;

    ////INPUTS

    @FindBy(how = How.XPATH, using = "//*[@class = \"headerless-input\"][1]")
    public WebElement fullNameInput;
//    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/input")
//    public WebElement nicknameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/input")
    public  WebElement emailInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/div[1]/input")
    public WebElement passwordInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div[1]/input")
    public WebElement repeatPasswordInput;
    @FindBy(how = How.XPATH, using = "//*[@class = \"checkmark\"]")
    public WebElement termsConditionsCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@class = \"register-area__submit-container__create-button\"]")
    public WebElement createAccountButton;

    /////OTHER ELEMENTS

    @FindBy(how = How.XPATH, using = "//*[@class = \"register-container__logo\"]")
    public WebElement logoStorj;
    @FindBy(how = How.XPATH, using = "//*[@class = \"register-container__register-button\"]")
    public WebElement loginButton;
    @FindBy (how = How.XPATH,using = "//*[@class = \"register-area__title-container__title\"]")
    public WebElement signUpHeader;
    @FindBy (how = How.XPATH,using = "//*[text() = \"Full Name\"]")
    public WebElement fullNameHeader;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/div/h3")
    public WebElement nicknameHeader;
    @FindBy (how = How.XPATH,using = "//*[text() = \"Email\"]")
    public WebElement emailHeader;
    @FindBy (how = How.XPATH,using = "//*[text() = \"Password\"]")
    public WebElement passwordHeader;
    @FindBy (how = How.XPATH,using = "//*[text() = \"Confirm Password\"]")
    public WebElement confirmPasswordHeader;
    @FindBy (how = How.XPATH,using = "//*[@class = \"password-strength-container\"]")
    public WebElement hintPasswordStrength;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/div[2]/div/div")
    public WebElement passwordInfoButton;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div[2]")
    public WebElement hintBoxConfirmPassword;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div[2]/div/div")
    public WebElement confirmPasswordInfoButton;
    @FindBy (how = How.XPATH,using = "//*[@class = \"register-area__submit-container__terms-area__terms-confirmation\"]")
    public WebElement termsConditionsHeader;
    @FindBy (how = How.XPATH,using = "//*[@class = \"register-area__submit-container__terms-area__link\"]")
    public WebElement termsConditionsLink;




    //ERRORS
    @FindBy(how =How.XPATH,using = ("//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div/h3"))
    public WebElement fullNameValidationError;
    @FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/div/h3")
    public  WebElement emailValidationError;
    @FindBy(how = How.XPATH,using ="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/div[1]/div/h3")
    public WebElement passwordValidationError;
    @FindBy(how = How.XPATH,using ="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div[1]/div/h3")
    public WebElement confirmPasswordValidationError;
    @FindBy(how = How.XPATH,using ="//*[@class = \"checkmark error\"]")
    public WebElement checkBoxValidationError;

    //Error Notifications
    @FindBy(how =How.XPATH, using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement errorNotification;


    // CHECK YOUR EMAIL POPUP
    @FindBy(how = How.CSS,using ="#successfulRegistrationPopup > div > div.register-success-popup__info-panel-container > svg")
    public WebElement checkEmailLogo;
    @FindBy(how = How.XPATH,using ="//*[@class = \"register-success-popup__form-container__title\"]")
    public WebElement checkEmailHeader;
    @FindBy(how = How.XPATH,using ="//*[@class = \"register-success-popup__form-container__text\"]")
    public WebElement checkEmailText;
    @FindBy(how = How.XPATH,using ="//*[@class = \"register-success-popup__form-container__text\"]/b")
    public WebElement checkEmailTimer;
    @FindBy(how = How.XPATH,using ="//*[@class = \"register-success-popup__form-container__button-container\"]/div")
    public WebElement checkEmailResendButton;
    @FindBy(how = How.XPATH,using ="//*[@class = \"register-success-popup__close-cross-container\"]")
    public WebElement checkEmailClose;


















    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
    }

}
