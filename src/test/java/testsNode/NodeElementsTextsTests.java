package testsNode;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NodeDashboard.NodeDashboardPage;

import java.util.concurrent.TimeUnit;

public class NodeElementsTextsTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", NodeDashboardPage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
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
        Assert.assertTrue(nodeDashboardPage.diskSpaceData.getText().endsWith("B*h"));

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


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
