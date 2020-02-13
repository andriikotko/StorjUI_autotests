package testsSatellite.APIKeysTabTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import pages.Tabs.APIKeysTab;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class APIKeysFunctionalTests {
    WebDriver driver;
    @AfterMethod()
    public void tearDown()
    {driver.quit();}
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);

        Thread.sleep(4000);
    }
    @Test(invocationCount = 1)
    public void addAPIKeyPositiveNotificationTest(){
        int random = (int )(Math.random() * 10000000 + 1);
        String randomNumber= Integer.toString(random);
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        APIKeysTab APIkeysTab = PageFactory.initElements(driver, APIKeysTab.class);
        HomePage.API_Keys_Tab.click();
        try {
            APIkeysTab.createNewAPIkeyButton.click();
        } catch (Exception e) {}
        try {APIkeysTab.newAPIkeyCreateButtonEmpty.click();}
        catch (Exception e){}

        APIkeysTab.newAPIkeyNameInput.sendKeys(randomNumber);
        APIkeysTab.confirmAPIKeyCreation.click();
//      APIkeysTab.CrossButtonOnPopUp.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(HomePage.Error_Notification));
        Assert.assertTrue(HomePage.Error_Notification.getText().endsWith("Successfully created new api key"));

    }

    @Test
    public void addAPIKeyPositiveTest() throws InterruptedException {
        int random = (int )(Math.random() * 10000000 + 1);
        String randomNumber= Integer.toString(random);
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        LoginPage LoginPage = PageFactory.initElements(driver, pages.LoginPage.class);
        APIKeysTab APIkeysTab = PageFactory.initElements(driver, APIKeysTab.class);
        HomePage.API_Keys_Tab.click();
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"apikey-item-container item-component__item\"]"));
        try {
            APIkeysTab.createNewAPIkeyButton.click();
        } catch (Exception e) {}
        try {APIkeysTab.newAPIkeyCreateButtonEmpty.click();}
        catch (Exception e){}

        APIkeysTab.newAPIkeyNameInput.sendKeys(randomNumber);
        APIkeysTab.confirmAPIKeyCreation.click();
        Thread.sleep(1000);

        APIkeysTab.closeAPIKeyDialogAfterCreation.click();
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class=\"apikey-item-container item-component__item\"]"));

        Assert.assertEquals(list1.size(), list2.size()-1);

    }

    @Test
    public void addAPIKeyEmptyTest(){
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        APIKeysTab APIkeysTab = PageFactory.initElements(driver, APIKeysTab.class);
        HomePage.API_Keys_Tab.click();
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"apikey-item-container item-component__item\"]"));
        APIkeysTab.createNewAPIkeyButton.click();

        APIkeysTab.newAPIkeyNameInput.sendKeys("");
        APIkeysTab.confirmAPIKeyCreation.click();

        Assert.assertEquals(APIkeysTab.errorAPIKeyCreation.getText(), "API Key name can`t be empty");

    }

    @Test
    public void addSameAPIKeyTest() throws InterruptedException {
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        APIKeysTab APIkeysTab = PageFactory.initElements(driver, APIKeysTab.class);
        HomePage.API_Keys_Tab.click();

        APIkeysTab.createNewAPIkeyButton.click();

        APIkeysTab.newAPIkeyNameInput.sendKeys("11111111");
        APIkeysTab.confirmAPIKeyCreation.click();


        WebDriverWait wait = new WebDriverWait(driver,10);
        Thread.sleep(4000);
        APIkeysTab.closeAPIKeyDialogAfterCreation.click();
        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"apikey-item-container item-component__item\"]"));


// same API Key creation
        APIkeysTab.createNewAPIkeyButton.click();
        APIkeysTab.newAPIkeyNameInput.sendKeys("11111111");
        APIkeysTab.confirmAPIKeyCreation.click();
        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class=\"apikey-item-container item-component__item\"]"));



        wait.until(ExpectedConditions.visibilityOf(HomePage.Error_Notification));
        Assert.assertEquals(HomePage.Error_Notification.getText(),"An API Key with this name already exists in this project, please use a different name");

        APIkeysTab.closeNewAPIKeyCreationDialog.click();

        Assert.assertEquals(list1, list2);
    }
    @Test
    public void deleteAPIKeyCancelTest() {
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        APIKeysTab APIkeysTab = PageFactory.initElements(driver, APIKeysTab.class);
        HomePage.API_Keys_Tab.click();

        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"apikey-item-container item-component__item\"]"));

        APIkeysTab.firstAPIKeyCheckboxContainer.click();

        APIkeysTab.deleteAPIKeyButton.click();
        APIkeysTab.cancelDeleteAPIKeyConfirmation.click();

        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class=\"apikey-item-container item-component__item\"]"));

        Assert.assertEquals(list1, list2);

    }

    @Test
    public void deleteAPIKeyDeleteTest() throws InterruptedException {
        HomePage HomePage = PageFactory.initElements(driver, HomePage.class);
        APIKeysTab APIkeysTab = PageFactory.initElements(driver, APIKeysTab.class);
        HomePage.API_Keys_Tab.click();

        List<WebElement> list1 = driver.findElements(By.xpath("//*[@class=\"apikey-item-container item-component__item\"]"));

        APIkeysTab.firstAPIKeyCheckboxContainer.click();

        APIkeysTab.deleteAPIKeyButton.click();
        APIkeysTab.deleteAPIKeyConfirmation.click();
        Thread.sleep(1000);

        List<WebElement> list2 = driver.findElements(By.xpath("//*[@class=\"apikey-item-container item-component__item\"]"));

        Assert.assertEquals(list1.size(), list2.size()+1);

    }
}
