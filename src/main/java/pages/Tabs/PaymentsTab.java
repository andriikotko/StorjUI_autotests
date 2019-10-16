package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PaymentsTab {
    final WebDriver driver;
    @FindBy(how= How.XPATH,using ="//*[@id=\"card-element\"]/div/iframe")
    public WebElement STRIPE_IFRAME;
    @FindBy(how =How.XPATH,using ="//*[@id=\"root\"]/form/div/div[2]/span[1]/span[2]/span/input")
    public WebElement Card_Input;
    @FindBy(how =How.XPATH,using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/a[2]")
    public WebElement Payment_Tab;
    @FindBy(how = How.XPATH, using ="//*[@id=\"payment-form\"]/div[2]")
    public WebElement Save_Card_Button;
    public PaymentsTab(WebDriver driver) {
        this.driver = driver;
    }
}
