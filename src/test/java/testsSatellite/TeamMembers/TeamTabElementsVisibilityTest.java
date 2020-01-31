package testsSatellite.TeamMembers;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.TeamTab;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TeamTabElementsVisibilityTest {


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
        //driver.manage().window().maximize();
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
    public void teamTabElementsVisibilityTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);

        Assert.assertTrue(teamTab.projectMembersHeader.isDisplayed());
        //   Assert.assertTrue(teamTab.projectRoleNotification.getText().startsWith("The only project role currently available is Admin, which gives"));
        Assert.assertTrue(teamTab.addTeamMemberButton.isDisplayed());
        Assert.assertTrue(teamTab.membersListNameHeader.isDisplayed());
        Assert.assertTrue(teamTab.membersListAddedHeader.isDisplayed());
        Assert.assertTrue(teamTab.membersListEmailHeader.isDisplayed());
//        Assert.assertTrue(teamTab.checkboxFirstUser.isDisplayed());
        Assert.assertTrue(teamTab.avatarFirstMember.isDisplayed());
        //  Assert.assertTrue(teamTab.membersPaginator.isDisplayed()); - should be shown then amount of members > 6
        Assert.assertTrue(teamTab.firstUserInfo.isDisplayed());
        Assert.assertTrue(teamTab.firstUserAddedDate.isDisplayed());
        Assert.assertTrue(teamTab.firstUserEmail.isDisplayed());
        Assert.assertTrue(teamTab.searchUserButton.isDisplayed());
    }

    @Test
    public void addTeamMemberPopUpElementsVisibilityTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        teamTab.addTeamMemberButton.click();

        Assert.assertTrue(teamTab.addTeamMemberHeader.isDisplayed());
        Assert.assertTrue(teamTab.addTeamMemberLogo.isDisplayed());
        Assert.assertTrue(teamTab.addTeamMemberTableHeader.isDisplayed());
        Assert.assertTrue(teamTab.addTeamMemberList.isDisplayed());
        Assert.assertTrue(teamTab.addTeamMemberInput.isDisplayed());
        Assert.assertTrue(teamTab.deleteFirstTeamMemberFromAddingListButton.isDisplayed());
        Assert.assertTrue(teamTab.addMoreTeamMemberFieldIcon.isDisplayed());
        Assert.assertTrue(teamTab.addMoreTeamMemberButton.isDisplayed());
        Assert.assertTrue(teamTab.addTeamMemberCancel.isDisplayed());
        Assert.assertTrue(teamTab.addTeamMemberADD.isDisplayed());
        Assert.assertTrue(teamTab.addTeamMemberClose.isDisplayed());
        Assert.assertTrue(teamTab.addTeamMemberNotification.isDisplayed());
        //    Assert.assertTrue(teamTab.addTeamMemberWrongEmailError.isDisplayed());
        //Assert.assertTrue(teamTab.addTeamMemberNotificationEmailError.isDisplayed());
    }

    @Test
    public void wrongNewMemberErrorVisibilityTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        teamTab.addTeamMemberButton.click();
        teamTab.addTeamMemberInput.sendKeys("asdf@dfg");
        teamTab.addTeamMemberADD.click();

        Assert.assertTrue(teamTab.addTeamMemberWrongEmailError.isDisplayed());
    }

    @Test
    public void wrongNewMemberNotificationErrorVisibilityTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        teamTab.addTeamMemberButton.click();
        teamTab.addTeamMemberInput.sendKeys("asdf@dfg.dfgh");
        teamTab.addTeamMemberADD.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(teamTab.addTeamMemberNotificationEmailError));

        Assert.assertTrue(teamTab.addTeamMemberNotificationEmailError.isDisplayed());
    }

    @Test(priority = 2)
    public void deleteTeamMemberElementsVisibilityTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        List<WebElement> ifOwnerChecking = list1.get(0).findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[1]/div/div[2]/p"));
        if (ifOwnerChecking.size() != 2) {
            list1.get(0).click();
        } else {
            list1.get(1).click();
        }

        Assert.assertTrue(teamTab.deleteTeamMemberButton.isDisplayed());
        Assert.assertTrue(teamTab.cancelDeletingTeamMemberButton.isDisplayed());
    }

    @Test(priority = 2)
    public void deleteTeamMemberConfirmVisibilityTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        List<WebElement> ifOwnerChecking = list1.get(0).findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[1]/div/div[2]/p"));
        if (ifOwnerChecking.size() != 2) {
            list1.get(0).click();
        } else {
            list1.get(1).click();
        }
        teamTab.deleteTeamMemberButton.click();

        Assert.assertTrue(teamTab.deleteTeamMemberButtonConfirm.isDisplayed());
        Assert.assertTrue(teamTab.cancelDeletingTeamMemberButtonConfirm.isDisplayed());
    }

    @Test(priority = 2)
    public void deleteTeamMemberConfirmationVisibilityTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        List<WebElement> ifOwnerChecking = list1.get(0).findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[1]/div/div[2]/p"));
        if (ifOwnerChecking.size() != 2) {
            list1.get(0).click();
        } else {
            list1.get(1).click();
        }
        teamTab.deleteTeamMemberButton.click();

        Assert.assertTrue(teamTab.deleteTeamMemberConfirmNotification.isDisplayed());
    }


    @Test(priority = 2)
    public void deleteTeamMemberNotificationErrorVisibilityTest() {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        List<WebElement> ifOwnerChecking = list1.get(0).findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[1]/div/div[2]/p"));
        if (ifOwnerChecking.size() != 2) {
            list1.get(0).click();
        } else {
            list1.get(1).click();
        }

        //teamTab.addTeamMemberButton.click();
        teamTab.deleteTeamMemberButton.click();
        teamTab.deleteTeamMemberButtonConfirm.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(teamTab.deleteTeamMemberNotificationError));

        Assert.assertTrue(teamTab.deleteTeamMemberNotificationError.isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
