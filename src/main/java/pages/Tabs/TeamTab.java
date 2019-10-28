package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TeamTab {
    final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/h1")
    public WebElement projectMembersHeader;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div/span")
    public WebElement projectRoleNotification;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div/div")
    public WebElement addTeamMemberButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[1]/div[1]/p")
    public WebElement membersListNameHeader;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[1]/div[2]/p")
    public WebElement membersListAddedHeader;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[1]/div[3]/p")
    public WebElement membersListEmailHeader;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[2]/div/div/div/div[1]")
    public WebElement checkboxFirstUser;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[2]/div/div/div/div[2]")
    public WebElement avatarFirstMember;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[3]/div")
    public WebElement membersPaginator;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[2]/div/div[1]/div/div[2]/p[1]")
    public WebElement firstUserInfo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[2]/div/div[2]/div/div[1]")
    public WebElement secondUserCheckbox;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[2]/div/div/p[1]")
    public WebElement firstUserAddedDate;

    @FindBy(how = How.XPATH, using = "//*[@id=\"team-container\"]/div[2]/div/div/p[2]")
    public WebElement firstUserEmail;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div/input")
    public WebElement searchUserButton;


/// ADD TEAM MEMBER  POP-UP WINDOW

    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[1]/h2")
    public WebElement addTeamMemberHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/div[1]/div[1]/input")
    public WebElement addTeamMemberLogo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/p")
    public WebElement addTeamMemberTableHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/div[1]")
    public WebElement addTeamMemberList;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/div[1]/div[1]/input")
    public WebElement addTeamMemberInput;
    @FindBy(how = How.CSS, using = "#addTeamMemberPopup > div.add-user__main > div.add-user__form-container > div.add-user__form-container__inputs-group > div:nth-child(1) > svg > path")
    public WebElement deleteFirstTeamMemberFromAddingListButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/div[1]/div[1]/input")
    public WebElement addMoreTeamMemberFieldIcon;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addUserButton\"]")
    public WebElement addMoreTeamMemberButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/div[3]/div[1]")
    public WebElement addTeamMemberCancel;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/div[3]/div[2]")
    public WebElement addTeamMemberADD;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[3]")
    public WebElement addTeamMemberClose;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[2]/div/p")
    public WebElement addTeamMemberNotification;
    @FindBy(how = How.XPATH, using = "//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/div[1]/p")
    public WebElement addTeamMemberWrongEmailError;
    @FindBy(how = How.XPATH, using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement addTeamMemberNotificationEmailError;



    /// DELETE TEAM MEMBER

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div/div[1]")
    public WebElement deleteTeamMemberButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div/div/div[1]")
    public WebElement deleteTeamMemberButtonConfirm;

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div/div[2]")
    public WebElement cancelDeletingTeamMemberButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div/div/div[2]")
    public WebElement cancelDeletingTeamMemberButtonConfirm;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div/span")
    public WebElement deleteTeamMemberConfirmNotification;
    @FindBy(how = How.XPATH, using = "//*[@id=\"notificationArea\"]/div/div[1]/p")
    public WebElement deleteTeamMemberNotificationError;

    public TeamTab(WebDriver driver) {
        this.driver = driver;
    }

}
