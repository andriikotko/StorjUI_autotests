package testsSatellite.OverviewTab;

import org.openqa.selenium.By;
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

public class OverviewDetailsFunctionalTests {
    public WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);

    }

    @Test
    public void editDescriptionTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.editDescriptionButton.click();

        overviewTabDetails.editDescriptionText.sendKeys("sdfgdsfg");
        overviewTabDetails.editDescriptionSaveButton.click();

        Assert.assertEquals(overviewTabDetails.currentProjectDescription.getText(),"sdfgdsfg");
    }

    @Test
    public void editDescriptionDeleteTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.editDescriptionButton.click();

        overviewTabDetails.editDescriptionText.clear();
        overviewTabDetails.editDescriptionSaveButton.click();

        Assert.assertEquals(overviewTabDetails.currentProjectDescription.getText(),"No description yet. Please enter some information about the project if any.");
    }

    @Test
    public void editDescriptionCancelTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        String previousDescription = overviewTabDetails.currentProjectDescription.getText();
        overviewTabDetails.editDescriptionButton.click();

        overviewTabDetails.editDescriptionText.sendKeys("sdfgdsfg");
        overviewTabDetails.editDescriptionCancelButton.click();

        Assert.assertEquals(overviewTabDetails.currentProjectDescription.getText(),previousDescription);
    }

    @Test
    public void editDescriptionSaveWithoutChangesTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        String previousDescription = overviewTabDetails.currentProjectDescription.getText();
        overviewTabDetails.editDescriptionButton.click();

        overviewTabDetails.editDescriptionSaveButton.click();

        Assert.assertEquals(overviewTabDetails.currentProjectDescription.getText(),previousDescription);
    }
    @Ignore  // TEMPORARY
    @Test
    public void deleteProjectEmptyFieldTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.deleteProjectButton.click();

        Assert.assertFalse(overviewTabDetails.deleteProjectDialogConfirmNotification.isEnabled());
    }
    @Ignore  //TEMPORARY
    @Test
    public void deleteProjectWrongNameTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.deleteProjectButton.click();

        overviewTabDetails.deleteProjectDialogInputField.sendKeys("Wrong Project");
        overviewTabDetails.deleteProjectDialogDeleteButton.click();

        Assert.assertEquals(overviewTabDetails.deleteProjectDialogErrorMessage.getText(), "Name doesn't match with current project name");
    }
    @Ignore  //TEMPORARY
    @Test
    public void deleteProjectElseProjectNameTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.deleteProjectButton.click();

        overviewTabDetails.deleteProjectDialogInputField.sendKeys("Test Project");
        overviewTabDetails.deleteProjectDialogDeleteButton.click();

        Assert.assertEquals(overviewTabDetails.deleteProjectDialogErrorMessage.getText(), "Name doesn't match with current project name");
    }

    @Ignore  //TEMPORARY
    @Test
    public void deleteProjectCancelButtonTest() throws InterruptedException {
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);

        String currentProjectName1 = overviewTabDetails.currentProjectName.getText();

        overviewTabDetails.deleteProjectButton.click();

        overviewTabDetails.deleteProjectDialogInputField.sendKeys("Test Project");
        overviewTabDetails.deleteProjectDialogCancelButton.click();

        Assert.assertEquals(overviewTabDetails.currentProjectName.getText(), currentProjectName1);
    }



    @Ignore
    @Test
    public void deleteProjectWrongNameTest1() throws InterruptedException {
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        //HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Thread.sleep(4000);
        String currentProjectName1 = overviewTabDetails.currentProjectName.getText();
        overviewTabDetails.project_dropDown.click();
        Thread.sleep(2000);
//        List<WebElement> list = driver.findElements(By.xpath("//*[@class=\"project-selection-overflow-container__project-choice\"]/h2"));
//        int len = list.size();
//        System.out.println(list.size());
        driver.findElement(By.xpath("//*[@id=\"projectDropdown\"]/div/div/h2[text()=\"TestProject\"]")).click();
        String projectNameAfterDeleting = overviewTabDetails.currentProjectName.getText();

        Assert.assertEquals(projectNameAfterDeleting, currentProjectName1);





//        List<WebElement> list = driver.findElements(By.xpath("//*[@class=\"project-selection-overflow-container__project-choice\"]/h2"));
//        System.out.println(list.size());
//        List<WebElement> list1;
//        System.out.println(list.get(4).getText());

    }







    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
