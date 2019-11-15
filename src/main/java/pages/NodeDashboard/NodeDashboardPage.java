package pages.NodeDashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NodeDashboardPage {

    WebDriver driver;

    public NodeDashboardPage(WebDriver driver) {
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


    @FindBy (how = How.CSS, using = "#app > div > div.header > div > div.header__content-holder__logo-area > svg")
    public WebElement dashboardStorjLogo;
    @FindBy (how = How.CSS, using = "#app > div > div.header > div > div.header__content-holder__logo-area > div > svg")
    public WebElement refreshButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[1]/div/div[2]")
    public WebElement nodeIDContainer;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[1]/div/div[2]/p")
    public WebElement nodeID;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[1]/div/div[2]/b")
    public WebElement nodeIDText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/h1")
    public WebElement nodeHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/p")
    public WebElement currentPeriod;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[1]/p/b")
    public WebElement currentMonth;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/p[1]")
    public WebElement nodeStatusText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/p[2]")
    public WebElement nodeStatus;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[1]")
    public WebElement statusInfoTick;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[1]/div[2]")
    public WebElement nodeStatusInfoPopUp;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/p[2]")
    public WebElement lastPingedText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/p[3]")
    public WebElement uptimeText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/p[1]")
    public WebElement lastPingedData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/p[2]")
    public WebElement uptimeData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/p[3]/b")
    public WebElement nodeVersionText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/p[4]")
    public WebElement nodeVersion;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[2]")
    public WebElement nodeVersionInfoTick;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]")
    public WebElement nodeVersionPopUp;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/p[1]")
    public WebElement versionPopUpText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[1]/div[2]/div[2]/div[2]/div/p[2]")
    public WebElement versionPopUpVersion;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]")
    public WebElement choosingSatelliteContainer;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/p/b")
    public WebElement chosenSatelliteText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"satelliteDropdown\"]/div")
    public WebElement satelliteDropdown;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div/div/div[2]/p")
    public WebElement currentSatellite;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div/div/div[1]/div/p")
    public WebElement allSatellites;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/p[1]")
    public WebElement utilizationRemainingHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/p[1]")
    public WebElement bandwidthHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[1]/p[2]/b")
    public WebElement bandwidthData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"bandwidth-chart\"]")
    public WebElement bandwidthGraph;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[2]/p[1]")
    public WebElement diskSpaceHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[2]/p[2]/b")
    public WebElement diskSpaceData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"disk-space-chart\"]")
    public WebElement diskSpaceGraph;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/p")
    public WebElement remainingHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[1]/p[1]")
    public WebElement bandwidthRemainingText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[1]/p[2]")
    public WebElement bandwidthRemainData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[1]/div/div/div")
    public WebElement bandwidthRemainBar;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[1]/div/div/div[2]")
    public WebElement bandwidthRemainBarHint;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[2]/p[1]")
    public WebElement diskRemainText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[2]/p[2]")
    public WebElement diskRemainData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[2]/div/div")
    public WebElement diskRemainBar;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[2]/div/div/div[2]")
    public WebElement diskRemainBarHint;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/p[2]")
    public WebElement payoutHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[4]/div/p[1]")
    public WebElement storjWalletAddressText;
    @FindBy (how = How.CSS, using = "#app > div > div.content > div.info-area > div.payout-container > svg")
    public WebElement walletLogo;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[4]/div/p[2]/b")
    public WebElement walletData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[4]/a/div")
    public WebElement payoutButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[4]/a")
    public WebElement payoutLink;
    @FindBy (how = How.CSS, using = "#app > div > div.footer > div > svg")
    public WebElement footerLogo;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[3]/div/a[1]")
    public WebElement linkToCommunity;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[3]/div/a[2]")
    public WebElement linkToSupport;



    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/p")
    public WebElement auditUptimeHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[1]/div/p")
    public WebElement uptimeChecksText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[1]/div/div/div")
    public WebElement uptimeChecksHintTick;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[1]/div/div/div[2]/div/p[1]")
    public WebElement uptimeCheckHintText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[1]/p/b")
    public WebElement uptimeCheckData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[2]/div/p")
    public WebElement auditChecksText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[2]/div/div/div")
    public WebElement auditChecksHintTick;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[2]/div/div/div[2]/div/p[1]")
    public WebElement auditCheckHintText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div[3]/div/div[2]/p/b")
    public WebElement auditCheckData;


}
