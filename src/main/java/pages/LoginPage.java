package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class LoginPage {
    final WebDriver driver;


    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/input")
    public WebElement userNameField;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/input")
    public WebElement passwordField;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/div")
    public WebElement btn_Login;
    @FindBy(how = How.CSS, using = "#app > div > div.login-container__wrapper > div.login-area-wrapper > div > div.input-wrap.login-area__password-input > svg")
    public WebElement eye_Symbol;
    @FindBy(how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[1]/div")
    public WebElement btnCreateAccount;
    @FindBy(how = How.CSS,using = "#app > div > div.login-container__wrapper > div.login-container__header > svg")
    public WebElement storjLogo;
    @FindBy(how =How.XPATH,using ="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/a/h3/strong")
    public WebElement linkForgotPassword;
    @FindBy(how =How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/a[1]")
    public WebElement linkToTermsAndConditions;
    @FindBy(how =How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/a[2]")
    public WebElement linkToSupport;
    @FindBy(how =How.XPATH,using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    //@FindBy(how =How.XPATH,using = "//*[@id=\"notificationArea\"]/div")
    public WebElement notificationArea;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/h1")
    public WebElement loginFormHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/p")
    public WebElement footerLogoText;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div/h3")
    public WebElement emailValidationError;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/div/h3")
    public WebElement passwordValidationError;


    //*[@id="notificationArea"]/div/div[1]/p

// This is a constructor, as every page need a base driver to find web elements

    public LoginPage (WebDriver driver){

        this.driver = driver;

    }

}