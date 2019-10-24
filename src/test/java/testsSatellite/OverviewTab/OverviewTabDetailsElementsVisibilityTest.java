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

public class OverviewTabDetailsElementsVisibilityTest {
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
    public void overviewTabDetailsElementsVisibilityTest (){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);

        Assert.assertTrue(overviewTabDetails.deleteProjectButton.isDisplayed());
        Assert.assertTrue(overviewTabDetails.headerProjectDetails.isDisplayed());
        Assert.assertTrue(overviewTabDetails.detailsTab.isDisplayed());
        Assert.assertTrue(overviewTabDetails.reportTab.isDisplayed());
        Assert.assertTrue(overviewTabDetails.projectNameHeader.isDisplayed());
        Assert.assertTrue(overviewTabDetails.currentProjectName.isDisplayed());
        Assert.assertTrue(overviewTabDetails.descriptionHeader.isDisplayed());
        Assert.assertTrue(overviewTabDetails.currentProjectDescription.isDisplayed());


    }

    @Test
    public void deleteProjectDialogElementsVisibility (){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);

        overviewTabDetails.deleteProjectButton.click();

        Assert.assertTrue(overviewTabDetails.deleteProjectDialogHeader.isDisplayed());
        Assert.assertTrue(overviewTabDetails.deleteProjectDialogQuestion.isDisplayed());
        Assert.assertTrue(overviewTabDetails.deleteProjectDialogConfirmNotification.isDisplayed());
        Assert.assertTrue(overviewTabDetails.deleteProjectDialogInputField.isDisplayed());
        Assert.assertTrue(overviewTabDetails.deleteProjectDialogCancelButton.isDisplayed());
        Assert.assertTrue(overviewTabDetails.deleteProjectDialogDeleteButton.isDisplayed());
      //  Assert.assertFalse(overviewTabDetails.deleteProjectDialogDeleteButton.isEnabled());
        Assert.assertTrue(overviewTabDetails.deleteProjectDialogCloseButton.isDisplayed());

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
