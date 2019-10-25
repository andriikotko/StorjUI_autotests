package testsSatellite.ProjectRelatedTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Flows.NewProjectFlow;
import pages.HomePage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class CreateNewProjectTest {
    static WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}
    @Test
   public void CreateNewProjectTest () throws InterruptedException {


        System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);

        Thread.sleep(4000);

        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, pages.LoginPage.class);
        NewProjectFlow newProjectFlow= PageFactory.initElements(driver, NewProjectFlow.class);
        // Once both classes Initialised, use their Web Element Objects
        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();

        Thread.sleep(5000);

        HomePage.btn_New_Project.click();
        newProjectFlow.project_Name_input.sendKeys("TestProject");
        newProjectFlow.project_Description_input.sendKeys("TestDescription");
        newProjectFlow.create_Project_Button.click();
       // Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(HomePage.Error_Notification));
        Assert.assertTrue(HomePage.Error_Notification.isEnabled());
    //    Assert.assertTrue(HomePage.Error_Notification.getText().endsWith("Project created successfully!"));
        Assert.assertEquals(HomePage.Error_Notification.getText(), "Project created successfully!");
         Thread.sleep(1000);

    }

}
