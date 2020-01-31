package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.Flows.NewProjectFlow;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomePage {

    public final WebDriver driver;

    public static String HOMEURL;

    static {
        try {
            HOMEURL = "http://localhost:"+ (satellitePort()) +"/login";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String REGISTERURL;

    static {
        try {
            REGISTERURL = "http://localhost:"+ (satellitePort()) +"/register";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String ACCOUNT="test1@g.com";
    public static String PASSWORD="123qwe";
    public static String CHROMEDRIVERPATH = "./src/main/resources/chromedriver";
    public static String CHROMEDRIVERPATHWIN = "./src/main/resources/chromedriver.exe";
    public static String CHROMEDRIVERPATHMAC = "./src/main/resources/chromedrivermac";
    public static String GECKODRIVERPATH = "./src/main/resources/geckodriver";
    public static String OPERADRIVERPATH = "./src/main/resources/operadriver";
    public static Integer Width = 1280;
    public static Integer Height = 1000;
    public static final String DefaultBrowser = "Chrome";




     //BuTTONS and DropDowns
    @FindBy(how = How.XPATH, using ="//*[@id=\"accountDropdownButton\"]")
    public WebElement toggleAccount_DropDown;
    @FindBy(how = How.XPATH, using ="//*[@id=\"accountDropdownButton\"]/div/h1")
    public WebElement currentUserName;
    @FindBy(how = How.XPATH, using ="(//*[@id = \"projectDropdownButton\"])[2]")
    public WebElement currentProjectName;
    @FindBy(how = How.XPATH, using ="//*[@id=\"accountDropdownButton\"]/div/div[1]/h1")
    public WebElement currentUserFirstSymbol;
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
    @FindBy (how = How.XPATH, using = "//*[@class=\"navigation-area__logo__img\"]")
    public WebElement storjLogo;




    ////MAIN TABS
    @FindBy(how = How.XPATH, using = "//*[@aria-label=\"Overview\"]")
    public WebElement overview_tab;
    @FindBy(how =How.XPATH, using ="//*[@aria-label=\"Team\"]")
    public WebElement team_tab;
    @FindBy(how = How.XPATH, using ="//*[@aria-label=\"API Keys\"]")
    public WebElement API_Keys_Tab;
    @FindBy(how = How.XPATH, using ="//*[@aria-label=\"Buckets\"]")
    public WebElement buckets;
    @FindBy(how = How.XPATH, using ="//*[@id=\"app\"]/div/div/div[1]/div/a[6]")
    public WebElement docs_Tab;
    @FindBy (how =How.XPATH, using ="//*[@class=\"navigation-area__item-container support-item\"]")
    public WebElement support_Tab;
    @FindBy (how = How.XPATH, using = "//*[@href=\"/account/profile\"]")
    public WebElement profileTab;
    @FindBy (how = How.XPATH, using = "//*[@href=\"/account/billing\"]")
    public WebElement billingTab;
    @FindBy (how = How.XPATH, using = "//*[@href=\"/account/referral\"]")
    public WebElement  referralTab;

    // TABS HEADERS
    @FindBy (how = How.XPATH, using = "//*[@class=\"navigation-area__project-title\"]")
    public WebElement projectHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"navigation-area__resources-title custom\"]")
    public WebElement resoursesContainer;
    @FindBy (how = How.XPATH, using = "//*[@class=\"navigation-area__resources-title__title\"]")
    public WebElement resourcesHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"navigation-area__resources-title__button\"]")
    public WebElement resoursesHide_Show;
    @FindBy (how = How.XPATH, using = "//*[@class=\"navigation-area__account-title custom\"]")
    public WebElement accountContainer;
    @FindBy (how = How.XPATH, using = "//*[@class=\"navigation-area__account-title__title\"]")
    public WebElement accountHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"navigation-area__account-title__button\"]")
    public WebElement accountHide_Show;

    //BANNER ADD CARD
    @FindBy (how = How.XPATH, using = "//*[@class=\"banner link\"]")
    public WebElement bannerAddCard;
    @FindBy (how = How.XPATH, using = "//*[@class=\"banner\"]")
    public WebElement bannerOnBilling;
    @FindBy (how = How.XPATH, using = "//*[@class=\"banner__text\"]")
    public WebElement bannerAddCardHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"banner__additional-text\"]")
    public WebElement bannerAddCardText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"banner__link__svg banner__arrow\"]")
    public WebElement bannerLinkToBilling;
    @FindBy (how = How.CSS, using = "#app > div > div > div.dashboard-container__wrap__column > div.dashboard-container__main-area > div.dashboard-container__main-area__banner-area > div > div > svg:nth-child(1)")
    public WebElement bannerAddCardIcon;




    public void loginToAccountWithValidCreds (String login, String password) throws InterruptedException {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.userNameField.sendKeys(login);
        loginPage.passwordField.sendKeys(password);
        loginPage.btn_Login.click();
        Thread.sleep(4500);
    }

    public void createUserWithProjectLimit_1 (){
        Process p;
        try {
            String[] cmd = { "sh", "/home/andrii/Downloads/scrips/storj_setup_projectLimit_1.sh"};
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader=new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void createNewProject(){
        btn_New_Project.click();
        NewProjectFlow newProjectFlow = PageFactory.initElements(driver, NewProjectFlow.class);
        newProjectFlow.project_Name_input.sendKeys("TestProject");
        newProjectFlow.project_Description_input.sendKeys("TestDescription");
        newProjectFlow.create_Project_Button.click();
    }

    public void gotoRegisterPage (){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.btnCreateAccount.click();
    }

    public void gotoRestorePasswordPage(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.linkForgotPassword.click();
    }

    public static String satellitePort() throws IOException {
        String OS = System.getProperty("os.name");
        String path = "";
        if (OS.equals("Linux")){
            path = "/home/andrii/.local/share/storj/local-network/satellite/0/config.yaml";
        }
        else if (OS.substring(0,5).equals("Windo")){
            path = "/home/andrii/.local/share/storj/local-network/satellite/0/config.yaml";
        }
        else if (OS.substring(0,3).equals("Mac")){
            path = "/Users/andriikotko/Library/Application Support/Storj/Local-Network/satellite/0/config.yaml";
        }

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String satellitePort;

        while ((satellitePort = bufferedReader.readLine())!= null){
            if (satellitePort.startsWith("console.address:")){
                satellitePort=satellitePort.substring(27,32);
                break;
            }
        } return satellitePort;
    }




// This is a constructor, as every page need a base driver to find web elements
    public HomePage(WebDriver driver) throws IOException {
        this.driver = driver;
    }

}
