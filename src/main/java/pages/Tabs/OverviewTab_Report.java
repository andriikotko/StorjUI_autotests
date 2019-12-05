package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OverviewTab_Report {
    final WebDriver driver;
    public OverviewTab_Report(WebDriver driver) { this.driver = driver;
    }

    @FindBy (how = How.XPATH, using = "//*[@class=\"usage-report-container__header__title\"]")
    public WebElement reportTabHeader;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Current Billing Period\"]")
    public WebElement currentBillingPeriod;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Previous Billing Period\"]")
    public WebElement previousBillingPeriod;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Custom Date Range\"]")
    public WebElement customDateRange;
    @FindBy (how = How.XPATH, using = "//*[@class=\"usage-report-container__options-area__option__image\"]")
    public WebElement customDateRangeIcon;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"usage-report-container__main-area__info-area__item__title\"])[1]")
    public WebElement storageHeader;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"usage-report-container__main-area__info-area__item__amount\"])[1]")
    public WebElement storageValue;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"usage-report-container__main-area__info-area__item__title\"])[2]")
    public WebElement egressHeader;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"usage-report-container__main-area__info-area__item__amount\"])[2]")
    public WebElement egressValue;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"usage-report-container__main-area__info-area__item__title\"])[3]")
    public WebElement objectHoursHeader;
    @FindBy (how = How.XPATH, using = "(//*[@class=\"usage-report-container__main-area__info-area__item__amount\"])[3]")
    public WebElement objectHoursValue;
    @FindBy (how = How.XPATH, using = "//*[@class=\"usage-report-container__main-area__footer__rollup-info\"]")
    public WebElement currentRollUpPeriod;
    @FindBy (how = How.XPATH, using = "//*[@class=\"usage-report-container__main-area__footer__report-area__download-text\"]")
    public WebElement downloadAdvancedReportHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"usage-report-container__main-area__footer__report-area__image\"]")
    public WebElement downloadAdvancedReportButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"cov-date-body\"]")
    public WebElement calendarForCustomDataRange;

}
