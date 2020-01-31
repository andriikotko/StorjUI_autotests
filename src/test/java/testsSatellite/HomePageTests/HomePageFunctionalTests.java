package testsSatellite.HomePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ConnectionToPostgres;
import pages.Flows.NewProjectFlow;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageFunctionalTests {

    WebDriver driver;

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

        Thread.sleep(3000);
        // This is to Instantiate Home Page and LogIn Page class
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        // Once both classes Initialised, use their Web Element Objects
        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);
    }

    @Test
    public void hideResoursesButtonWorkTest() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        List<WebElement> list1 = new ArrayList<>(driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/a")));
        Actions action = new Actions(driver);
        action.moveToElement(homePage.resoursesContainer).click().perform();
        // Thread.sleep(3000);
        action.moveToElement(homePage.resoursesHide_Show).click().perform();
        //Thread.sleep(3000);
        Assert.assertEquals(homePage.resoursesHide_Show.getText(), "Show");
        List<WebElement> list2 = new ArrayList<>(driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/a")));
        Assert.assertEquals(list1.size(), list2.size() + 2);
    }

    @Test
    public void hideAccountButtonWorkTest() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        List<WebElement> list1 = new ArrayList<>(driver.findElements(By.xpath("//*[@class=\"navigation-area__account-area\"]/a")));
        Actions action = new Actions(driver);
        action.moveToElement(homePage.accountContainer).click().perform();
        // Thread.sleep(3000);
        action.moveToElement(homePage.accountHide_Show).click().perform();
        //Thread.sleep(3000);
        Assert.assertEquals(homePage.accountHide_Show.getText(), "Show");
        List<WebElement> list2 = new ArrayList<>(driver.findElements(By.xpath("//*[@class=\"navigation-area__account-area\"]/a")));
        Assert.assertEquals(list1.size(), list2.size() + 2);
    }

    @Test
    public void accountSettingsDropdownWork() throws Exception {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.toggleAccount_DropDown.click();

        homePage.account_Settings.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:" + (homePage.satellitePort()) + "/account/profile");

        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:" + (homePage.satellitePort()) + "/login");
    }

    @Test
    public void switchingBetweenPages() throws IOException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.team_tab.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:" + (homePage.satellitePort()) + "/project-members");
        homePage.API_Keys_Tab.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:" + (homePage.satellitePort()) + "/api-keys");
        homePage.buckets.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:" + (homePage.satellitePort()) + "/buckets");
        homePage.profileTab.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:" + (homePage.satellitePort()) + "/account/profile");
        homePage.billingTab.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:" + (homePage.satellitePort()) + "/account/billing");
    }

    @Test
    public void switchToDocsTest() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.docs_Tab.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), "https://documentation.tardigrade.io/setup/buckets-objects");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"__GITBOOK__ROOT__CLIENT__\"]/div[1]/div[2]/div/div[1]/div[3]/div/div[1]/div[1]/div[1]/div/div/div[1]/div[1]/h1/span")).getText(), "Buckets & Objects");
    }

    @Test
    public void referenceToSupport() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.support_Tab.getAttribute("href").startsWith("mailto:support@storj.io"));
    }

    @Test
    public void moreThanProjectLimitCreation() throws InterruptedException {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        ConnectionToPostgres sql = PageFactory.initElements(driver,ConnectionToPostgres.class);
        NewProjectFlow newProjectFlow= PageFactory.initElements(driver, NewProjectFlow.class);
        homePage.createUserWithProjectLimit_1();
        sql.connectionToPostgres("UPDATE users SET Status = 1","status");
        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.userNameField.sendKeys("test101@g.com");
        loginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        loginPage.btn_Login.click();
        Thread.sleep(4500);
        WebDriverWait wait = new WebDriverWait(driver,10);

        if (homePage.currentProjectName.getText().contentEquals("You have no projects")){
            homePage.btn_New_Project.click();
            newProjectFlow.project_Name_input.sendKeys("TestProject");
            newProjectFlow.project_Description_input.sendKeys("TestDescription");
            newProjectFlow.create_Project_Button.click();
            newProjectFlow.close_cross_button_on_Congrats.click();

            homePage.btn_New_Project.click();
            newProjectFlow.project_Name_input.sendKeys("TestProject1");
            newProjectFlow.project_Description_input.sendKeys("TestDescription1");
            newProjectFlow.create_Project_Button.click();

        } else {

            homePage.btn_New_Project.click();
            newProjectFlow.project_Name_input.sendKeys("TestProject");
            newProjectFlow.project_Description_input.sendKeys("TestDescription");

            newProjectFlow.create_Project_Button.click();

        }
        wait.until(ExpectedConditions.visibilityOf(homePage.Error_Notification));
        Assert.assertEquals(homePage.Error_Notification.getText(), "Sorry, during the Pioneer release you have a limited number of projects");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
