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
import pages.Tabs.TeamTab;

import java.util.concurrent.TimeUnit;

public class TeamTabElementsTextsTest {
    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")){
            chosingOS = "";
        }
        if (OS.substring(0,4).equals("Windo")){
            chosingOS = ".exe";
        }
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH+chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH+chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH+chosingOS);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
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
