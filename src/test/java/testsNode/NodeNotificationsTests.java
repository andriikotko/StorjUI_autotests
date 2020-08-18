package testsNode;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.NodeDashboard.NodeDashboardPage;
import pages.NodeDashboard.NodeNotifications;

import java.util.concurrent.TimeUnit;

import static pages.HomePage.DefaultBrowser;

public class NodeNotificationsTests {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional(DefaultBrowser) String browser) throws Exception {
//        System.setProperty("webdriver.chrome.driver", NodeDashboardPage.CHROMEDRIVERPATH);
//
//        driver = new ChromeDriver();

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")){
            switch (browser){
                case "Firefox":
                    chosingOS= NodeDashboardPage.GECKODRIVERPATH;
                    break;
                case "Chrome":
                    chosingOS=NodeDashboardPage.CHROMEDRIVERPATH;
                    break;
                case "Opera":
                    chosingOS=NodeDashboardPage.OPERADRIVERPATH;
                    break;
                default:
                    chosingOS = "";
            }
        }
        else if (OS.substring(0,4).equals("Windo")){
            chosingOS = NodeDashboardPage.CHROMEDRIVERPATHWIN;
        }
        else if (OS.substring(0,3).equals("Mac")){
            chosingOS = NodeDashboardPage.CHROMEDRIVERPATHMAC;
        }else{
            //If no os passed throw exception
            throw new Exception("os is not correct");
        }
        //Check if parameter passed from TestNG is 'firefox'
        if(browser.equalsIgnoreCase("Firefox")){
            //create firefox instance
            System.setProperty("webdriver.gecko.driver", chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            System.out.println(chosingOS);
            //set path to chromedriver.exe
            // System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedrivermac");
            System.setProperty("webdriver.chrome.driver", chosingOS);
            //create chrome instance

            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", chosingOS);
            driver = new OperaDriver();
        } else if(browser.equalsIgnoreCase("Safari")){
            System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
            driver = new SafariDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if(browser.equalsIgnoreCase("Safari")){
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(new Dimension(NodeDashboardPage.Width, NodeDashboardPage.Height));}
        driver.get(NodeDashboardPage.DASHBOARDURL);
        Thread.sleep(2000);
    }

    @Test
    public void notificationsElementsVisibilityTests(){
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        NodeNotifications nodeNotifications = PageFactory.initElements(driver, NodeNotifications.class);

        nodeDashboardPage.bellButton.click();
        nodeDashboardPage.notificationsPopupSeeAll.click();

        Assert.assertTrue(nodeNotifications.notificationsBackButton.isDisplayed());
        Assert.assertTrue(nodeNotifications.notificationsImage.isDisplayed());
        Assert.assertTrue(nodeNotifications.notificationsMarkAllButton.isDisplayed());
        Assert.assertTrue(nodeNotifications.notificationsNoYet.isDisplayed());
        Assert.assertTrue(nodeNotifications.notificationsTitle.isDisplayed());

    }

    @Test
    public void notificationsElementsTextTests(){
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        NodeNotifications nodeNotifications = PageFactory.initElements(driver, NodeNotifications.class);

        nodeDashboardPage.bellButton.click();
        nodeDashboardPage.notificationsPopupSeeAll.click();

        Assert.assertEquals(nodeNotifications.notificationsTitle.getText(),"Notifications");
        Assert.assertEquals(nodeNotifications.notificationsMarkAllButton.getText(),"Mark all as read");
        Assert.assertEquals(nodeNotifications.notificationsNoYet.getText(),"No notifications yet");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
