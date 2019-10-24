package testsSatellite.APIKeysTabTests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.APIKeysTab;

import java.util.concurrent.TimeUnit;

public class APIKeysTabElementsVisibilityTests {

    public WebDriver driver;



    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        //driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.API_Keys_Tab.click();

    }

    @Test
    public void APIKeysElementsVisibilityTest () {
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);
        if (apiKeysTab.checkAPIPresence.getAttribute("class").startsWith("api-keys-header")) {

            Assert.assertTrue(apiKeysTab.APIKeysHeader.isDisplayed());
            Assert.assertTrue(apiKeysTab.createNewAPIkeyButton.isDisplayed());
            Assert.assertTrue(apiKeysTab.APIKeysSearchField.isDisplayed());
            Assert.assertTrue(apiKeysTab.keyNameHeader.isDisplayed());
            Assert.assertTrue(apiKeysTab.createdDateHeader.isDisplayed());
            Assert.assertTrue(apiKeysTab.firstAPIKeyCheckboxContainer.isDisplayed());
            Assert.assertTrue(apiKeysTab.firstAPIkeyIcon.isDisplayed());
            Assert.assertTrue(apiKeysTab.firstAPIKeyName.isDisplayed());
            Assert.assertTrue(apiKeysTab.firstAPIKeyCreationDate.isDisplayed());
            //// Assert.assertTrue(apiKeysTab.APIKeysPaginatorContainer.isDisplayed()); - need should appear then apikeys>6
        }
        else{
            Assert.assertTrue(apiKeysTab.noAPIHeader.isDisplayed());
            Assert.assertTrue(apiKeysTab.noAPIKeysNotification.isDisplayed());
            Assert.assertTrue(apiKeysTab.noAPICreateNew.isDisplayed());
            Assert.assertTrue(apiKeysTab.noAPIKeysImage.isDisplayed());
        }
    }

    @Test
    public void APIKeysDeleteVisibilityTest (){
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);

        apiKeysTab.firstAPIKeyCheckboxContainer.click();

        Assert.assertTrue(apiKeysTab.deleteAPIKeyButton.isDisplayed());
        Assert.assertTrue(apiKeysTab.cancelDeletingAPIKeyButton.isDisplayed());

    }

    @Test
    public void APIKeysDeleteConfirmationVisibilityTest (){
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);

        apiKeysTab.firstAPIKeyCheckboxContainer.click();
        apiKeysTab.deleteAPIKeyButton.click();

        Assert.assertTrue(apiKeysTab.deleteAPIKeyConfirmation.isDisplayed());
    }

    @Test
    public void CreateNewAPIKeyDialogVisibilityTest (){
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);

        apiKeysTab.createNewAPIkeyButton.click();

        Assert.assertTrue(apiKeysTab.newAPIKeyHeader.isDisplayed());
        Assert.assertTrue(apiKeysTab.newAPIkeyNameInput.isDisplayed());
        Assert.assertTrue(apiKeysTab.confirmAPIKeyCreation.isDisplayed());
        Assert.assertTrue(apiKeysTab.closeNewAPIKeyCreationDialog.isDisplayed());
    }

    @Test
    public void NewCreatedAPIKeyDialogVisibilityTest (){
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);

        apiKeysTab.createNewAPIkeyButton.click();
        apiKeysTab.newAPIkeyNameInput.sendKeys(Integer.toString((int)(Math.random()*100+1)));
        apiKeysTab.confirmAPIKeyCreation.click();

        Assert.assertTrue(apiKeysTab.newCreatedAPIKeyDialogHeader.isDisplayed());
        Assert.assertTrue(apiKeysTab.newAPIKeyCopyButton.isDisplayed());
        Assert.assertTrue(apiKeysTab.newAPIKey.isDisplayed());
        Assert.assertTrue(apiKeysTab.closeAPIKeyDialogAfterCreation.isDisplayed());
    }




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
