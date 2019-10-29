package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountTab_Billing {
    public WebDriver driver;


        public AccountTab_Billing(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/h1")
    public WebElement accountBalanceHeader;
    @FindBy (how = How.CSS, using = "#app > div > div > div.dashboard-container__wrap__column > div.dashboard-container__main-area > div > div > div.account-balance-area > div.account-balance-area__title-area > div > svg")
    public WebElement accountBalanceHint;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div/div")
    public WebElement accountBalanceHintText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/span")
    public WebElement accountBalanceBalance;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div")
    public WebElement accountBalanceEarnCreditsButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/h1")
    public WebElement currentMonthHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/h2")
    public WebElement currentMonthTitle;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/h2")
    public WebElement currentMonthContentTitle;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/span")
    public WebElement usageCharges;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div[1]/div/span")
    public WebElement referralCredits;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div[1]/h1")
    public WebElement depositBillingHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[5]/div[1]/div")
    public WebElement depositHistoryViewAllButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[5]/div[2]/div[1]")
    public WebElement depositHistoryDateHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[5]/div[2]/div[2]")
    public WebElement depositHistoryDescriptionHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[5]/div[2]/div[3]")
    public WebElement depositHistoryStatusHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[5]/div[2]/div[4]")
    public WebElement depositHistoryAmountHeader;


    // PAYMENT METHODS

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]")
    public WebElement cardContainer;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/img")
    public WebElement cardContainerstorjLogo;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[1]")
    public WebElement cardContainerCardInfo;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[2]")
    public WebElement cardContainerCardExpire;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/h3")
    public WebElement cardContainerCardAddedDate;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/div[2]")
    public WebElement cardContainerMakeCardDefaultButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[2]")
    public WebElement addNewCardButton;

}
