package testsNode;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.NodeDashboard.NodeDashboardPage;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static pages.HomePage.*;

public class NodeFunctionalTests {
    private WebDriver driver;
//
//    @BeforeClass
//    public void setupEnviroment (){
////        Process p;
////        try {
////            String[] cmd = { "sh", "/home/andrii/Downloads/scrips/storj_setup.sh"};
////            p = Runtime.getRuntime().exec(cmd);
////            p.waitFor();
////            BufferedReader reader=new BufferedReader(new InputStreamReader(
////                    p.getInputStream()));
////            String line;
////            while((line = reader.readLine()) != null) {
////                System.out.println(line);
////            }
////        } catch (IOException e) {
////            // TODO Auto-generated catch block
////            e.printStackTrace();
////        } catch (InterruptedException e) {
////            // TODO Auto-generated catch block
////            e.printStackTrace();
////        }
//    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional(DefaultBrowser) String browser) throws Exception {

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")){
            chosingOS = NodeDashboardPage.GECKODRIVERPATH;
        }
        else if (OS.substring(0,4).equals("Windo")){
            chosingOS = NodeDashboardPage.CHROMEDRIVERPATHWIN;
        }
        else if (OS.substring(0,3).equals("Mac")){
            if(browser.equalsIgnoreCase("EDGE")){
                System.setProperty("webdriver.edge.driver", NodeDashboardPage.EDGEDRIVERPATH);
                driver = new EdgeDriver();
            }
            else{
            chosingOS = NodeDashboardPage.CHROMEDRIVERPATHMAC;}
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
            //set path to chromedriver.exe
            // System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedrivermac");
            System.setProperty("webdriver.chrome.driver", chosingOS);
            //create chrome instance

            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            System.setProperty("webdriver.safari.driver", chosingOS);
            driver = new OperaDriver();
        }
        else if(browser.equalsIgnoreCase("Safari")){
            System.setProperty("webdriver.safari.driver", "/usr/bin/safaridriver");
            driver = new SafariDriver();
        }else if(browser.equalsIgnoreCase("EDGE")){
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
    public void compareSatteliteIDTest() throws IOException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        String OS = System.getProperty("os.name");
        String path = "";
        if (OS.equals("Linux")){
            path = "/home/andrii/.local/share/storj/local-network/storagenode/0/config.yaml";
        }
        else if (OS.substring(0,5).equals("Windo")){
            path = "/home/andrii/.local/share/storj/local-network/storagenode/0/config.yaml";
        }
        else if (OS.substring(0,3).equals("Mac")){
            path = "/Users/andriikotko/Library/Application Support/Storj/Local-Network/storagenode/0/config.yaml";
        }
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String satelliteIDFromFile;

        while ((satelliteIDFromFile = bufferedReader.readLine())!= null){
            if (satelliteIDFromFile.startsWith("storage.whitelisted-satellites:")){
                satelliteIDFromFile=satelliteIDFromFile.substring(32,satelliteIDFromFile.indexOf("@"));
                break;
            }
        }
        nodeDashboardPage.choosingSatelliteContainer.click();
        String satelliteFromPage = nodeDashboardPage.currentSatellite.getText();

        Assert.assertEquals(satelliteFromPage, satelliteIDFromFile);
    }

    @Test
    public void compareWalletAddressTest() throws IOException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        String OS = System.getProperty("os.name");
        String path = "";
        if (OS.equals("Linux")){
            path = "/home/andrii/.local/share/storj/local-network/storagenode/0/config.yaml";
        }
        else if (OS.substring(0,5).equals("Windo")){
            path = "/home/andrii/.local/share/storj/local-network/storagenode/0/config.yaml";
        }
        else if (OS.substring(0,3).equals("Mac")){
            path = "/Users/andriikotko/Library/Application Support/Storj/Local-Network/storagenode/0/config.yaml";
        }
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String walletFromFile;

        while ((walletFromFile = bufferedReader.readLine())!= null){
            if (walletFromFile.startsWith("operator.wallet:")){
                walletFromFile = walletFromFile.substring(17,59);
                break;
            }
        }
        String walletFromPage = nodeDashboardPage.walletData.getText();

        Assert.assertEquals(walletFromPage, walletFromFile);
    }

    @Test
    public void gotoCommunityTest() throws InterruptedException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        nodeDashboardPage.linkToCommunity.click();
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if(browserName.equalsIgnoreCase("safari")){
            Thread.sleep(5000);}

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://forum.storj.io/c/sno-category");
        Assert.assertEquals(driver.findElement(By.cssSelector("#ember21 > span > span > span.badge-category.clear-badge > span")).getText(), "Storage Node Operators");
    }

    @Test
    public void gotoSupportTest() throws InterruptedException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        nodeDashboardPage.linkToSupport.click();
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if(browserName.equalsIgnoreCase("safari")){
            Thread.sleep(5000);}

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://support.storj.io/hc/en-us");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"user-nav\"]/a")).getText(), "Submit a request");
    }

    @Test
    public void gotoViewOnEtherscanTest() throws InterruptedException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        nodeDashboardPage.payoutButton.click();
        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        if(browserName.equalsIgnoreCase("safari")){
            Thread.sleep(5000);}

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
