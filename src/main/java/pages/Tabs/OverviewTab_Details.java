package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.HomePage;

public class OverviewTab_Details extends HomePage {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"deleteProjectPopupButton\"]/div")
    public WebElement deleteProjectButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/div[1]/input")
    public WebElement deleteProjectNameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"deleteProjectPopup\"]/div[2]/div[2]/div[2]")
    public WebElement Confirm_Project_Delete_Button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/h1")
    public WebElement headerProjectDetails;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/a[1]/p")
    public WebElement detailsTab;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/a[2]/p")
    public WebElement reportTab;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/h2")
    public WebElement projectNameHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[1]/div/h3")
    public WebElement currentProjectName;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/h2")
    public WebElement descriptionHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/h3")
    public WebElement currentProjectDescription;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]")
    public WebElement editDescriptionButton;


    //EDIT DESCRIPTION DIALOG

    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[1]/div/h3[1]")
    public WebElement editDescriptionHeader;
    @FindBy (how = How.XPATH, using = "//*[@id=\"Description\"]")
    public WebElement editDescriptionText;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[1]")
    public WebElement editDescriptionCancelButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]")
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


    public OverviewTab_Details(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
