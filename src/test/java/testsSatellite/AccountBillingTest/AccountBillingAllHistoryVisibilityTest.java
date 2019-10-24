package testsSatellite.AccountBillingTest;

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
import pages.Tabs.AccountTab_AllBillingHistory;
import pages.Tabs.AccountTab_Billing;

import java.util.concurrent.TimeUnit;

public class AccountBillingAllHistoryVisibilityTest {
    WebDriver driver;

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
        homePage.billingTab.click();

    }

    @Test
    public void billingTabelementsVisibility (){
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        accountTab_billing.depositHistoryViewAllButton.click();
        AccountTab_AllBillingHistory accountTab_allBillingHistory = PageFactory.initElements(driver, AccountTab_AllBillingHistory.class);

        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryDateHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryDescriptionHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryStatusHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryAmountHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryBackButton.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryPaginator.isDisplayed());


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
