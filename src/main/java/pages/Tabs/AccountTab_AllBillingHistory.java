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

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/h1")
    public WebElement allBillingHistoryHeader;

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]")
    public WebElement allBillingHistoryDateHeader;

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]")
    public WebElement allBillingHistoryDescriptionHeader;

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[3]")
    public WebElement allBillingHistoryStatusHeader;

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[4]")
    public WebElement allBillingHistoryAmountHeader;

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div")
    public WebElement allBillingHistoryBackButton;

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/p")
    public WebElement allBillingHistoryBackButtonText;

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div")
    public WebElement allBillingHistoryPaginator;


}
