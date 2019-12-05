package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {
    final WebDriver driver;


    @FindBy(how = How.XPATH, using = "//*[@class=\"headerless-input\"]")
    public WebElement userNameField;
    @FindBy(how = How.XPATH, using = "//*[@class=\"headerless-input password\"]")
    public WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//*[@class=\"login-area__submit-area__login-button\"]")
    public WebElement btn_Login;
    @FindBy(how = How.CSS, using = "#app > div > div.login-container__wrapper > div.login-area-wrapper > div > div.input-wrap.login-area__password-input > svg")
    public WebElement eye_Symbol;
    @FindBy(how = How.XPATH,using = "//*[@class=\"login-container__register-button\"]")
    public WebElement btnCreateAccount;
    @FindBy(how = How.CSS,using = "#app > div > div.login-container__wrapper > div.login-container__header > svg")
    public WebElement storjLogo;
    @FindBy(how =How.XPATH,using ="//*[@class=\"login-area__navigation-area__nav-link__link\"]")
    public WebElement linkForgotPassword;
    @FindBy(how =How.XPATH,using = "//*[@class=\"login-area__info-area__terms\"]")
    public WebElement linkToTermsAndConditions;
    @FindBy(how =How.XPATH,using = "//*[@class=\"login-area__info-area__help\"]")
    public WebElement linkToSupport;
    @FindBy(how =How.XPATH,using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    //@FindBy(how =How.XPATH,using = "//*[@id=\"notificationArea\"]/div")
    public WebElement notificationArea;
    @FindBy(how = How.XPATH, using = "//*[@class=\"login-area__title-container__title\"]")
    public WebElement loginFormHeader;
    @FindBy(how = How.XPATH, using = "//*[@class=\"login-area__info-area__signature\"]")
    public WebElement footerLogoText;
    @FindBy(how = How.XPATH, using = "(//*[@class=\"label-container__error\"])[1]")
    public WebElement emailValidationError;
    @FindBy(how = How.XPATH, using = "(//*[@class=\"label-container__error\"])[2]")
    public WebElement passwordValidationError;


    //*[@id="notificationArea"]/div/div[1]/p

// This is a constructor, as every page need a base driver to find web elements

    public LoginPage (WebDriver driver){

        this.driver = driver;

    }

}