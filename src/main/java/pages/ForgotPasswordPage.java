package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (how = How.XPATH, using = "//*[@class=\"forgot-password-container__logo\"]")
    public WebElement storjLogo;
    @FindBy (how = How.XPATH, using = "//*[@class=\"forgot-password-container__login-button\"]")
    public WebElement backToLoginButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"forgot-password-area__title-container__title\"]")
    public WebElement forgotPasswordHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"forgot-password-area__info-text\"]")
    public WebElement forgotPasswordNotification;
    @FindBy (how = How.XPATH, using = "//*[@class=\"headerless-input\"]")
    public WebElement inputEmailField;
    @FindBy (how = How.XPATH, using = "//*[@class=\"forgot-password-area__submit-container__send-button\"]")
    public WebElement resetPasswordButton;
    @FindBy (how=How.XPATH,using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement notificationForgotPassword;
    @FindBy (how=How.XPATH,using = "//*[@class=\"label-container__error\"]")
    public WebElement erroronForgotPassword;

}
