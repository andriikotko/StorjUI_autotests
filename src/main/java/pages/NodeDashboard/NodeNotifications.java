package pages.NodeDashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NodeNotifications {

    WebDriver driver;

    public NodeNotifications(WebDriver driver) {
        this.driver = driver;
    }

    public static String DASHBOARDURL = "http://localhost:13002";
    public static String CHROMEDRIVERPATH = "./src/main/resources/chromedriver";
    public static String CHROMEDRIVERPATHWIN = "./src/main/resources/chromedriver.exe";
    public static String CHROMEDRIVERPATHMAC = "./src/main/resources/chromedrivermac";
    public static String GECKODRIVERPATH = "./src/main/resources/geckodriver";
    public static String OPERADRIVERPATH = "./src/main/resources/operadriver";
    public static String EDGEDRIVERPATH = "./src/main/resources/msedgedriver";
    public static Integer Width = 1280;
    public static Integer Height = 1000;




    @FindBy(how = How.XPATH, using = "//*[@class = \"notifications-container__header__text\"]")
    public WebElement notificationsTitle;
    @FindBy(how = How.XPATH, using = "//*[@class = \"notifications-container__header__back-link router-link-active\"]")
    public WebElement notificationsBackButton;
    @FindBy(how = How.XPATH, using = "//*[@class = \"notifications-container__empty-state__image\"]")
    public WebElement notificationsImage;
    @FindBy(how = How.XPATH, using = "//*[@class = \"notifications-container__header__button__label\"]")
    public WebElement notificationsMarkAllButton;
    @FindBy(how = How.XPATH, using = "//*[@class = \"notifications-container__empty-state__label\"]")
    public WebElement notificationsNoYet;
}
