package testsSatellite.OverviewTab;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.OverviewTab_Details;

import java.util.concurrent.TimeUnit;

public class OverviewTabDetailsElementsVisibilityTest {
    public WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
        homePage.overview_tab.click();

    }

    @Test
    public void overviewTabDetailsElementsVisibilityTest (){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);

    // TEMPORARY   Assert.assertTrue(overviewTabDetails.deleteProjectButton.isDisplayed());
        Assert.assertTrue(overviewTabDetails.headerProjectDetails.isDisplayed());
        Assert.assertTrue(overviewTabDetails.detailsTab.isDisplayed());
        Assert.assertTrue(overviewTabDetails.reportTab.isDisplayed());
        Assert.assertTrue(overviewTabDetails.projectNameHeader.isDisplayed());
        Assert.assertTrue(overviewTabDetails.currentProjectName.isDisplayed());
        Assert.assertTrue(overviewTabDetails.descriptionHeader.isDisplayed());
        Assert.assertTrue(overviewTabDetails.currentProjectDescription.isDisplayed());


    }
    @Ignore  //TEMPORARY
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
