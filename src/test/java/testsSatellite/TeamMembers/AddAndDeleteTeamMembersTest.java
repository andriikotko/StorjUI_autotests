package testsSatellite.TeamMembers;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Flows.NewProjectFlow;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.TeamTab;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddAndDeleteTeamMembersTest {
    static WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @BeforeMethod
    public void setUp() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      //  driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);

        Thread.sleep(1000);

        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, pages.LoginPage.class);
        TeamTab TeamTab = PageFactory.initElements(driver, pages.Tabs.TeamTab.class);
        NewProjectFlow newProjectFlow = PageFactory.initElements(driver, NewProjectFlow.class);
        // Once both classes Initialised, use their Web Element Objects
        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();

        Thread.sleep(4000);
        HomePage.team_tab.click();
    }
    @Test(priority = 0)
    public void AddTeamMemberPositiveTest() {
        TeamTab teamTab = PageFactory.initElements(driver, pages.Tabs.TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        teamTab.addTeamMemberButton.click();
        teamTab.addTeamMemberInput.sendKeys("test2@g.com");
        teamTab.addTeamMemberADD.click();

       // Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(teamTab.addTeamMemberNotificationEmailError));
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        Assert.assertEquals(teamTab.addTeamMemberNotificationEmailError.getText(), "Members successfully added to project!");
        Assert.assertEquals(list2.size(), (list1.size()+1));
    }

    @Test(priority = 2)
    public void deleteTeamMemberTest() throws InterruptedException {
        TeamTab teamTab = PageFactory.initElements(driver, pages.Tabs.TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        driver.findElement(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[2]")).click();
        teamTab.deleteTeamMemberButton.click();
        Assert.assertTrue(teamTab.deleteTeamMemberConfirmNotification.getText().startsWith("Are you sure you want to delete"));
        Thread.sleep(2000);
        teamTab.deleteTeamMemberButtonConfirm.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(teamTab.deleteTeamMemberNotificationError));
        Assert.assertEquals(teamTab.deleteTeamMemberNotificationError.getText(), "Members was successfully removed from project");
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        Assert.assertEquals(list2.size(), (list1.size()-1));

    }


    @Test(priority = 3)
    public void wrongNewMemberErrorTextTest (){
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        teamTab.addTeamMemberButton.click();
        teamTab.addTeamMemberInput.sendKeys("asdf@dfg");
        teamTab.addTeamMemberADD.click();

        Assert.assertEquals(teamTab.addTeamMemberWrongEmailError.getText(), "Field is required. Please enter a valid email address");
    }

    @Test(priority = 3)
    public void wrongNewMemberNotificationErrorTextTest (){
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        teamTab.addTeamMemberButton.click();
        teamTab.addTeamMemberInput.sendKeys("asdf@dfg.dfgh");
        teamTab.addTeamMemberADD.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(teamTab.addTeamMemberNotificationEmailError));

        Assert.assertEquals(teamTab.addTeamMemberNotificationEmailError.getText(), "Error during adding project members. There is no account on this Satellite for the user(s) you have entered. Please add team members with active accounts");
    }

    @Test(priority = 3)
    public  void deleteTeamMemberElementsTextsTest () throws InterruptedException {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        teamTab.checkboxFirstUser.click();
        teamTab.deleteTeamMemberButton.click();

        Assert.assertEquals(teamTab.deleteTeamMemberButtonConfirm.getText(), "Delete");
        Thread.sleep(1000);
        Assert.assertEquals(teamTab.cancelDeletingTeamMemberButtonConfirm.getText(), "Cancel");
    }

    @Test(priority = 3)
    public  void deleteTeamMemberConfirmationTextsTest (){
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        teamTab.checkboxFirstUser.click();
        teamTab.addTeamMemberButton.click();

        Assert.assertTrue(teamTab.deleteTeamMemberConfirmNotification.getText().startsWith("Are you sure you want to delete"));
    }

    @Test(priority = 3)
    public  void deleteOwnerTest () throws InterruptedException {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        teamTab.checkboxFirstUser.click();

        WebDriverWait wait = new WebDriverWait(driver,10);

        teamTab.deleteTeamMemberButton.click();
        Thread.sleep(1000);
        teamTab.deleteTeamMemberButtonConfirm.click();

        // WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(teamTab.deleteTeamMemberNotificationError));

        Assert.assertEquals(teamTab.deleteTeamMemberNotificationError.getText(), "Error while deleting users from projectMembers. test1@g.com is a project owner and can not be deleted");
    }

    @Test(priority = 3)
    public void AddTeamMemberCancelButtonTest() {
        TeamTab teamTab = PageFactory.initElements(driver, pages.Tabs.TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        teamTab.addTeamMemberButton.click();
        teamTab.addTeamMemberInput.sendKeys("test2@g.com");
        teamTab.addTeamMemberCancel.click();
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));

        Assert.assertEquals(list1,list2);
    }

    @Test(priority = 1)
    public void deleteTeamMemberCancelButtonTest() throws InterruptedException {
        TeamTab teamTab = PageFactory.initElements(driver, pages.Tabs.TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        driver.findElement(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[2]")).click();
        teamTab.deleteTeamMemberButton.click();
        Assert.assertTrue(teamTab.deleteTeamMemberConfirmNotification.getText().startsWith("Are you sure you want to delete"));
        Thread.sleep(2000);
        teamTab.cancelDeletingTeamMemberButtonConfirm.click();
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));

        Assert.assertEquals(list1,list2);
    }




}