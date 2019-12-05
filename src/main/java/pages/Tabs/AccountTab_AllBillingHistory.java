package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountTab_AllBillingHistory {
    WebDriver driver;

    public AccountTab_AllBillingHistory(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (how = How.XPATH, using = "//*[@class=\"billing-history-area__content__title\"]")
    public WebElement allBillingHistoryHeader;

    @FindBy (how = How.XPATH, using = "//*[text() = \"Date\"] ")
    public WebElement allBillingHistoryDateHeader;

    @FindBy (how = How.XPATH, using = "//*[text() = \"Description\"] ")
    public WebElement allBillingHistoryDescriptionHeader;

    @FindBy (how = How.XPATH, using = "//*[text() = \"Status\"] ")
    public WebElement allBillingHistoryStatusHeader;

    @FindBy (how = How.XPATH, using = "//*[text() = \"Amount\"] ")
    public WebElement allBillingHistoryAmountHeader;

    @FindBy (how = How.XPATH, using = "//*[@class=\"billing-history-area__title-area__back-button\"]")
    public WebElement allBillingHistoryBackButton;

    @FindBy (how = How.XPATH, using = "//*[text() = \"Back to Account\"] ")
    public WebElement allBillingHistoryBackButtonText;

    @FindBy (how = How.XPATH, using = "//*[@class=\"billing-history-area__content__title\"]")
    public WebElement allBillingHistoryPaginator;


}
