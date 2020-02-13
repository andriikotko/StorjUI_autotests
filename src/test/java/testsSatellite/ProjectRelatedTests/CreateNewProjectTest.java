package testsSatellite.ProjectRelatedTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
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

import java.util.concurrent.TimeUnit;

public class CreateNewProjectTest {
    static WebDriver driver;

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
    }

    @Test
    public void CreateNewProjectTest() throws InterruptedException {

        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, pages.LoginPage.class);
        NewProjectFlow newProjectFlow = PageFactory.initElements(driver, NewProjectFlow.class);
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

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(HomePage.Error_Notification));
        Assert.assertTrue(HomePage.Error_Notification.isEnabled());
        //    Assert.assertTrue(HomePage.Error_Notification.getText().endsWith("Project created successfully!"));
        Assert.assertEquals(HomePage.Error_Notification.getText(), "Project created successfully!");
        Thread.sleep(1000);

    }

    @Test
    public void firstProjectCreationFlow() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        NewProjectFlow newProjectFlow = PageFactory.initElements(driver, NewProjectFlow.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.userNameField.sendKeys("test11@g.com");
        loginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        loginPage.btn_Login.click();
        Thread.sleep(4500);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        if (homePage.currentProjectName.getText().contentEquals("You have no projects")) {
            homePage.btn_New_Project.click();
            newProjectFlow.project_Name_input.sendKeys("TestProject");
            newProjectFlow.project_Description_input.sendKeys("TestDescription");
            newProjectFlow.create_Project_Button.click();

            Assert.assertEquals(newProjectFlow.congratsHeader.getText(), "Congrats!");
            Assert.assertEquals(newProjectFlow.congratsText.getText(), "You just created your project. Next, we recommend you create your first API Key for this project. API Keys allow developers to manage their projects and build applications on top of the Storj network through our Uplink CLI.");
            Assert.assertEquals(newProjectFlow.congratsLaterButton.getText(), "I will do it later");
            Assert.assertEquals(newProjectFlow.congratsAPICreateButton.getText(), "Create first API Key");
            Assert.assertTrue(newProjectFlow.congratsImage.isDisplayed());
            Assert.assertTrue(newProjectFlow.close_cross_button_on_Congrats.isDisplayed());

            newProjectFlow.congratsAPICreateButton.click();

            Assert.assertTrue(driver.getCurrentUrl().endsWith("/api-keys"));

        }
        else {
            System.out.println("this user already  have created projects");
        }
        }


    }
