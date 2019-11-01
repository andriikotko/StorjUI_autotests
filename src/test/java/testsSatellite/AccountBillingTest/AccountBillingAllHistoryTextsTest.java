package testsSatellite.AccountBillingTest;

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
import pages.NodeDashboard.NodeDashboardPage;
import pages.Tabs.AccountTab_AllBillingHistory;
import pages.Tabs.AccountTab_Billing;

import java.util.concurrent.TimeUnit;

public class AccountBillingAllHistoryTextsTest {
    WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        //driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);



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

    @Test
    public void hintTextTest (){
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);

        Actions action = new Actions(driver);
        action.moveToElement(accountTab_billing.accountBalanceHint).click().perform();


        Assert.assertEquals(accountTab_billing.accountBalanceHintText.getText(), "Prepaid STORJ token amount and any additional credits, minus current usage");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
