package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TeamTab {
    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@class=\"team-header-container__title-area__title\"]")
    public WebElement projectMembersHeader;

    @FindBy(how = How.XPATH, using = "//*[@class=\"team-header-container__title-area__info-button__image\"]")
    public WebElement projectRoleHint;

    @FindBy(how = How.XPATH, using = "//*[@class=\"info__message-box__text\"]")
    public WebElement projectRoleHintText;

    @FindBy(how = How.XPATH, using = "//*[@class=\"button container\"]")
    public WebElement addTeamMemberButton;

    @FindBy(how = How.XPATH, using = "//*[@class=\"sort-header-container__name-container__title\"]")
    public WebElement membersListNameHeader;

    @FindBy(how = How.XPATH, using = "//*[@class=\"sort-header-container__added-container__title\"]")
    public WebElement membersListAddedHeader;

    @FindBy(how = How.XPATH, using = "//*[@class=\"sort-header-container__email-container__title\"]")
    public WebElement membersListEmailHeader;

    @FindBy(how = How.XPATH, using = "//*[@class=\"checkbox\"]")
    public WebElement checkboxFirstUser;

    @FindBy(how = How.XPATH, using = "//*[@class=\"user-container__base-info__avatar extra-margin\"]")
    public WebElement avatarFirstMember;

    @FindBy(how = How.XPATH, using = "//*[@class=\"copy-button\"]")
    public WebElement membersPaginator;

    @FindBy(how = How.XPATH, using = "//*[@class=\"user-container__base-info__name-area__user-name\"]")
    public WebElement firstUserInfo;

    @FindBy(how = How.XPATH, using = "//*[@class=\"user-container__base-info__name-area__owner-status\"]")
    public WebElement ownerUserStatus;

    @FindBy(how = How.XPATH, using = "//*[@class=\"user-container__date\"]")
    public WebElement firstUserAddedDate;

    @FindBy(how = How.XPATH, using = "//*[@class=\"user-container__user-email\"]")
    public WebElement firstUserEmail;

    @FindBy(how = How.XPATH, using = "//*[@class=\"common-search-input\"]")
    public WebElement searchUserButton;


/// ADD TEAM MEMBER  POP-UP WINDOW

    @FindBy(how = How.XPATH, using = "//*[@class=\"add-user__info-panel-container__main-label-text\"]")
    public WebElement addTeamMemberHeader;
    @FindBy(how = How.CSS, using = "#addTeamMemberPopup > div.add-user__main > div.add-user__info-panel-container > img")
    public WebElement addTeamMemberLogo;
    @FindBy(how = How.XPATH, using = "//*[@class=\"add-user__form-container__common-label\"]")
    public WebElement addTeamMemberTableHeader;
    @FindBy(how = How.XPATH, using = "//*[@class=\"add-user__form-container__inputs-group\"]")
    public WebElement addTeamMemberList;
    @FindBy(how = How.XPATH, using = "//*[@class=\"no-error-input\"]")
    public WebElement addTeamMemberInput;
    @FindBy(how = How.XPATH, using = "//*[@class=\"delete-input-svg-path\"]")
    public WebElement deleteFirstTeamMemberFromAddingListButton;
    @FindBy(how = How.XPATH, using = "//*[@class=\"common-search-input\"]")
    public WebElement addMoreTeamMemberFieldIcon;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addUserButton\"]")
    public WebElement addMoreTeamMemberButton;
    @FindBy(how = How.XPATH, using = "//*[@class=\"container white\"]")
    public WebElement addTeamMemberCancel;
    @FindBy(how = How.XPATH, using = "//*[@class=\"container\"]")
    public WebElement addTeamMemberADD;
    @FindBy(how = How.XPATH, using = "//*[@class=\"add-user__close-cross-container\"]")
    public WebElement addTeamMemberClose;
    @FindBy(how = How.XPATH, using = "//*[@class=\"notification-wrap__text-area__text\"]")
    public WebElement addTeamMemberNotification;
    @FindBy(how = How.XPATH, using = "//*[@class=\"add-user__form-container__label__error\"]")
    public WebElement addTeamMemberWrongEmailError;
    @FindBy(how = How.XPATH, using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement addTeamMemberNotificationEmailError;



    /// DELETE TEAM MEMBER

    @FindBy(how = How.XPATH, using = "//*[@class=\"button deletion container\"]")
    public WebElement deleteTeamMemberButton;
    @FindBy(how = How.XPATH, using = "//*[@class=\"button deletion container\"]")
    public WebElement deleteTeamMemberButtonConfirm;

    @FindBy(how = How.XPATH, using = "//*[@class=\"button container white\"]")
    public WebElement cancelDeletingTeamMemberButton;
    @FindBy(how = How.XPATH, using = "//*[@class=\"button container white\"]")
    public WebElement cancelDeletingTeamMemberButtonConfirm;
    @FindBy(how = How.XPATH, using = "//*[@class=\"header-selected-members__info-text\"]")
    public WebElement selectedMembersForDeletion;
    @FindBy(how = How.XPATH, using = "//*[@class=\"header-after-delete-click__delete-confirmation\"]")
    public WebElement deleteTeamMemberConfirmNotification;
    @FindBy(how = How.XPATH, using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement deleteTeamMemberNotificationError;

    public TeamTab(WebDriver driver) {
        this.driver = driver;
    }

}
