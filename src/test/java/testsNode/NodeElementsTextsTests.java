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

public class NodeElementsTextsTests {

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
    public void elementsTextsTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Assert.assertEquals(nodeDashboardPage.nodeIDText.getText(), "Node ID:");

        Assert.assertEquals(nodeDashboardPage.nodeHeader.getText(), "Your Storage Node Stats");
        Assert.assertTrue(nodeDashboardPage.currentPeriod.getText().startsWith("PERIOD"));

        Assert.assertEquals(nodeDashboardPage.nodeStatusText.getText(), "STATUS");
        Assert.assertEquals(nodeDashboardPage.nodeStatus.getText(), "Online");

        Assert.assertEquals(nodeDashboardPage.nodeVersionText.getText(), "VERSION");
        Assert.assertEquals(nodeDashboardPage.nodeVersion.getText(), "v0.0.0");

        Assert.assertEquals(nodeDashboardPage.choosingSatelliteContainer.getText(), "Choose your satellite: All Satellites");
        Assert.assertEquals(nodeDashboardPage.chosenSatelliteText.getText(), "Choose your satellite:");
        Assert.assertEquals(nodeDashboardPage.utilizationRemainingHeader.getText(), "Utilization & Remaining");
        Assert.assertEquals(nodeDashboardPage.bandwidthHeader.getText(), "Bandwidth Used This Month");
        Assert.assertTrue(nodeDashboardPage.bandwidthData.getText().contains("B"));

        Assert.assertEquals(nodeDashboardPage.diskSpaceHeader.getText(), "Disk Space Used This Month");
        Assert.assertTrue(nodeDashboardPage.diskSpaceData.getText().endsWith("*h"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",nodeDashboardPage.footerLogo);

      //  Assert.assertEquals(nodeDashboardPage.remainingHeader.getText(), "Remaining on the Node");
        Assert.assertEquals(nodeDashboardPage.bandwidthRemainingText.getText(), "Bandwidth Remaining");
        Assert.assertTrue(nodeDashboardPage.bandwidthRemainData.getText().endsWith("B"));

        Assert.assertEquals(nodeDashboardPage.diskRemainText.getText(), "Disk Space Remaining");
        Assert.assertTrue(nodeDashboardPage.diskRemainData.getText().endsWith("B"));

        Assert.assertEquals(nodeDashboardPage.payoutHeader.getText(), "Payout");
        Assert.assertEquals(nodeDashboardPage.storjWalletAddressText.getText(), "STORJ Wallet Address");

        Assert.assertEquals(nodeDashboardPage.walletData.getText(), "0x0123456789012345678901234567890123456789");
        Assert.assertEquals(nodeDashboardPage.payoutButton.getText(), "View on Etherscan");


        Assert.assertEquals(nodeDashboardPage.linkToCommunity.getText(), "Community");

        Assert.assertEquals(nodeDashboardPage.linkToSupport.getText(), "Support");


    }

    @Test
    public void linksTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        Assert.assertTrue(nodeDashboardPage.payoutLink.getAttribute("href").startsWith("https://etherscan.io/address/"));
        Assert.assertTrue(nodeDashboardPage.linkToCommunity.getAttribute("href").contains("https://forum.storj.io/c/sno-category"));
        Assert.assertTrue(nodeDashboardPage.linkToSupport.getAttribute("href").contains("https://support.storj.io"));
    }

    @Ignore
    @Test
    public void nodeStatusHintTextTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.statusInfoTick).click().perform();

        Assert.assertEquals(nodeDashboardPage.lastPingedText.getText(), "Last Pinged");
        Assert.assertEquals(nodeDashboardPage.uptimeText.getText(), "Uptime");
        Assert.assertTrue(nodeDashboardPage.lastPingedData.getText().endsWith("m ago"));
        Assert.assertTrue(nodeDashboardPage.uptimeData.getText().endsWith("m"));
    }

    @Test
    public void nodeVersionHintTextTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.nodeVersionInfoTick).click().perform();

        Assert.assertEquals(nodeDashboardPage.versionPopUpText.getText(), "Running the minimal allowed version:");
        Assert.assertEquals(nodeDashboardPage.versionPopUpVersion.getText(), "v0.0.0");
    }

    @Test
    public void bandwidthRemainBarHintTextTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.bandwidthRemainBar).click().perform();

        Assert.assertTrue(nodeDashboardPage.bandwidthRemainBarHint.getText().endsWith("% of bandwidth left"));

    }

    @Test
    public void diskRemainBarHintTextTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.diskRemainBar).click().perform();

        Assert.assertTrue(nodeDashboardPage.diskRemainBarHint.getText().endsWith("% of disk space left"));

    }

    @Test
    public void uptimeAuditElementsTextsTest() throws InterruptedException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.chooseFirstSatellite();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",nodeDashboardPage.footerLogo);
        Thread.sleep(1000);

        Assert.assertEquals(nodeDashboardPage.auditUptimeHeader.getText(),"Uptime & Audit Checks by Satellite");
        Assert.assertEquals(nodeDashboardPage.uptimeChecksText.getText(),"Uptime Checks");
        Assert.assertTrue(nodeDashboardPage.uptimeCheckData.getText().endsWith("%"));
        Assert.assertEquals(nodeDashboardPage.auditChecksText.getText(),"Audit Checks");
        Assert.assertTrue(nodeDashboardPage.auditCheckData.getText().endsWith("%"));
    }

    @Test
    public void uptimeHintTextTest() throws InterruptedException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.chooseFirstSatellite();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",nodeDashboardPage.footerLogo);
        Thread.sleep(1000);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.uptimeChecksHintTick).click().perform();

        Assert.assertEquals(nodeDashboardPage.uptimeCheckHintText.getText(),"Uptime checks occur to make sure your node is still online. This is the percentage of uptime checks you’ve passed.");
    }

    @Test
    public void auditHintTextTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.chooseFirstSatellite();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",nodeDashboardPage.footerLogo);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.auditChecksHintTick).click().perform();

        Assert.assertEquals(nodeDashboardPage.auditCheckHintText.getText(),"Percentage of successful pings/communication between the node & satellite.");
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
