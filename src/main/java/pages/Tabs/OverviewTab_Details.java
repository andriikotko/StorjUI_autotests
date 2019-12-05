package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.HomePage;

import java.io.IOException;

public class OverviewTab_Details extends HomePage {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"deleteProjectPopupButton\"]/div")
    public WebElement deleteProjectButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/div[1]/input")
    public WebElement deleteProjectNameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/div[2]/div[2]")
    public WebElement Confirm_Project_Delete_Button;
    @FindBy(how = How.XPATH, using = "//*[@class=\"project-details__title\"]")
    public WebElement headerProjectDetails;
    @FindBy (how = How.XPATH, using = "//*[@href=\"/project-overview/details\"]")
    public WebElement detailsTab;
    @FindBy (how = How.XPATH, using = "//*[@href=\"/project-overview/usage-report\"]")
    public WebElement reportTab;
    @FindBy (how = How.XPATH, using = "//*[@class=\"project-details-info-container__name-container__title\"]")
    public WebElement projectNameHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"project-details-info-container__name-container__project-name\"]")
    public WebElement currentProjectName;
    @FindBy (how = How.XPATH, using = "//*[@class=\"project-details-info-container__description-container__text__title\"]")
    public WebElement descriptionHeader;
    @FindBy (how = How.XPATH, using = "//*[@class=\"project-details-info-container__description-container__text__project-description\"]")
    public WebElement currentProjectDescription;
    @FindBy (how = How.XPATH, using = "//*[@class=\"project-details-svg\"]")
    public WebElement editDescriptionButton;


    //EDIT DESCRIPTION DIALOG

    @FindBy (how = How.XPATH, using = "//*[@class=\"label-container__label\"]")
    public WebElement editDescriptionHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"Description\"]")
    public WebElement editDescriptionText;
    @FindBy (how = How.XPATH, using = "//*[@class=\"container white\"]")
    public WebElement editDescriptionCancelButton;
    @FindBy (how = How.XPATH, using = "//*[text() = \"Save\"]")
    public WebElement editDescriptionSaveButton;


    // DELETE PROJECT DIALOG's ELEMENTS

    @FindBy (how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[1]/h2")
    public WebElement deleteProjectDialogHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/p")
    public WebElement deleteProjectDialogQuestion;
    @FindBy (how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/div[1]/p")
    public WebElement deleteProjectDialogConfirmNotification;
    @FindBy (how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/div[1]/input")
    public WebElement deleteProjectDialogInputField;
    @FindBy (how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/div[2]/div[1]")
    public WebElement deleteProjectDialogCancelButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/div[2]/div[2]")
    public WebElement deleteProjectDialogDeleteButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[3]")
    public WebElement deleteProjectDialogCloseButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/div[1]/div/p")
    public WebElement deleteProjectDialogErrorMessage;


    public OverviewTab_Details(WebDriver driver) throws IOException {
        super(driver);
        this.driver = driver;
    }
}
