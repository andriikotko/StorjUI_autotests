package testsNode;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.NodeDashboard.NodeDashboardPage;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
    public void setUp(@Optional("Chrome") String browser) throws Exception {

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
    public void compareSatteliteIDTest() throws IOException {
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        FileReader fileReader = new FileReader("/home/andrii/.local/share/storj/local-network/storagenode/0/config.yaml");
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
        FileReader fileReader = new FileReader("/home/andrii/.local/share/storj/local-network/storagenode/0/config.yaml");
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
    public void gotoCommunityTest(){
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        nodeDashboardPage.linkToCommunity.click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        Assert.assertEquals(driver.getCurrentUrl(),"https://forum.storj.io/c/sno-category");
        Assert.assertEquals(driver.findElement(By.cssSelector("#ember21 > span > span > span.badge-category.clear-badge > span")).getText(), "Storage Node Operators");
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
