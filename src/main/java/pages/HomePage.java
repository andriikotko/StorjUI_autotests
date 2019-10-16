package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public final WebDriver driver;
    public static String HOMEURL = "http://localhost:10002/login";
    public static String REGISTERURL= "http://localhost:10002/register";
    public static String ACCOUNT="test1@g.com";
    public static String PASSWORD="123qwe";
    public static String CHROMEDRIVERPATH = "./src/main/resources/chromedriver";
    public static Integer Width = 1280;
    public static Integer Height = 1000;

     //BuTTONS and DropDowns
    @FindBy(how = How.XPATH, using ="//*[@id=\"accountDropdownButton\"]")
    public WebElement toggleAccount_DropDown;
    @FindBy(how = How.XPATH, using ="//*[@id=\"accountDropdownButton\"]/div/h1")
    public WebElement currentUserName;
    @FindBy(how= How.XPATH,using ="//*[@id=\"accountDropdown\"]/div/div[1]")
    public WebElement account_Settings;
    @FindBy(how= How.XPATH,using ="//*[@id=\"accountDropdown\"]/div/div[1]/h2")
    public WebElement account_Settings_text;
    @FindBy(how = How.XPATH, using = "//*[@id=\"accountDropdown\"]/div/div[2]/h2")
    public WebElement button_LogOut;
    @FindBy(how = How.XPATH,using ="//*[@id=\"newProjectButton\"]")
    public WebElement btn_New_Project;
//    @FindBy(how = How.ID,using ="projectDropdownButton")
    @FindBy(how = How.XPATH,using ="//*[@id=\"app\"]/div/div/div[2]/div[1]/div[1]")
    public WebElement project_dropDown;
    @FindBy(how=How.XPATH,using= "//*[@class=\"project-selection-choice-container\"]")
    public WebElement testsProjectList;
    @FindBy(how=How.XPATH,using="//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement Error_Notification;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/div[1]")
    public WebElement storjLogo;




    ////MAIN TABS
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div[1]/a[1]")
    public WebElement overview_tab;
    @FindBy(how =How.XPATH, using ="//*[@id=\"app\"]/div/div/div[1]/div/a[2]")
    public WebElement team_tab;
    @FindBy(how = How.XPATH, using =" //*[@id=\"app\"]/div/div/div[1]/div[1]/a[3]")
    public WebElement API_Keys_Tab;
    @FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div/div[1]/div[1]/a[4]")
    public WebElement buckets;
    @FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div/div[1]/div[1]/a[5]")
    public WebElement docs_Tab;
    @FindBy (how =How.XPATH, using ="//*[@id=\"app\"]/div/div/div[1]/div[1]/a[6]")
    public WebElement support_Tab;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/div[5]/a[1]")
    public WebElement profileTab;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/div[5]/a[2]")
    public WebElement billingTab;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/a[9]/div/h1")
    public WebElement  paymentMethodsTab;

    // TABS HEADERS
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/p")
    public WebElement projectHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/div[3]")
    public WebElement resoursesContainer;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/div[3]/p")
    public WebElement resourcesHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/div[3]/p[2]")
    public WebElement resoursesHide_Show;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/div[4]")
    public WebElement accountContainer;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/div[4]/p")
    public WebElement accountHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[1]/div/div[4]/p[2]")
    public WebElement accountHide_Show;


    public void loginToAccountWithValidCreds () throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        loginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        loginPage.btn_Login.click();
        Thread.sleep(4500);
    }

    public void gotoRegisterPage (){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.btnCreateAccount.click();
    }

    public void gotoRestorePasswordPage(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.linkForgotPassword.click();
    }


// This is a constructor, as every page need a base driver to find web elements
    public HomePage(WebDriver driver)

    {
        this.driver = driver;
    }

}
