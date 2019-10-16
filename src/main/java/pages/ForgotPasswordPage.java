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

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/img")
    public WebElement storjLogo;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div")
    public WebElement backToLoginButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/h1")
    public WebElement forgotPasswordHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/p")
    public WebElement forgotPasswordNotification;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/input")
    public WebElement inputEmailField;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/div")
    public WebElement resetPasswordButton;
    @FindBy (how=How.XPATH,using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement notificationForgotPassword;

}
