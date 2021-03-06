package pages.NodeDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


    @FindBy (how = How.XPATH, using = "//*[@class = \"storj-logo header__content-holder__logo\"]")
    public WebElement dashboardStorjLogo;
    @FindBy (how = How.XPATH, using = "//*[@alt=\"refresh image\"]")
    public WebElement refreshButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"header__content-holder__right-area__node-id-container\"]")
    public WebElement nodeIDContainer;
    @FindBy (how = How.XPATH, using = "//*[@class=\"header__content-holder__right-area__node-id-container__id\"]")
    public WebElement nodeID;
    @FindBy (how = How.XPATH, using = "//*[@class=\"header__content-holder__right-area__node-id-container__title\"]")
    public WebElement nodeIDText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"header__content-holder__right-area__bell-area\"]")
    public WebElement notificationIcon;

    @FindBy (how = How.XPATH, using = "//*[@class=\"title-area__title\"]")
    public WebElement nodeHeader;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item__title\"])[5]")
    public WebElement currentPeriod;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item__content\"])[4]")
    public WebElement currentMonth;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item__title\"])[1]")
    public WebElement nodeStatusText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"title-area__info-container__info-item__content online-status\"]")
    public WebElement nodeStatus;
    @FindBy (how = How.XPATH, using = "//*[@alt=\"online status image\"]")
    public WebElement statusInfoTick;
    @FindBy (how = How.XPATH, using = "//*[@class=\"info__message-box customPosition\"]")
    public WebElement nodeStatusInfoPopUp;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item__title\"])[3]")
    public WebElement lastPingedText;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item__title\"])[2]")
    public WebElement uptimeText;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item__content\"])[2]")
    public WebElement lastPingedData;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item__content\"])[1]")
    public WebElement uptimeData;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item__title\"])[4]")
    public WebElement nodeVersionText;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item__content\"])[3]")
    public WebElement nodeVersion;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"title-area__info-container__info-item\"])[4]")
    public WebElement nodeVersionInfoTick;
    @FindBy (how = How.XPATH, using = "//*[@class=\"info__message-box\"]")
    public WebElement nodeVersionPopUp;
    @FindBy (how = How.XPATH, using = "//*[@class=\"info__message-box__text__regular-text\"]")
    public WebElement versionPopUpText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"info__message-box__text\"]/p[2]")
    public WebElement versionPopUpVersion;
    @FindBy (how = How.XPATH, using = "//*[@class=\"satellite-selection-toggle-container\"]")
    public WebElement choosingSatelliteContainer;
    @FindBy (how = How.XPATH, using = "//*[@class=\"satellite-selection-toggle-container__bold-text\"]")
    public WebElement chosenSatelliteText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"satellite-selection-toggle-container__image\"]")
    public WebElement satelliteDropdown;
    @FindBy (how = How.XPATH, using = "//*[@class=\"satellite-selection-toggle-container\"]/p")
    public WebElement currentSatellite;
    @FindBy (how = How.XPATH, using = "//*[text() = \"All Satellites\"]")
    public WebElement allSatellites;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"info-area__title\"])[2]")
    public WebElement utilizationRemainingHeader;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"info-area__title\"])[1]")
    public WebElement utilizationBandwidth;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"chart-container__title-area__title\"])[1]")
    public WebElement bandwidthHeader;
    @FindBy (how = How.XPATH, using = "//*[text() = \" Egress \"]")
    public WebElement bandwidthEgress;
    @FindBy (how = How.XPATH, using = "//*[text() = \" Ingress \"]")
    public WebElement bandwidthIngress;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"chart-container__amount\"])[1]/b")
    public WebElement bandwidthData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"bandwidth-chart\"]")
    public WebElement bandwidthGraph;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"chart-container__title-area__title\"])[2]")
    public WebElement diskSpaceHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"chart-container__amount disk-space-amount\"]/b")
    public WebElement diskSpaceData;
    @FindBy (how = How.XPATH, using = "//*[@id=\"disk-space-chart\"]")
    public WebElement diskSpaceGraph;
    @FindBy (how = How.XPATH, using = "//*[@class=\"disk-stat-area__title\"]")
    public WebElement remainingHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"disk-stat-area__amount\"]")
    public WebElement bandwidthRemainingAmount;
    @FindBy (how = How.XPATH, using = "//*[@class=\"disk-stat-area__chart\"]")
    public WebElement bandwidthRemainingCanvas;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"disk-stat-area__info-area__item__labels-area\"])[1]")
    public WebElement bandwidthRemainUsed;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"disk-stat-area__info-area__item__labels-area\"])[2]")
    public WebElement bandwidthRemainFree;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"disk-stat-area__info-area__item__labels-area\"])[3]")
    public WebElement bandwidthRemainTrash;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"remaining-space-container__bar\"])[1]")
    public WebElement bandwidthRemainBar;
    @FindBy (how = How.XPATH, using = "//*[@class=\"info__message-box\"]")
    public WebElement bandwidthRemainBarHint;
    @FindBy (how = How.XPATH, using = "//*[@class=\"bar-info-container__title\"]")
    public WebElement diskRemainText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"bar-info-container__amount\"]")
    public WebElement diskRemainData;
    @FindBy (how = How.XPATH, using = "//*[@class=\"bar-container__fill\"]")
    public WebElement diskRemainBar;
    @FindBy (how = How.XPATH, using = "//*[@class=\"info__message-box\"]")
    public WebElement diskRemainBarHint;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Payout\"]")
    public WebElement payoutHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payout-container__wallet-address-section__label\"]")
    public WebElement storjWalletAddressText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payout-container__image\"]")
    public WebElement walletLogo;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payout-container__wallet-address-section__bold-text\"]")
    public WebElement walletData;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payout-container__button\"]")
    public WebElement payoutButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payout-container\"]/a")
    public WebElement payoutLink;
    @FindBy (how = How.XPATH, using = "//*[@class=\"storj-logo footer__content-holder__icon\"]")
    public WebElement footerLogo;
    @FindBy (how = How.XPATH, using = "//*[@class=\"footer__content-holder__links-area__community-link\"]")
    public WebElement linkToCommunity;
    @FindBy (how = How.XPATH, using = "//*[@class=\"footer__content-holder__links-area__support-link\"]")
    public WebElement linkToSupport;



    @FindBy (how = How.XPATH, using = "(//*[@class=\"info-area__title\"])[3]")
    public WebElement auditUptimeHeader;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"checks-area-container__header__title\"])[1]")
    public WebElement uptimeChecksText;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"checks-area-container__header__info-area\"])[1]")
    public WebElement suspentionScoreHintTick;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"tooltip__text-area__text\"])[1]")
    public WebElement suspentionScoreHintText;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"checks-area-container__amount\"])[1]/b")
    public WebElement uptimeCheckData;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"checks-area-container__header__title\"])[2]")
    public WebElement auditChecksText;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"checks-area-container__header__info-area\"])[2]")
    public WebElement auditChecksHintTick;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"tooltip__text-area__text\"])[2]")
    public WebElement auditCheckHintText;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"checks-area-container__amount\"])[2]/b")
    public WebElement auditCheckData;

    @FindBy (how = How.XPATH, using = "//*[@class=\"info-area__blurred-checks\"]")
    public WebElement auditCheckBlur;
    @FindBy (how = How.XPATH, using = "//*[@class=\"info-area__blurred-checks__title\"]")
    public WebElement auditCheckBlurText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"info-area__payout-header__link\"]")
    public WebElement linkToPayouts;



    @FindBy (how = How.XPATH, using = "(//*[@class=\"total-payout-area__united-info-area__item__label\"])[1]")
    public WebElement payoutCurrentMonthEarningsTitle;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"total-payout-area__united-info-area__item__amount\"])[1]")
    public WebElement payoutCurrentMonthEarningsAmount;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"total-payout-area__united-info-area__item__label\"])[2]")
    public WebElement payoutTotalEarnedTitle;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"total-payout-area__united-info-area__item__amount\"])[2]")
    public WebElement payoutTotalEarnedAmount;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"total-payout-area__united-info-area__item__label\"])[3]")
    public WebElement payoutTotalHeldTitle;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"total-payout-area__united-info-area__item__amount\"])[3]")
    public WebElement payoutTotalHeldAmount;


    //notification pop-up

    @FindBy (how = How.XPATH, using = "//*[@class=\"header__content-holder__right-area__bell-area\"]")
    public WebElement bellButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"notification-popup-container__header__title\"]")
    public WebElement notificationsPopupTitle;
    @FindBy (how = How.XPATH, using = "//*[@class=\"notification-popup-container__header__link\"]")
    public WebElement notificationsPopupSeeAll;
    @FindBy (how = How.CSS, using = "#app > div > div.header > div > div.notification-popup-container.header__content-holder__right-area__bell-area__popup > div.notification-popup-container__empty-state > img")
    public WebElement notificationsPopupImage;
    @FindBy (how = How.XPATH, using = "//*[@class=\"notification-popup-container__empty-state__label\"]")
    public WebElement notificationsPopupNoYet;


    // options button
    @FindBy (how = How.XPATH, using = "//*[@class=\"options-button\"]")
    public WebElement optionsButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"options-dropdown__mode\"]")
    public WebElement optionsLigth_Dark;
    @FindBy (how = How.XPATH, using = "//*[@class=\"satellite-choice__right-area__button\"]")
    public WebElement showSatelliteID_NameButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"satellite-choice__name with-copy-button\"]")
    public WebElement satelliteID;
    @FindBy (how = How.XPATH, using = "//*[@class=\"satellite-choice__right-area__button copy-button\"]")
    public WebElement copySatelliteIDButton;
    @FindBy (how = How.CSS, using = "#app > div > div.header > div > div.header__content-holder__right-area > div.header__content-holder__right-area__node-id-container > svg")
    public WebElement nodeIDCopyButton;



    public void  chooseFirstSatellite (){
        List<WebElement> satellites = driver.findElements(By.xpath("//*[@class=\"satellite-choice\"]"));
        satellites.get(0).click();
    }
    public void  chooseSecondSatellite (){
        List<WebElement> satellites = driver.findElements(By.xpath("//*[@class=\"satellite-choice\"]"));
        satellites.get(1).click();
    }
    public void  chooseAllSatellites (){
        List<WebElement> satellites = driver.findElements(By.xpath("//*[@class=\"satellite-selection-overflow-container__satellite-choice\"]"));
        satellites.get(0).click();
    }

