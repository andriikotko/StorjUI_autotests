package testsSatellite.TeamMembers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.TeamTab;

import java.util.concurrent.TimeUnit;

public class TeamTabElementsTextsTest {
    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
        homePage.team_tab.click();

    }

    @Test
    public void teamTabElementsTextsTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);

        Assert.assertEquals(teamTab.projectMembersHeader.getText(), "Project Members");
      //  Assert.assertTrue(teamTab.projectRoleHintText.getText().startsWith("The only project role currently available is Admin, which gives"));
        Assert.assertEquals(teamTab.addTeamMemberButton.getText(), "+ Add");
        Assert.assertEquals(teamTab.membersListNameHeader.getText(), "Name");
        Assert.assertEquals(teamTab.membersListAddedHeader.getText(), "Added");
        Assert.assertEquals(teamTab.membersListEmailHeader.getText(), "Email");

        Assert.assertTrue(teamTab.searchUserButton.getAttribute("placeholder").startsWith("Search Team Members"));
    }

    @Test
    public void addTeamMemberPopUpElementsVisibilityTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        teamTab.addTeamMemberButton.click();

        Assert.assertEquals(teamTab.addTeamMemberHeader.getText(), "Add Team Member");
        Assert.assertEquals(teamTab.addTeamMemberTableHeader.getText(), "Email Address");
        Assert.assertTrue(teamTab.addTeamMemberInput.getAttribute("placeholder").startsWith("email@example.com"));
        Assert.assertEquals(teamTab.addMoreTeamMemberButton.getText(), "Add More");
        Assert.assertEquals(teamTab.addTeamMemberCancel.getText(), "Cancel");
       // Assert.assertEquals(teamTab.addTeamMemberADD.getText(), "Add Team Members");
        Assert.assertTrue(teamTab.addTeamMemberNotification.getText().startsWith("If the team member you want to invite to join the project is still not on this Satellite, please share this link to the signup page and ask them to register here"));

    }

    @Test
    public void teamTabHintTextsTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);

        Actions action = new Actions(driver);
        action.moveToElement(teamTab.projectRoleHint).click().perform();


        Assert.assertTrue(teamTab.projectRoleHintText.getText().startsWith("The only project role currently available is Admin, which gives"));}



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
