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

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")) {
            chosingOS = "";
        }
        if (OS.substring(0, 4).equals("Windo")) {
            chosingOS = ".exe";
        }
        //Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("Firefox")) {
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH + chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("Chrome")) {
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH + chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if (browser.equalsIgnoreCase("Opera")) {
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH + chosingOS);
            driver = new OperaDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);

        Thread.sleep(4000);
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
