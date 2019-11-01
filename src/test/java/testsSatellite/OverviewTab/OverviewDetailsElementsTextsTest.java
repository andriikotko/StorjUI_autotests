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
import pages.Tabs.OverviewTab_Details;

import java.util.concurrent.TimeUnit;

public class OverviewDetailsElementsTextsTest {

    public WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

    @Ignore   // TEMPORARY
    @Test
    public void overviewDetailsElementsTextsTest (){

        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);

        Assert.assertEquals(overviewTabDetails.headerProjectDetails.getText(), "Project Details");
        Assert.assertEquals(overviewTabDetails.deleteProjectButton.getText(), "Delete Project");
        Assert.assertEquals(overviewTabDetails.detailsTab.getText(), "Details");
        Assert.assertEquals(overviewTabDetails.reportTab.getText(), "Report");
        Assert.assertEquals(overviewTabDetails.projectNameHeader.getText(), "Project Name");
        Assert.assertEquals(overviewTabDetails.descriptionHeader.getText(), "Description");}
    @Ignore  // TEMPORARY
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
