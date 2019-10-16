package pages.Flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ResetPasswordFlow {
    final WebDriver driver;
    @FindBy(how= How.XPATH, using = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[2]/input")
    public WebElement Reset_Password_input;
    @FindBy(how=How.XPATH,using ="//*[@id=\"app\"]/div/div[2]/div[2]/div/div[3]/div")
    public WebElement Submit_Reset_Password;
    @FindBy (how=How.XPATH,using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement Notification_Reset_email_Success;


    public ResetPasswordFlow(WebDriver driver) {
        this.driver = driver;
    }
}
