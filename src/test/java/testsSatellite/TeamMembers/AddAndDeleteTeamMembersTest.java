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
import pages.Flows.NewProjectFlow;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.TeamTab;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddAndDeleteTeamMembersTest {
    static WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
        homePage.team_tab.click();
    }
    @Test(priority = 0)
    public void AddTeamMemberPositiveTest() {
        TeamTab teamTab = PageFactory.initElements(driver, pages.Tabs.TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));
        teamTab.addTeamMemberButton.click();
        teamTab.addMoreTeamMemberButton.click();
        List<WebElement> list3 = driver.findElements(By.xpath("//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/div[1]/div"));
        for (int i = 0; i <4 ; i++) {
            list3.get(i).findElement(By.xpath("//*[@id=\"addTeamMemberPopup\"]/div[1]/div[2]/div[1]/div["+(i+1)+"]/input")).sendKeys("test"+(i+2)+"@g.com");
        }
       // teamTab.addTeamMemberInput.sendKeys("test2@g.com");
        teamTab.addTeamMemberADD.click();

       // Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(teamTab.addTeamMemberNotificationEmailError));
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));
        Assert.assertEquals(teamTab.addTeamMemberNotificationEmailError.getText(), "Members successfully added to project!");
        Assert.assertEquals(list2.size(), (list1.size()+4));
    }

    @Test(priority = 2)
    public void deleteTeamMemberTest() throws InterruptedException {
        TeamTab teamTab = PageFactory.initElements(driver, pages.Tabs.TeamTab.class);
        //List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));
      //  List<WebElement> ifOwnerChecking = driver.
        List<WebElement> ifOwnerChecking = list1.get(0).findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[1]/div/div[2]/p"));
        if (ifOwnerChecking.size() != 2){
            //driver.findElement(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[2]")).click();
           list1.get(0).click();
        } else{list1.get(1).click();}

        teamTab.deleteTeamMemberButton.click();
        Assert.assertTrue(teamTab.deleteTeamMemberConfirmNotification.getText().startsWith("Are you sure you want to delete"));
        Thread.sleep(2000);
        teamTab.deleteTeamMemberButtonConfirm.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(teamTab.deleteTeamMemberNotificationError));
        Assert.assertEquals(teamTab.deleteTeamMemberNotificationError.getText(), "Members were successfully removed from project");
       // List<WebElement> list2 = driver.findElements(By.xpath("//*[@class=\"user-container item-component__item\"]"));
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));
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

        Assert.
                assertEquals(teamTab.addTeamMemberNotificationEmailError.getText(), "Error during adding project members. There is no account on this Satellite for the user(s) you have entered. Please add team members with active accounts");
    }

    @Test(priority = 3)
    public  void deleteTeamMemberElementsTextsTest () throws InterruptedException {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));
        //List<WebElement> ifOwnerChecking = list1.get(0).findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[1]/div/div[2]/p"));
        List<WebElement> ifOwnerChecking = list1.get(0).findElements(By.tagName("p"));
        System.out.println(ifOwnerChecking.size());
        if (ifOwnerChecking.size() != 4) {
            list1.get(0).click();
        } else {
            list1.get(1).click();
        }
        teamTab.deleteTeamMemberButton.click();

        Assert.assertEquals(teamTab.deleteTeamMemberButtonConfirm.getText(), "Delete");
        Thread.sleep(1000);
        Assert.assertEquals(teamTab.cancelDeletingTeamMemberButtonConfirm.getText(), "Cancel");
    }

    @Test(priority = 3)
    public  void deleteTeamMemberConfirmationTextsTest (){
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));
        List<WebElement> ifOwnerChecking = list1.get(0).findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[1]/div/div[2]/p"));
        if (ifOwnerChecking.size() != 2) {
            list1.get(0).click();
        } else {
            list1.get(1).click();
        }
        teamTab.deleteTeamMemberButton.click();

        Assert.assertTrue(teamTab.deleteTeamMemberConfirmNotification.getText().startsWith("Are you sure you want to delete"));
    }
    @Ignore // checkbox is hided
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
    public  void deleteOwnerTest1 () throws InterruptedException {
        TeamTab teamTab = PageFactory.initElements(driver, TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));



        for (WebElement webElement : list1) {
            int i = 0;
            List<WebElement> ifOwnerChecking = list1.get(i).findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[1]/div/div[2]/p"));

            if (ifOwnerChecking.size() == 2) {
                list1.get(i).click();
                break;
            }
            i++;
        }

        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div/div")).getText(), "+ Add");
    }

    @Test(priority = 3)
    public void AddTeamMemberCancelButtonTest() {
        TeamTab teamTab = PageFactory.initElements(driver, pages.Tabs.TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));
        teamTab.addTeamMemberButton.click();
        teamTab.addTeamMemberInput.sendKeys("test2@g.com");
        teamTab.addTeamMemberCancel.click();
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));

        Assert.assertEquals(list1,list2);
    }

    @Test(priority = 1)
    public void deleteTeamMemberCancelButtonTest() throws InterruptedException {
        TeamTab teamTab = PageFactory.initElements(driver, pages.Tabs.TeamTab.class);
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));
        driver.findElement(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div[2]")).click();
        teamTab.deleteTeamMemberButton.click();
        Assert.assertTrue(teamTab.deleteTeamMemberConfirmNotification.getText().startsWith("Are you sure you want to delete"));
        Thread.sleep(2000);
        teamTab.cancelDeletingTeamMemberButtonConfirm.click();
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@id=\"team-container\"]/div[2]/div/div"));

        Assert.assertEquals(list1,list2);
    }




}