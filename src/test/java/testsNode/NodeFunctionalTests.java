package testsNode;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NodeDashboard.NodeDashboardPage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class NodeFunctionalTests {
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
    public void compareSatteliteIDTest() throws IOException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        FileReader fileReader = new FileReader("/home/andrii/.local/share/storj/local-network/storagenode/0/config.yaml");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String satelliteIDFromFile;

        while ((satelliteIDFromFile = bufferedReader.readLine())!= null){
            if (satelliteIDFromFile.startsWith("storage.whitelisted-satellites:")){
                satelliteIDFromFile=satelliteIDFromFile.substring(32,83);
                break;
            }
        }
        nodeDashboardPage.choosingSatelliteContainer.click();
        String satelliteFromPage = nodeDashboardPage.currentSatellite.getText();

        Assert.assertEquals(satelliteFromPage, satelliteIDFromFile);
    }

    @Test
    public void gotoCommunityTest(){
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        nodeDashboardPage.linkToCommunity.click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://forum.storj.io/c/sno-category");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"ember21\"]/span/span/span[2]/span")).getText(), "Storage Node Operators");
    }

    @Test
    public void gotoSupportTest(){
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        nodeDashboardPage.linkToSupport.click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://support.storj.io/hc/en-us");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"user-nav\"]/a")).getText(), "Submit a request");
    }

    @Test
    public void gotoViewOnEtherscanTest(){
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        nodeDashboardPage.payoutButton.click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://etherscan.io/address/"));
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"body\"]/footer/div/div[1]/div[1]/div/div[1]/span")).getText(), "Powered by Ethereum");
    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
