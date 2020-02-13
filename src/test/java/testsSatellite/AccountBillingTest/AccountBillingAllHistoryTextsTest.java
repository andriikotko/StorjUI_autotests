package testsSatellite.AccountBillingTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.AccountTab_AllBillingHistory;
import pages.Tabs.AccountTab_Billing;

import java.util.concurrent.TimeUnit;

import static pages.SystemParams.*;

public class AccountBillingAllHistoryTextsTest {
    WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

       SystemParams systemParams = new SystemParams(driver);
       driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);
        homePage.billingTab.click();

    }

    @Test
    public void billingTabelementsVisibility (){
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",accountTab_billing.depositHistoryViewAllButton);
        accountTab_billing.depositHistoryViewAllButton.click();
        AccountTab_AllBillingHistory accountTab_allBillingHistory = PageFactory.initElements(driver, AccountTab_AllBillingHistory.class);

        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryHeader.getText(),"Billing History");
        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryDateHeader.getText(),"Date");
        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryDescriptionHeader.getText(),"Description");
        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryStatusHeader.getText(),"Status");
        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryAmountHeader.getText(),"Amount");
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryBackButtonText.getText().endsWith("Back to Account"));
       // Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryPaginator.isDisplayed());
    }

    @Test
    public void hintTextTest (){
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);

        Actions action = new Actions(driver);
        action.moveToElement(accountTab_billing.accountBalanceHint).click().perform();


        Assert.assertEquals(accountTab_billing.accountBalanceHintText.getText(), "Prepaid STORJ token amount and any additional credits.");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
