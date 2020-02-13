package testsSatellite.APIKeysTabTests;

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
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.APIKeysTab;

import java.util.concurrent.TimeUnit;

public class APIKeysTabTextTest {
    public WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
        homePage.API_Keys_Tab.click();

    }

    @Test
    public void APIKeysElementsTextsTest() {
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);

        if (apiKeysTab.checkAPIPresence.getAttribute("class").startsWith("api-keys-header")) {
            Assert.assertEquals(apiKeysTab.APIKeysHeader.getText(), "API Keys");
            Assert.assertEquals(apiKeysTab.createNewAPIkeyButton.getText(), "+Create API Key");
            Assert.assertTrue(apiKeysTab.APIKeysSearchField.getAttribute("placeholder").startsWith("Search API Key"));
            Assert.assertEquals(apiKeysTab.keyNameHeader.getText(), "Key Name");
            Assert.assertEquals(apiKeysTab.createdDateHeader.getText(), "Created");
        }

        else {
            Assert.assertEquals(apiKeysTab.noAPIHeader.getText(),"Let's create your first API Key");
            Assert.assertEquals(apiKeysTab.noAPIKeysNotification.getText(), "API keys give access to the project allowing you to create buckets, upload files, and read them. Once you’ve created an API key, you’re ready to interact with the network through our Uplink CLI.");
            Assert.assertEquals(apiKeysTab.noAPICreateNew.getText(), "Create an API Key");
        }
    }

    @Test
    public void APIKeysDeleteTextsTest() {
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);

        apiKeysTab.firstAPIKeyCheckboxContainer.click();

        Assert.assertEquals(apiKeysTab.deleteAPIKeyButton.getText(), "Delete");
        Assert.assertEquals(apiKeysTab.cancelDeletingAPIKeyButton.getText(), "Cancel");

    }

    @Test
    public void APIKeysDeleteConfirmationVisibilityTest() {
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);

        apiKeysTab.firstAPIKeyCheckboxContainer.click();
        apiKeysTab.deleteAPIKeyButton.click();

        Assert.assertTrue(apiKeysTab.deleteAPIKeyNotification.getText().startsWith("Are you sure you want to delete"));
    }

    @Test
    public void CreateNewAPIKeyDialogVisibilityTest() {
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);

        apiKeysTab.createNewAPIkeyButton.click();

        Assert.assertEquals(apiKeysTab.newAPIKeyHeader.getText(), "Name Your API Key");
        Assert.assertTrue(apiKeysTab.newAPIkeyNameInput.getAttribute("placeholder").startsWith("Enter API Key Name"));
        Assert.assertEquals(apiKeysTab.confirmAPIKeyCreation.getText(), "Next >");
    }

    @Test
    public void NewCreatedAPIKeyDialogVisibilityTest() {
        APIKeysTab apiKeysTab = PageFactory.initElements(driver, APIKeysTab.class);

        apiKeysTab.createNewAPIkeyButton.click();
        apiKeysTab.newAPIkeyNameInput.sendKeys(Integer.toString((int) (Math.random() * 100 + 1)));
        apiKeysTab.confirmAPIKeyCreation.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(apiKeysTab.newAPIKeyCopyButton));


        Assert.assertEquals(apiKeysTab.newCreatedAPIKeyDialogHeader.getText(), "Save Your Secret API Key! It Will Appear Only Once.");
        Assert.assertEquals(apiKeysTab.newAPIKeyCopyButton.getText(), "Copy");

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
