package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import javax.swing.plaf.basic.BasicDesktopIconUI;

public class AccountTab_PaymentMethods {
    WebDriver driver;

    public AccountTab_PaymentMethods(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//*[@class=\"payment-methods-container__card-container\"]")
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
    @FindBy(how = How.XPATH, using = "//*[@class=\"label dialog__make-default\"]")
    public WebElement cardContainerMakeCardDefaultButton;
    @FindBy(how = How.XPATH, using = "//*[@class=\"label dialog__delete\"]")
    public WebElement cardDeleteCardButton;


    @FindBy(how = How.XPATH, using = "//*[@class=\"payment-methods-area__title text\"]")
    public WebElement paymentMethodsHeader;
    @FindBy(how = How.XPATH, using = "//*[text() = \"Add Card\"]")
    public WebElement addNewCardButton;
    @FindBy(how = How.XPATH, using = "//*[text() = \"Add STORJ\"]")
    public WebElement addStorjPayButton;
    @FindBy(how = How.XPATH, using = "//*[@class=\"payment-methods-area__title text\"]")
    public WebElement depositStorjHeader;
    @FindBy(how = How.XPATH, using = "//*[@class=\"storj-container__label\"]")
    public WebElement depositStorjNotification;
    @FindBy(how = How.XPATH, using = "//*[@id=\"paymentSelectButton\"]")
    public WebElement paymentSelectButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"paymentSelect\"]")
    public WebElement paymentOptionsDroplist;
    @FindBy(how = How.XPATH, using = "//*[@id=\"paymentSelect\"]/div[1]")
    public WebElement firstPaymentOption;
    @FindBy(how = How.CSS, using = "#paymentSelectButton > div > svg")
    public WebElement droplistTick;
    @FindBy(how = How.XPATH, using = "//*[text() = \"Continue to Coin Payments\"]")
    public WebElement continueToCoinPaymentsButton;
    @FindBy(how = How.XPATH, using = "//*[text() = \"Cancel\"]")
    public WebElement paymentMethodsCancelButton;
    @FindBy(how = How.XPATH, using = "//*[@class=\"custom-input\"]")
    public WebElement customInput;

}
