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

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]")
    public WebElement cardContainer;
//    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/img")
//    public WebElement cardContainerstorjLogo;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div/div[1]/div[1]")
    public WebElement cardContainerCardInfo;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div/div[1]/div[2]")
    public WebElement cardContainerCardExpire;
//    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[1]/div[1]/h3")
//    public WebElement cardContainerCardAddedDate;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div/div[2]/div/div/p[1]")
    public WebElement cardContainerMakeCardDefaultButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div/div[2]/div/div/p[2]")
    public WebElement cardDeleteCardButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div/div[2]")
    public WebElement addNewCardButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div/div/div[1]")
    public WebElement addStorjPayButton;
}
