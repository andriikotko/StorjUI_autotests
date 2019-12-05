package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class APIKeysTab {
    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@class=\"button container\"]")
    //@FindBy(how = How.XPATH, using = "//*[@id=\"addApiKeyPopupButton\"]/div")
    public WebElement createNewAPIkeyButton;


    @FindBy (how=How.XPATH, using = "//*[@id=\"addApiKeyPopup\"]/div/div[1]/div[2]")
    public WebElement CrossButtonOnPopUp;
    @FindBy (how=How.XPATH, using ="//*[@id=\"addApiKeysPopupEmptyButton\"]/div")
    public WebElement newAPIkeyCreateButtonEmpty;
    @FindBy (how=How.XPATH, using ="//*[@class=\"api-keys-area__title\"]")
    public WebElement APIKeysHeader;
    @FindBy (how=How.XPATH, using ="//*[@placeholder=\"Search API Key\"]")
    public WebElement APIKeysSearchField;
    @FindBy (how=How.XPATH, using ="//*[@class=\"sort-header-container__name-item__title\"]")
    public WebElement keyNameHeader;
    @FindBy (how=How.XPATH, using ="//*[@class=\"sort-header-container__date-item__title creation-date\"]")
    public WebElement createdDateHeader;
    @FindBy (how=How.XPATH, using ="//*[@class=\"checkbox-container\"]")
    public WebElement firstAPIKeyCheckboxContainer;
    @FindBy (how=How.XPATH, using ="//*[@class=\"avatar\"]")
    public WebElement firstAPIkeyIcon;
    @FindBy (how=How.XPATH, using ="//*[@class=\"name\"]")
    public WebElement firstAPIKeyName;
    @FindBy (how=How.XPATH, using ="//*[@class=\"date\"]")
    public WebElement firstAPIKeyCreationDate;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div[3]/div")
    public WebElement APIKeysPaginatorContainer;


///DELETE API KEY
    @FindBy (how=How.XPATH, using ="//*[@class=\"button deletion container\"]")
    public WebElement deleteAPIKeyButton;
    @FindBy (how=How.XPATH, using ="//*[@class=\"button container white\"]")
    public WebElement cancelDeletingAPIKeyButton;
    @FindBy (how=How.XPATH, using ="//*[@class=\"header-selected-api-keys__info-text\"]")
    public WebElement amountAPIKeyForDeletion;
    @FindBy (how=How.XPATH, using ="//*[@class=\"header-after-delete-click__confirmation-label\"]")
    public WebElement deleteAPIKeyNotification;
    @FindBy (how=How.XPATH, using ="//*[@class=\"button deletion container\"]")
    public WebElement deleteAPIKeyConfirmation;
    @FindBy (how=How.XPATH, using ="//*[@class=\"button container white\"]")
    public WebElement cancelDeleteAPIKeyConfirmation;


    /// CREATE API KEY
    @FindBy (how=How.XPATH, using ="//*[@class=\"new-api-key__title\"]")
    public WebElement newAPIKeyHeader;
    @FindBy(how=How.XPATH, using ="//*[@class=\"headerless-input\"]")
    public WebElement newAPIkeyNameInput;
    @FindBy (how=How.XPATH, using ="//*[@class=\"next-button container\"]")
    public WebElement confirmAPIKeyCreation;
    @FindBy (how=How.XPATH, using ="//*[@class=\"new-api-key__close-cross-container\"]")
    public WebElement closeNewAPIKeyCreationDialog;
    @FindBy (how=How.XPATH, using ="//*[@class=\"save-api-popup__close-cross-container\"]")
    public WebElement closeAPIKeyDialogAfterCreation;
    @FindBy (how=How.XPATH, using ="//*[@class=\"save-api-popup__copy-area__key-area__key\"]")
    public WebElement newAPIKey;
    @FindBy (how=How.XPATH, using ="//*[@class=\"copy-button\"]")
    public WebElement newAPIKeyCopyButton;
    @FindBy (how=How.XPATH, using ="//*[@class=\"save-api-popup__title\"]")
    public WebElement newCreatedAPIKeyDialogHeader;
    @FindBy (how=How.XPATH, using ="//*[@class=\"label-container__error\"]")
    public WebElement errorAPIKeyCreation;


    // TAB WITHOUT API KEY

    @FindBy (how=How.XPATH, using ="//*[@class=\"empty-state__wrap__title\"]")
    public WebElement noAPIHeader;
    @FindBy (how=How.XPATH, using ="//*[@class=\"empty-state__wrap__additional-text\"]")
    public WebElement noAPIKeysNotification;
    @FindBy (how=How.XPATH, using ="//*[text() = \"Create an API Key\"]")
    public WebElement noAPICreateNew;
    @FindBy (how=How.XPATH, using ="//*[@class=\"empty-state__wrap__img\"]")
    public WebElement noAPIKeysImage;
    @FindBy (how=How.XPATH, using ="//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div/div")
    public WebElement checkAPIPresence;




    public APIKeysTab(WebDriver driver)
    {
        this.driver=driver;
    }
}
