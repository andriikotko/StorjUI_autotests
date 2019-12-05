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

    @FindBy (how = How.XPATH, using = "//*[@class=\"account-balance-area__title-area__title\"]")
    public WebElement accountBalanceHeader;
    @FindBy (how = How.CSS, using = "#app > div > div > div.dashboard-container__wrap__column > div.dashboard-container__main-area > div > div > div > div.account-balance-area > div.account-balance-area__title-area > div > svg")
    public WebElement accountBalanceHint;
    @FindBy (how = How.XPATH, using = "//*[@class=\"info__message-box__text\"]")
    public WebElement accountBalanceHintText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"account-balance-area__balance-area__balance\"]")
    public WebElement accountBalanceBalance;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div")
    public WebElement accountBalanceEarnCreditsButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"current-month-area__header__month-info__title\"]")
    public WebElement currentMonthHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"current-month-area__header__month-info__title-info\"]")
    public WebElement currentMonthTitle;
    @FindBy (how = How.XPATH, using = "//*[@class=\"current-month-area__content__title\"]")
    public WebElement currentMonthContentTitle;
    @FindBy (how = How.XPATH, using = "//*[@class=\"current-month-area__content__usage-charges__head__name__title\"]")
    public WebElement usageCharges;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div[2]/div[1]/div/span")
    public WebElement referralCredits;
    @FindBy (how = How.XPATH, using = "//*[@class=\"deposit-and-billing-area__header__title\"]")
    public WebElement depositBillingHeader;
    @FindBy (how = How.XPATH, using = "//*[text() = \"View All\"]")
                                         //*[@id="app"]/div/div/div[2]/div[2]/div[2]/div/div/div[5]/div[1]/div
                                         //*[@id="app"]/div/div/div[2]/div[2]/div/div/div/div[4]/div[1]/div
    public WebElement depositHistoryViewAllButton;
    @FindBy (how = How.XPATH, using = "//*[text() = 'Date'] ")
    public WebElement depositHistoryDateHeader;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Description\"] ")
    public WebElement depositHistoryDescriptionHeader;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Status\"] ")
    public WebElement depositHistoryStatusHeader;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Amount\"] ")
    public WebElement depositHistoryAmountHeader;


    // PAYMENT METHODS

    @FindBy (how = How.XPATH, using = "//*[@class=\"payment-methods-container__card-container\"]")
    public WebElement cardContainer;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payment-methods-container__card-container__info-area__card-logo\"]")
    public WebElement cardContainerCardLogo;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payment-methods-container__card-container__info-area__info-container\"]")
    public WebElement cardContainerCardInfo;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payment-methods-container__card-container__info-area__expire-container\"]")
    public WebElement cardContainerCardExpire;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payment-methods-container__card-container__default-button\"]")
    public WebElement cardIsDefaultButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"payment-methods-container__card-container__dots-container\"]")
    public WebElement cardContainerTwoDotsButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"label dialog__delete\"]")
    public WebElement cardContainerDeleteCardButton;
    @FindBy (how = How.XPATH, using = "//*[@class=\"label dialog__make-default\"]")
    public WebElement cardContainerMakeCardDefaultButton;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Add Card\"] ")
    public WebElement addNewCardButton;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Add STORJ\"] ")
    public WebElement addStorjButton;

}
