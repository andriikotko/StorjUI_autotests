package testsForNode;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NodeDashboard.NodeDashboardPage;

import java.util.concurrent.TimeUnit;

public class NodeElementsVisibilityTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", NodeDashboardPage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(NodeDashboardPage.Width,NodeDashboardPage.Height));
        driver.get(NodeDashboardPage.DASHBOARDURL);
    }

    @Test
    public void elementsVisibilityTest(){
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
        Assert.assertTrue(nodeDashboardPage.statusInfoTick.isDisplayed());
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
        Assert.assertTrue(nodeDashboardPage.remainingHeader.isDisplayed());
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

    @Test
    public void nodeStatusHintVisibilityTest(){
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
    public void nodeVersionHintVisibilityTest(){
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.nodeVersionInfoTick).click().perform();

        Assert.assertTrue(nodeDashboardPage.nodeVersionPopUp.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.versionPopUpText.isDisplayed());
        Assert.assertTrue(nodeDashboardPage.versionPopUpVersion.isDisplayed());
    }

    @Test
    public void bandwidthRemainBarHintVisibilityTest(){
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.bandwidthRemainBar).click().perform();

        Assert.assertTrue(nodeDashboardPage.bandwidthRemainBarHint.isDisplayed());

    }

    @Test
    public void diskRemainBarHintVisibilityTest(){
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);

        Actions action = new Actions(driver);
        action.moveToElement(nodeDashboardPage.diskRemainBar).click().perform();

        Assert.assertTrue(nodeDashboardPage.diskRemainBarHint.isDisplayed());

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
