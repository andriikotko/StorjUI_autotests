package pages.NodeDashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NodePayouts {
    WebDriver driver;

    public NodePayouts(WebDriver driver) {
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


    @FindBy(how = How.XPATH, using = "//*[@class = \"payout-area-container__header__back-link router-link-active\"]")
    public WebElement backToMainPage;
    @FindBy(how = How.XPATH, using = "//*[@class = \"payout-area-container__header__text\"]")
    public WebElement payoutInformationHeader;

    @FindBy(how = How.XPATH, using = "//*[@class=\"satellite-selection-toggle-container\"]")
    public WebElement choosingSatelliteContainer;
    @FindBy(how = How.XPATH, using = "//*[@class=\"satellite-selection-toggle-container__bold-text\"]")
    public WebElement chosenSatelliteText;
    @FindBy(how = How.XPATH, using = "//*[@class=\"satellite-selection-toggle-container__image\"]")
    public WebElement satelliteDropdown;
    @FindBy(how = How.XPATH, using = "//*[@class=\"satellite-selection-toggle-container\"]/p")
    public WebElement currentSatellite;
    @FindBy(how = How.XPATH, using = "//*[@class=\"satellite-selection-toggle-container\"]")
    public WebElement allSatellites;

    @FindBy(how = How.XPATH, using = "(//*[@class = \"payout-area-container__section-title\"])[1]")
    public WebElement payoutSectionHeader;
    @FindBy(how = How.XPATH, using = "//*[@class = \"estimation-container__header__title\"]")
    public WebElement payoutTableInfoEstimation;
    @FindBy(how = How.XPATH, using = "//*[@class = \"period-container\"]")
    public WebElement payoutTablePeriodDropList;


    @FindBy(how = How.XPATH, using = "(//*[@class = \"estimation-table-container__labels-area__text\"])[1]")
    public WebElement payoutTableHeaderName;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"estimation-table-container__labels-area__text\"])[2]")
    public WebElement payoutTableHeaderType;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"estimation-table-container__labels-area__text\"])[3]")
    public WebElement payoutTableHeaderPrice;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"estimation-table-container__labels-area__text\"])[4]")
    public WebElement payoutTableHeaderDisk;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"estimation-table-container__labels-area__text\"])[5]")
    public WebElement payoutTableHeaderBandwidth;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"estimation-table-container__labels-area__text\"])[6]")
    public WebElement payoutTableHeaderPayouts;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-1\"])[2]/p")
    public WebElement payoutTableDowload_Name;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-1\"])[3]/p")
    public WebElement payoutTableRepaiAudit_Name;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-1\"])[4]/p")
    public WebElement payoutTableDiskMonth_Name;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-1\"])[5]/p")
    public WebElement payoutTableGrossTotal_Name;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-1\"])[6]/p")
    public WebElement payoutTableTotal_Name;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-2\"])[2]/p")
    public WebElement payoutTableDownload_Type;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-2\"])[3]/p")
    public WebElement payoutTableRepairAudit_Type;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-2\"])[4]/p")
    public WebElement payoutTableDiskMonth_Type;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-3\"])[2]/p")
    public WebElement payoutTableDownload_Price;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-3\"])[3]/p")
    public WebElement payoutTableRepairAudit_Price;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-3\"])[4]/p")
    public WebElement payoutTableDiskMonth_Price;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-4\"])[2]/p")
    public WebElement payoutTableDownload_Disk;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-4\"])[3]/p")
    public WebElement payoutTableRepairAudit_Disk;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-4\"])[4]/p")
    public WebElement payoutTableDiskMonth_Disk;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-4\"])[6]/p")
    public WebElement payoutTableTotal_Disk;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-5\"])[2]/p")
    public WebElement payoutTableDownload_Bandwidth;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-5\"])[3]/p")
    public WebElement payoutTableRepairAudit_Bandwidth;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-5\"])[4]/p")
    public WebElement payoutTableDiskAverage_Bandwidth;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-start column-5\"])[6]/p")
    public WebElement payoutTableTotal_Bandwidth;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-end column-6\"])[2]/p")
    public WebElement payoutTableDownload_Payout;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-end column-6\"])[3]/p")
    public WebElement payoutTableRepairaudit_Payout;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-end column-6\"])[4]/p")
    public WebElement payoutTableTDiskMonth_Payout;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-end column-6\"])[5]/p")
    public WebElement payoutTableGrossTotal_Payout;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"column justify-end column-6\"])[6]/p")
    public WebElement payoutTableTotal_Payout;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"estimation-table-container__held-area__text\"])[1]")
    public WebElement payoutTableHeldback_Name;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"estimation-table-container__held-area__text\"])[2]")
    public WebElement payoutTableHeldback_Payout;


    @FindBy(how = How.XPATH, using = "(//*[@class = \"payout-area-container__section-title\"])[2]")
    public WebElement heldAmountSectionHeader;
    @FindBy(how = How.XPATH, using = "//*[@class = \"additional-text\"]")
    public WebElement heldAmountText;
    @FindBy(how = How.XPATH, using = "//*[@class = \"additional-text\"]/a")
    public WebElement heldAmountLink;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"info-container__value\"])[1]")
    public WebElement heldAmountRate_value;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"info-container__label\"])[1]")
    public WebElement heldAmountRate_Label;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"info-container__value\"])[2]")
    public WebElement heldAmountTotal_value;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"info-container__label\"])[2]")
    public WebElement heldAmountTotal_label;
    @FindBy(how = How.XPATH, using = "//*[@class = \"held-progress__steps-area\"]")
    public WebElement heldAmountProgress;
    @FindBy(how = How.XPATH, using = "//*[@class = \"held-progress__main-text\"]")
    public WebElement heldAmountMonthOnNetwork;



    // Held Amount History\

    @FindBy(how = How.XPATH, using = "//*[@class = \"held-history-container__header__title\"]")
    public WebElement heldAmountHistoryTitle;
    @FindBy(how = How.XPATH, using = "//*[text() = \" All Stats \"]")
    public WebElement heldAmountHistoryAllStats;
    @FindBy(how = How.XPATH, using = "//*[text() = \" Monthly Breakdown \"]")
    public WebElement heldAmountHistoryMonthlyBreakdown;

    @FindBy(how = How.XPATH, using = "(//*[@class = \"held-history-table-container--large__labels-area__text\"])[1]")
    public WebElement heldHistorySatelliteTitle;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"held-history-table-container--large__labels-area__text\"])[2]")
    public WebElement heldHistorySecondColumnTitle;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"held-history-table-container--large__labels-area__text\"])[3]")
    public WebElement heldHistoryThirdColumnTitle;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"held-history-table-container--large__labels-area__text\"])[4]")
    public WebElement heldHistoryFourthColumnTitle;


    @FindBy(how = How.XPATH, using = "(//*[@class = \"held-history-table-container--large__info-area__text\"])[1]")
    public WebElement heldHistorySatelliteData_Name;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"held-history-table-container--large__info-area__months\"])[1]")
    public WebElement heldHistorySatelliteData_Month;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"held-history-table-container--large__info-area__text\"])[2]")
    public WebElement heldHistorySecondColumnData;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"held-history-table-container--large__info-area__text\"])[3]")
    public WebElement heldHistoryThirdColumnData;
    @FindBy(how = How.XPATH, using = "(//*[@class = \"held-history-table-container--large__info-area__text\"])[4]")
    public WebElement heldHistoryFourthColumnData;
}