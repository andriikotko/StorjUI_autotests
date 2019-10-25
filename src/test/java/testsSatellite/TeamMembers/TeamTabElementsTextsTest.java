package testsSatellite.TeamMembers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.TeamTab;

import java.util.concurrent.TimeUnit;

public class TeamTabElementsTextsTest {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.team_tab.click();

    }

    @Test
    public void teamTabElementsTextsTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);

        Assert.assertEquals(teamTab.projectMembersHeader.getText(), "Project Members");
        Assert.assertTrue(teamTab.projectRoleNotification.getText().startsWith("The only project role currently available is Admin, which gives"));
        Assert.assertEquals(teamTab.addTeamMemberButton.getText(), "+Add");
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
        Assert.assertEquals(teamTab.addTeamMemberADD.getText(), "Add Team Members");
        Assert.assertTrue(teamTab.addTeamMemberNotification.getText().startsWith("If the team member you want to invite to join the project is still not on this Satellite, please share this link to the signup page and ask them to register here"));

    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
