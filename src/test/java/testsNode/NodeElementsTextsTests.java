package testsNode;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.NodeDashboard.NodeDashboardPage;

import java.util.concurrent.TimeUnit;

public class NodeElementsTextsTests {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("Chrome") String browser) throws Exception {
//        System.setProperty("webdriver.chrome.driver", NodeDashboardPage.CHROMEDRIVERPATH);
//
//        driver = new ChromeDriver();

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
            System.setProperty("webdriver.gecko.driver", NodeDashboardPage.GECKODRIVERPATH+chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",NodeDashboardPage.CHROMEDRIVERPATH+chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
      //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", NodeDashboardPage.OPERADRIVERPATH+chosingOS);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(NodeDashboardPage.Width, NodeDashboardPage.Height));
        driver.get(NodeDashboardPage.DASHBOARDURL);

    }

    @Test
    public void elementsTextsTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Assert.assertEquals(nodeDashboardPage.nodeIDText.getText(), "Node ID:");

        Assert.assertEquals(nodeDashboardPage.nodeHeader.getText(), "Your Storage Node Stats");
        Assert.assertTrue(nodeDashboardPage.currentPeriod.getText().startsWith("Current period"));

        Assert.assertEquals(nodeDashboardPage.nodeStatusText.getText(), "Node status");
        Assert.assertEquals(nodeDashboardPage.nodeStatus.getText(), "Online");

        Assert.assertEquals(nodeDashboardPage.nodeVersionText.getText(), "Node Version");
        Assert.assertEquals(nodeDashboardPage.nodeVersion.getText(), "v0.0.0");

        Assert.assertEquals(nodeDashboardPage.choosingSatelliteContainer.getText(), "Choose your satellite: All satellites");
        Assert.assertEquals(nodeDashboardPage.chosenSatelliteText.getText(), "Choose your satellite:");
        Assert.assertEquals(nodeDashboardPage.utilizationRemainingHeader.getText(), "Utilization & Remaining");
        Assert.assertEquals(nodeDashboardPage.bandwidthHeader.getText(), "Bandwidth Used This Month");
        Assert.assertTrue(nodeDashboardPage.bandwidthData.getText().contains("B"));

        Assert.assertEquals(nodeDashboardPage.diskSpaceHeader.getText(), "Disk Space Used This Month");
        Assert.assertTrue(nodeDashboardPage.diskSpaceData.getText().endsWith("*h"));

        Assert.assertEquals(nodeDashboardPage.remainingHeader.getText(), "Remaining on the Node");
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
    public void uptimeAuditElementsTextsTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.currentSatellite.click();

        Assert.assertEquals(nodeDashboardPage.auditUptimeHeader.getText(),"Uptime & Audit Checks by Satellite");
        Assert.assertEquals(nodeDashboardPage.uptimeChecksText.getText(),"Uptime Checks");
        Assert.assertTrue(nodeDashboardPage.uptimeCheckData.getText().endsWith("%"));
        Assert.assertEquals(nodeDashboardPage.auditChecksText.getText(),"Audit Checks");
        Assert.assertTrue(nodeDashboardPage.auditCheckData.getText().endsWith("%"));
    }

    @Test
    public void uptimeHintTextTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.currentSatellite.click();

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.uptimeChecksHintTick).click().perform();

        Assert.assertEquals(nodeDashboardPage.uptimeCheckHintText.getText(),"Uptime checks occur to make sure your node is still online. This is the percentage of uptime checks you’ve passed.");
    }

    @Test
    public void auditHintTextTest() {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.currentSatellite.click();

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.auditChecksHintTick).click().perform();

        Assert.assertEquals(nodeDashboardPage.auditCheckHintText.getText(),"Percentage of successful pings/communication between the node & satellite.");
    }



    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
