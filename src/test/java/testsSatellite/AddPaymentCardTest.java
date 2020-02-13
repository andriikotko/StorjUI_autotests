package testsSatellite;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.SystemParams;
import pages.Tabs.PaymentsTab;

import java.util.concurrent.TimeUnit;

public class AddPaymentCardTest {
    public WebDriver driver;
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginToAccountWithValidCreds(homePage.ACCOUNT, homePage.PASSWORD);}

    @Ignore
    @Test
    public void AddPaymentCardTest() throws InterruptedException {


        PaymentsTab PaymmentsTab =PageFactory.initElements(driver, PaymentsTab.class);
        PaymmentsTab.Payment_Tab.click();
        Thread.sleep(2000);
        driver.switchTo().frame(PaymmentsTab.STRIPE_IFRAME);
        Thread.sleep(1000);
        PaymmentsTab.Card_Input.sendKeys("4242424242424242233323326000");
        driver.switchTo().defaultContent();
        PaymmentsTab.Save_Card_Button.click();
        

    }
}
