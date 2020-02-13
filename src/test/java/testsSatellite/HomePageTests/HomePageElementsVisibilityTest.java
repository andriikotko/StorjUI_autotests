package testsSatellite.HomePageTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;

import java.util.concurrent.TimeUnit;

public class HomePageElementsVisibilityTest {
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
    public void homePageelementsVisibilityTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Assert.assertTrue(homePage.toggleAccount_DropDown.isDisplayed());
        Assert.assertTrue(homePage.btn_New_Project.isDisplayed());
        Assert.assertTrue(homePage.project_dropDown.isEnabled());
        Assert.assertTrue(homePage.storjLogo.isDisplayed());

        Assert.assertTrue(homePage.projectHeader.isDisplayed());
        Assert.assertTrue(homePage.accountHeader.isDisplayed());
        Assert.assertTrue(homePage.resourcesHeader.isDisplayed());


        Assert.assertTrue(homePage.overview_tab.isDisplayed());
        Assert.assertTrue(homePage.team_tab.isDisplayed());
        Assert.assertTrue(homePage.API_Keys_Tab.isDisplayed());
        Assert.assertTrue(homePage.buckets.isDisplayed());
        Assert.assertTrue(homePage.docs_Tab.isDisplayed());
        Assert.assertTrue(homePage.support_Tab.isDisplayed());
        Assert.assertTrue(homePage.profileTab.isDisplayed());
        Assert.assertTrue(homePage.billingTab.isDisplayed());
//        Assert.assertTrue(homePage.paymentMethodsTab.isDisplayed());  moved to Billing page

    }
    @Test
    public void hideResoursesButtonPresenceTest()  {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Actions action = new Actions(driver);
        action.moveToElement(homePage.resoursesContainer).click().perform();


        Assert.assertTrue(homePage.resoursesHide_Show.isDisplayed());
    }
    @Test
    public void hideAccountButtonPresenceTest(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Actions action = new Actions(driver);
        action.moveToElement(homePage.accountContainer).click().perform();

        Assert.assertTrue(homePage.accountHide_Show.isDisplayed());
    }
    @Test
    public void accountSettingsButtonPresenceTest (){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Actions action = new Actions(driver);
        action.moveToElement(homePage.toggleAccount_DropDown).click().perform();

        Assert.assertTrue(homePage.account_Settings.isDisplayed());
    }
    @Test
    public void accountLogOutButtonPresenceTest () {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Actions action = new Actions(driver);
        action.moveToElement(homePage.toggleAccount_DropDown).click().perform();


        Assert.assertTrue(homePage.button_LogOut.isDisplayed());
    }
    //@Ignore
    @Test
    public void projectsListpresenceeTest () throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        Actions action = new Actions(driver);
        Thread.sleep(3000);
        Assert.assertTrue(homePage.project_dropDown.isEnabled());
        action.moveToElement(homePage.project_dropDown).click().perform();
        Thread.sleep(1000);

//        List<WebElement> list = new ArrayList<>(driver.findElements(By.xpath("//*[@class=\"project-selection-overflow-container__project-choice\"]")));
//        System.out.println(list.size());


        Assert.assertTrue(homePage.testsProjectList.isEnabled());

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}

