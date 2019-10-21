package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {
    final WebDriver driver;

    ////INPUTS

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/input")
    public WebElement fullNameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/input")
    public WebElement nicknameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/input")
    public  WebElement emailInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div/input")
    public WebElement passwordInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[6]/div/input")
    public WebElement repeatPasswordInput;
    @FindBy(how = How.CSS, using = "#app > div > div.register-container__wrapper > div.register-area-wrapper > div > div.register-area__submit-container > div.register-area__submit-container__terms-area > label > span")
    public WebElement termsConditionsCheckbox;
    @FindBy(how = How.XPATH, using = "//*[@id=\"createAccountButton\"]")
    public WebElement createAccountButton;


    /////OTHER ELEMENTS

    @FindBy(how = How.CSS, using = "#app > div > div.register-container__wrapper > div.register-container__header > svg")
    public WebElement logoStorj;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div")
    public WebElement loginButton;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[1]/h1")
    public WebElement signUpHeader;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div/h3")
    public WebElement fullNameHeader;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/div/h3")
    public WebElement nicknameHeader;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/div/h3")
    public WebElement emailHeader;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div[1]/div/h3")
    public WebElement passwordHeader;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[6]/div[1]/div/h3")
    public WebElement confirmPasswordHeader;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div[2]")
    public WebElement hintBoxPassword;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div[2]/div")
    public WebElement passwordInfoButton;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[6]/div[2]")
    public WebElement hintBoxConfirmPassword;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[6]/div[2]/div")
    public WebElement confirmPasswordInfoButton;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[7]/div[1]/h2")
    public WebElement termsConditionsHeader;
    @FindBy (how = How.XPATH,using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[7]/div[1]/h2/a")
    public WebElement termsConditionsLink;




    //ERRORS
    @FindBy(how =How.XPATH,using = ("//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/div"))
    public WebElement fullNameValidationError;
    @FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/div/h3")
    public  WebElement emailValidationError;
    @FindBy(how = How.XPATH,using ="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div/div/h3")
    public WebElement passwordValidationError;
    @FindBy(how = How.XPATH,using ="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[6]/div[1]/div/h3")
    public WebElement confirmPasswordValidationError;
    @FindBy(how = How.XPATH,using ="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[4]/div/h3")
    public WebElement checkBoxValidationError;

    //Error Notifications
    @FindBy(how =How.XPATH, using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement errorNotification;















    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
    }

}
