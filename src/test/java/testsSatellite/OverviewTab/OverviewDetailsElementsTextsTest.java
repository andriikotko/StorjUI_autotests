package testsSatellite.OverviewTab;

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
import pages.Tabs.OverviewTab_Details;

import java.util.concurrent.TimeUnit;

public class OverviewDetailsElementsTextsTest {

    public WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.overview_tab.click();



    }
    @Test
    public void overviewDetailsElementsTextsTest (){

        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);

        Assert.assertEquals(overviewTabDetails.headerProjectDetails.getText(), "Project Details");
        Assert.assertEquals(overviewTabDetails.deleteProjectButton.getText(), "Delete Project");
        Assert.assertEquals(overviewTabDetails.detailsTab.getText(), "Details");
        Assert.assertEquals(overviewTabDetails.reportTab.getText(), "Report");
        Assert.assertEquals(overviewTabDetails.projectNameHeader.getText(), "Project Name");
        Assert.assertEquals(overviewTabDetails.descriptionHeader.getText(), "Description");}

    @Test
    public void deleteProjectDialogElementsTextsTest (){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.deleteProjectButton.click();

        Assert.assertEquals(overviewTabDetails.deleteProjectDialogHeader.getText(), "Delete Project");
        Assert.assertEquals(overviewTabDetails.deleteProjectDialogQuestion.getText(), "Are you sure that you want to delete your project? You will lose all your buckets and files that linked to this project.");
        Assert.assertEquals(overviewTabDetails.deleteProjectDialogConfirmNotification.getText(), "To confirm, enter the project name");
        Assert.assertTrue(overviewTabDetails.deleteProjectDialogInputField.getAttribute("placeholder").contains("Enter Project Name"));
        Assert.assertEquals(overviewTabDetails.deleteProjectDialogCancelButton.getText(), "Cancel");
        Assert.assertEquals(overviewTabDetails.deleteProjectDialogDeleteButton.getText(), "Delete");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