//    public void choosingBrowserOS () {
//        String OS = System.getProperty("os.name");
//        String chosingOS = "";
//        if (OS.equals("Linux")){
//            switch (browser){
//                case "Firefox":
//                    chosingOS=NodeDashboardPage.GECKODRIVERPATH;
//                    break;
//                case "Chrome":
//                    chosingOS=NodeDashboardPage.CHROMEDRIVERPATH;
//                    break;
//                case "Opera":
//                    chosingOS=NodeDashboardPage.OPERADRIVERPATH;
//                    break;
//                default:
//                    chosingOS = "";
//            }
//        }
//        else if (OS.substring(0,4).equals("Windo")){
//            chosingOS = NodeDashboardPage.CHROMEDRIVERPATHWIN;
//        }
//        else if (OS.substring(0,3).equals("Mac")){
//            chosingOS = NodeDashboardPage.CHROMEDRIVERPATHMAC;
//        }else{
//            //If no os passed throw exception
//            throw new Exception("os is not correct");
//        }
//        //Check if parameter passed from TestNG is 'firefox'
//        if(browser.equalsIgnoreCase("Firefox")){
//            //create firefox instance
//            System.setProperty("webdriver.gecko.driver", chosingOS);
//            driver = new FirefoxDriver();
//        }
//        //Check if parameter passed as 'chrome'
//        else if(browser.equalsIgnoreCase("Chrome")){
//            System.out.println(chosingOS);
//            //set path to chromedriver.exe
//            // System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedrivermac");
//            System.setProperty("webdriver.chrome.driver", chosingOS);
//            //create chrome instance
//
//            driver = new ChromeDriver();
//        }
//        //  Check if parameter passed as 'Opera'
//        else if(browser.equalsIgnoreCase("Opera")){
//            //set path to Edge.exe
//            System.setProperty("webdriver.opera.driver", chosingOS);
//            driver = new OperaDriver();
//        } else if(browser.equalsIgnoreCase("Safari")){
//            System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
//            driver = new SafariDriver();
//        }
//        else{
//            //If no browser passed throw exception
//            throw new Exception("Browser is not correct");
//        }
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        if(browser.equalsIgnoreCase("Safari")){q
//            driver.manage().window().maximize();
//        } else {
//            driver.manage().window().setSize(new Dimension(NodeDashboardPage.Width, NodeDashboardPage.Height));}
//        driver.get(NodeDashboardPage.DASHBOARDURL);
//    }


}
