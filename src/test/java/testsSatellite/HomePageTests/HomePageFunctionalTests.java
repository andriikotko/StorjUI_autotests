package testsSatellite.HomePageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageFunctionalTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
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
    public void hideResoursesButtonWorkTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        List<WebElement> list1 = new ArrayList<>(driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/a")));
        Actions action = new Actions(driver);
        action.moveToElement(homePage.resoursesContainer).click().perform();
       // Thread.sleep(3000);
        action.moveToElement(homePage.resoursesHide_Show).click().perform();
        //Thread.sleep(3000);
        Assert.assertEquals(homePage.resoursesHide_Show.getText(), "Show");
        List<WebElement> list2 = new ArrayList<>(driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[1]/div/a")));
        Assert.assertEquals(list1.size(), list2.size()+2);
    }

    @Test
    public void hideAccountButtonWorkTest()  {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        List<WebElement> list1 = new ArrayList<>(driver.findElements(By.xpath("//*[@class=\"navigation-area__account-area\"]/a")));
        Actions action = new Actions(driver);
        action.moveToElement(homePage.accountContainer).click().perform();
        // Thread.sleep(3000);
        action.moveToElement(homePage.accountHide_Show).click().perform();
        //Thread.sleep(3000);
        Assert.assertEquals(homePage.accountHide_Show.getText(), "Show");
        List<WebElement> list2 = new ArrayList<>(driver.findElements(By.xpath("//*[@class=\"navigation-area__account-area\"]/a")));
        Assert.assertEquals(list1.size(), list2.size()+2);
    }

    @Test
    public void accountSettingsDropdownWork() throws IOException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.toggleAccount_DropDown.click();

        homePage.account_Settings.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:"+ (homePage.satellitePort()) +"/account/profile");

        homePage.toggleAccount_DropDown.click();
        homePage.button_LogOut.click();

        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:"+ (homePage.satellitePort()) +"/login");
    }

    @Test
    public void switchingBetweenPages() throws IOException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.team_tab.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:"+ (homePage.satellitePort()) +"/project-members");
        homePage.API_Keys_Tab.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:"+ (homePage.satellitePort()) +"/api-keys");
        homePage.buckets.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:"+ (homePage.satellitePort()) +"/buckets");
        homePage.profileTab.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:"+ (homePage.satellitePort()) +"/account/profile");
        homePage.billingTab.click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:"+ (homePage.satellitePort()) +"/account/billing");
    }

    @Test
    public void switchToDocsTest (){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.docs_Tab.click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://github.com/storj/docs/blob/master/Vanguard-Release-Setup-Instructions.md");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"readme\"]/article/h1")).getText(),"Vanguard Alpha Release - Setup Instructions!");
    }

    @Test
    public void referenceToSupport(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        Assert.assertTrue(homePage.support_Tab.getAttribute("href").startsWith("mailto:support@storj.io"));
    }






    @AfterMethod
    public void tearDown()
    {driver.quit();}
}
