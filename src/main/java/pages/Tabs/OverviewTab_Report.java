package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OverviewTab_Report {
    final WebDriver driver;
    public OverviewTab_Report(WebDriver driver) { this.driver = driver;
    }

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/h1")
    public WebElement reportTabHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[1]/p")
    public WebElement currentBillingPeriod;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/p")
    public WebElement previousBillingPeriod;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/p")
    public WebElement customDateRange;
    @FindBy (how = How.XPATH, using = "///*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/svg")
    public WebElement customDateRangeIcon;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div[1]/h1")
    public WebElement storageHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div[1]/h2")
    public WebElement storageValue;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div[2]/h1")
    public WebElement egressHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div[2]/h2")
    public WebElement egressValue;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div[3]/h1")
    public WebElement objectHoursHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div[1]/div[3]/h2")
    public WebElement objectHoursValue;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/p")
    public WebElement currentRollUpPeriod;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div[2]/div/p")
    public WebElement downloadAdvancedReportHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"usage-report-container__main-area__footer__report-area__image\"]")
    public WebElement downloadAdvancedReportButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[2]/div[3]/div/div[2]/div")
    public WebElement calendarForCustomDataRange;

}
