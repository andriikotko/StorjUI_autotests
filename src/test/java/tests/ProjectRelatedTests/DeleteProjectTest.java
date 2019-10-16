package tests.ProjectRelatedTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.OverviewTab_Details;

import java.util.concurrent.TimeUnit;

public class DeleteProjectTest {
    static WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @Ignore
    @Test(priority = 16)
    public void DeleteProjectTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);

        Thread.sleep(4000);

        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, pages.LoginPage.class);
        OverviewTab_Details OverviewTab_Details = PageFactory.initElements(driver, OverviewTab_Details.class);
        // Once both classes Initialised, use their Web Element Objects
        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(5000);

        HomePage.project_dropDown.click();
        HomePage.testsProjectList.click();
        OverviewTab_Details.deleteProjectButton.click();
        OverviewTab_Details.deleteProjectNameInput.sendKeys("TestProject");
        OverviewTab_Details.Confirm_Project_Delete_Button.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(HomePage.Error_Notification));
        Assert.assertEquals(HomePage.Error_Notification.getText(), "Project was successfully deleted");

    }
}
