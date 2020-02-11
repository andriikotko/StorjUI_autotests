package testsNode;

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
import pages.NodeDashboard.NodeDashboardPage;

import java.util.concurrent.TimeUnit;

import static pages.HomePage.DefaultBrowser;

public class NodeElementsVisibilityTests {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional(DefaultBrowser) String browser) throws Exception {
//        System.setProperty("webdriver.chrome.driver", NodeDashboardPage.CHROMEDRIVERPATH);
//
//        driver = new ChromeDriver();


        //Check if parameter passed from TestNG is 'firefox'

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")){
            switch (browser){
                case "Firefox":
                    chosingOS=NodeDashboardPage.GECKODRIVERPATH;
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

    }

    @Test
    public void elementsVisibilityTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Assert.assertTrue(nodeDashboardPage.dashboardStorjLogo.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.refreshButton.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.nodeIDContainer.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.nodeID.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.nodeIDText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.nodeHeader.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.currentPeriod.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.currentMonth.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.nodeStatusText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.nodeStatus.isDisplayed());
//        Assert.assertTrue(nodeDashboardPage.statusInfoTick.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.nodeVersionText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.nodeVersion.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.nodeVersionInfoTick.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.choosingSatelliteContainer.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.chosenSatelliteText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.utilizationRemainingHeader.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.bandwidthHeader.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.bandwidthData.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.bandwidthGraph.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.diskSpaceHeader.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.diskSpaceData.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.diskSpaceGraph.isDisplayed());
      //  Assert.assertTrue(nodeDashboardPage.remainingHeader.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.bandwidthRemainingText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.bandwidthRemainData.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.bandwidthRemainBar.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.diskRemainText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.diskRemainData.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.diskRemainBar.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.payoutHeader.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.storjWalletAddressText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.walletLogo.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.walletData.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.payoutButton.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.footerLogo.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.linkToCommunity.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.linkToSupport.isDisplayed());

    }
    @Ignore
    @Test
    public void nodeStatusHintVisibilityTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.statusInfoTick).click().perform();

        Assert.assertTrue(nodeDashboardPage.nodeStatusInfoPopUp.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.lastPingedText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.uptimeText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.lastPingedData.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.uptimeData.isDisplayed());
    }

    @Test
    public void nodeVersionHintVisibilityTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.nodeVersionInfoTick).click().perform();

        Assert.assertTrue(nodeDashboardPage.nodeVersionPopUp.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.versionPopUpText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.versionPopUpVersion.isDisplayed());
    }

    @Test
    public void bandwidthRemainBarHintVisibilityTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.bandwidthRemainBar).click().perform();

        Assert.assertTrue(nodeDashboardPage.bandwidthRemainBarHint.isDisplayed());
    }

    @Test
    public void diskRemainBarHintVisibilityTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.diskRemainBar).click().perform();

        Assert.assertTrue(nodeDashboardPage.diskRemainBarHint.isDisplayed());
    }

    @Test
    public void uptimeAuditElementsVisibilityTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.chooseFirstSatellite();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",nodeDashboardPage.footerLogo);

        Assert.assertTrue(nodeDashboardPage.auditUptimeHeader.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.uptimeChecksText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.uptimeChecksHintTick.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.uptimeCheckData.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.auditChecksText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.auditChecksHintTick.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.auditCheckData.isDisplayed());
    }

    @Test
    public void uptimeHintVisibilityTest() throws InterruptedException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.chooseFirstSatellite();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",nodeDashboardPage.footerLogo);
        Thread.sleep(1000);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.uptimeChecksHintTick).click().perform();

        Assert.assertTrue(nodeDashboardPage.uptimeCheckHintText.isDisplayed());
    }

    @Test
    public void auditHintVisibilityTest() throws InterruptedException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.chooseFirstSatellite();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",nodeDashboardPage.footerLogo);
        Thread.sleep(1000);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.auditChecksHintTick).click().perform();

        Assert.assertTrue(nodeDashboardPage.auditCheckHintText.isDisplayed());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
