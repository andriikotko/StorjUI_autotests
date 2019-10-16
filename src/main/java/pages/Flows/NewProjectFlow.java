package pages.Flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterClass;

public class NewProjectFlow {
    final WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id=\"Project Name\"]")
    public WebElement project_Name_input;
    @FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]")
    public WebElement project_Description_input;
    @FindBy(how = How.XPATH, using = "//*[@id=\"newProjectPopup\"]/div[2]/div[3]/div[2]")
    public WebElement create_Project_Button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"successfulProjectCreationPopup\"]/div[3]")
    public WebElement close_cross_button_on_Congrats;




    public NewProjectFlow(WebDriver driver) {
        this.driver = driver;
    }
}
