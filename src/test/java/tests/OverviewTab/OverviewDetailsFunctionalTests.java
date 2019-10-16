package tests.OverviewTab;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.OverviewTab_Details;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OverviewDetailsFunctionalTests {
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
    @Ignore
    @Test
    public void deleteProjectEmptyFieldTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.deleteProjectButton.click();

        Assert.assertFalse(overviewTabDetails.deleteProjectDialogConfirmNotification.isEnabled());
    }

    @Test
    public void deleteProjectWrongNameTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.deleteProjectButton.click();

        overviewTabDetails.deleteProjectDialogInputField.sendKeys("Wrong Project");
        overviewTabDetails.deleteProjectDialogDeleteButton.click();

        Assert.assertEquals(overviewTabDetails.deleteProjectDialogErrorMessage.getText(), "Name doesn't match with current project name");
    }

    @Test
    public void deleteProjectElseProjectNameTest(){
        OverviewTab_Details overviewTabDetails = PageFactory.initElements(driver, OverviewTab_Details.class);
        overviewTabDetails.deleteProjectButton.click();

        overviewTabDetails.deleteProjectDialogInputField.sendKeys("Test Project");
        overviewTabDetails.deleteProjectDialogDeleteButton.click();

        Assert.assertEquals(overviewTabDetails.deleteProjectDialogErrorMessage.getText(), "Name doesn't match with current project name");
    }


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
