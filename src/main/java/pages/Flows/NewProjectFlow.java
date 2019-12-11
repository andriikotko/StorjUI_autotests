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
    @FindBy(how = How.XPATH, using = "//*[text() = \"Next\"]")
    public WebElement create_Project_Button;
    @FindBy(how = How.XPATH, using = "//*[@class = \"project-creation-success-popup__close-cross-container\"]")
    public WebElement close_cross_button_on_Congrats;
    @FindBy(how = How.XPATH, using = "//*[@class = \"project-creation-success-popup__form-container__main-label-text\"]")
    public WebElement congratsHeader;
    @FindBy(how = How.XPATH, using = "//*[@class = \"project-creation-success-popup__form-container__confirmation-text\"]")
    public WebElement congratsText;
    @FindBy(how = How.XPATH, using = "//*[@class = \"project-creation-success-popup__form-container__confirmation-text__link\"]")
    public WebElement congratsLinkToUplink;
    @FindBy(how = How.XPATH, using = "//*[@class = \"project-creation-success-popup__info-panel-container\"]")
    public WebElement congratsImage;
    @FindBy(how = How.XPATH, using = "//*[@class = \"container white\"]")
    public WebElement congratsLaterButton;
    @FindBy(how = How.XPATH, using = "//*[@class = \"container\"]")
    public WebElement congratsAPICreateButton;




    public NewProjectFlow(WebDriver driver) {
        this.driver = driver;
    }
}
