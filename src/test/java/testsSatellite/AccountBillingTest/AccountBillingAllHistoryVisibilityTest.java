package testsSatellite.AccountBillingTest;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.Tabs.AccountTab_AllBillingHistory;
import pages.Tabs.AccountTab_Billing;

import java.util.concurrent.TimeUnit;

public class AccountBillingAllHistoryVisibilityTest {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {
        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")){
            chosingOS = "";
        }
        if (OS.substring(0,4).equals("Windo")){
            chosingOS = ".exe";
        }
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH+chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH+chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH+chosingOS);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
    public void billingHiistoryElementsVisibility () {
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",accountTab_billing.depositHistoryViewAllButton);
        accountTab_billing.depositHistoryViewAllButton.click();
        AccountTab_AllBillingHistory accountTab_allBillingHistory = PageFactory.initElements(driver, AccountTab_AllBillingHistory.class);

        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryDateHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryDescriptionHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryStatusHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryAmountHeader.isDisplayed());
        Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryBackButton.isDisplayed());
    //    Assert.assertTrue(accountTab_allBillingHistory.allBillingHistoryPaginator.isDisplayed());


    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
