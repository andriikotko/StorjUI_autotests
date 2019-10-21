package tests.AccountBillingTest;

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

public class AccountBillingAllHistoryTextsTest {
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

        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryHeader.getText(),"Billing History");
        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryDateHeader.getText(),"Date");
        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryDescriptionHeader.getText(),"Description");
        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryStatusHeader.getText(),"Status");
        Assert.assertEquals(accountTab_allBillingHistory.allBillingHistoryAmountHeader.getText(),"Amount");
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryBackButtonText.getText().endsWith("Back to Account"));
       // Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryPaginator.isDisplayed());


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
