package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PasswordRecoveryFlow {

    public WebDriver driver;

    public PasswordRecoveryFlow(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH,using ="//*[@class=\"login-area__navigation-area__nav-link__link\"]")
    public WebElement linkForgotPassword;
    @FindBy (how = How.XPATH, using = "//*[@class=\"headerless-input\"]")
    public WebElement inputEmailField;
    @FindBy (how = How.XPATH, using = "//*[@class=\"forgot-password-area__submit-container__send-button\"]")
    public WebElement resetPasswordButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")
    public WebElement gmailOpen;
    @FindBy (how = How.XPATH, using = "//*[@class=\"zF\" and text() = \"Storj\"]")
    public WebElement storjLetter;
    @FindBy (how = How.XPATH, using = "//*[contains (@href, \"http://127.0.0.1:10002/password-recovery/\")]")
    public WebElement emailResetPasswordLink;

    // SET NEW PASSWORD PAGE
    @FindBy (how = How.XPATH, using = "//*[@class=\"reset-password-container__logo\"]")
    public WebElement resetPasswordLogo;
    @FindBy (how = How.XPATH, using = "//*[@class=\"reset-password-container__login-button\"]")
    public WebElement resetPasswordBackToLoginButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"reset-password-area__title-container\"]")
    public WebElement resetPasswordHeader;
    @FindBy (how = How.XPATH, using = "//*[@placeholder=\"New Password\"]")
    public WebElement resetPasswordNewPassword;
    @FindBy (how = How.XPATH, using = "//*[@placeholder=\"Confirm Password\"]")
    public WebElement resetPasswordConfirmPassword;
    @FindBy (how = How.XPATH, using = "//*[@class=\"reset-password-area__submit-container__send-button\"]")
    public WebElement resetPasswordSetNewPassButton;

    //Successfully changed password page
    @FindBy (how = How.XPATH, using = "//*[@class=\"container__img\"]")
    public WebElement passwordSuccessChangedLogo;
    @FindBy (how = How.XPATH, using = "//*[@class=\"container__title\"]")
    public WebElement passwordSuccessChangedHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"container__info\"]")
    public WebElement passwordSuccessChangedText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"container__button\"]")
    public WebElement passwordSuccessChangedGoToLoginButton;
}
