package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APIKeysTab {
    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div/div")
    //@FindBy(how = How.XPATH, using = "//*[@id=\"addApiKeyPopupButton\"]/div")
    public WebElement createNewAPIkeyButton;


    @FindBy (how=How.XPATH, using = "//*[@id=\"addApiKeyPopup\"]/div/div[1]/div[2]")
    public WebElement CrossButtonOnPopUp;
    @FindBy (how=How.XPATH, using ="//*[@id=\"addApiKeysPopupEmptyButton\"]/div")
    public WebElement newAPIkeyCreateButtonEmpty;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/h1")
    public WebElement APIKeysHeader;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div/input")
    public WebElement APIKeysSearchField;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/p")
    public WebElement keyNameHeader;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/p")
    public WebElement createdDateHeader;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]")
    public WebElement firstAPIKeyCheckboxContainer;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[2]")
    public WebElement firstAPIkeyIcon;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/p")
    public WebElement firstAPIKeyName;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div[1]/p")
    public WebElement firstAPIKeyCreationDate;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div")
    public WebElement APIKeysPaginatorContainer;


///DELETE API KEY
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]")
    public WebElement deleteAPIKeyButton;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[2]")
    public WebElement cancelDeletingAPIKeyButton;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div/div/span")
    public WebElement deleteAPIKeyConfirmation;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div/div/div/div[2]")
    public WebElement cancelDeleteAPIKeyConfirmation;


    /// CREATE API KEY
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/h2")
    public WebElement newAPIKeyHeader;
    @FindBy(how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/input")
    // @FindBy(how=How.XPATH, using ="//*[@id=\"Name\"]")
    public WebElement newAPIkeyNameInput;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[2]/h1")
    // @FindBy (how=How.XPATH, using ="//*[@id=\"addApiKeyPopup\"]/div[2]/div[2]/div[2]")
    public WebElement confirmAPIKeyCreation;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[3]")
    public WebElement closeNewAPIKeyCreationDialog;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[2]")
    public WebElement closeAPIKeyDialogAfterCreation;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[1]/p")
    public WebElement newAPIKey;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div[2]")
    public WebElement newAPIKeyCopyButton;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/h2")
    public WebElement newCreatedAPIKeyDialogHeader;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div/h3")
    public WebElement errorAPIKeyCreation;


    // TAB WITHOUT API KEY

    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div/div/h1")
    public WebElement noAPIHeader;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div/div/div[1]/p")
    public WebElement noAPIKeysNotification;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div/div/div[2]/div")
    public WebElement noAPICreateNew;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div/div/div[3]")
    public WebElement noAPIKeysImage;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div")
    public WebElement checkAPIPresence;




    public APIKeysTab(WebDriver driver)
    {
        this.driver=driver;
    }
}
