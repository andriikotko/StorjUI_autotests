package testsNode;

import org.openqa.selenium.Dimension;
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
import pages.NodeDashboard.NodePayouts;

import java.util.concurrent.TimeUnit;

import static pages.HomePage.DefaultBrowser;

public class NodePayoutsTests {
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
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        nodeDashboardPage.linkToPayouts.click();

    }

    @Test
    public void nodePayoutsElementsVisibilityYTest (){
        NodePayouts nodePayoutsPage = PageFactory.initElements(driver, NodePayouts.class);
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        Assert.assertTrue(nodePayoutsPage.allSatellites.isDisplayed());
        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.chooseFirstSatellite();

        Assert.assertTrue(nodePayoutsPage.backToMainPage.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutInformationHeader.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.choosingSatelliteContainer.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.chosenSatelliteText.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.satelliteDropdown.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.currentSatellite.isDisplayed());

        Assert.assertTrue(nodePayoutsPage.payoutSectionHeader.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableInfoEstimation.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTablePeriodDropList.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableHeaderName.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableHeaderType.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableHeaderPrice.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableHeaderDisk.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableHeaderBandwidth.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableHeaderPayouts.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDowload_Name.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableRepaiAudit_Name.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDiskMonth_Name.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableGrossTotal_Name.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableTotal_Name.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDownload_Type.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableRepairAudit_Type.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDiskMonth_Type.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDownload_Price.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableRepairAudit_Price.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDiskMonth_Price.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDownload_Disk.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableRepairAudit_Disk.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDiskMonth_Disk.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableTotal_Disk.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDownload_Bandwidth.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableRepairAudit_Bandwidth.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDiskAverage_Bandwidth.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableTotal_Bandwidth.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableDownload_Payout.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableRepairaudit_Payout.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableTDiskMonth_Payout.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableGrossTotal_Payout.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableTotal_Payout.isDisplayed());


        Actions action = new Actions(driver);
        action.moveToElement(nodePayoutsPage.heldAmountTotal_value).click().perform();

        Assert.assertTrue(nodePayoutsPage.payoutTableHeldback_Name.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableHeldback_Payout.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.heldAmountSectionHeader.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.heldAmountText.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.heldAmountLink.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.heldAmountRate_value.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.heldAmountRate_Label.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.heldAmountTotal_value.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.heldAmountTotal_label.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.heldAmountProgress.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.heldAmountMonthOnNetwork.isDisplayed());
    }

    @Test
    public void nodePayoutsElementsTextsTests(){
        NodePayouts nodePayoutsPage = PageFactory.initElements(driver, NodePayouts.class);
        NodeDashboardPage nodeDashboardPage = PageFactory.initElements(driver, NodeDashboardPage.class);
        Assert.assertEquals(nodePayoutsPage.allSatellites.getText(),"Choose your satellite: All Satellites");
        nodeDashboardPage.choosingSatelliteContainer.click();
        nodeDashboardPage.chooseFirstSatellite();


        Assert.assertEquals(nodePayoutsPage.payoutInformationHeader.getText(),"Payout Information");

        Assert.assertEquals(nodePayoutsPage.chosenSatelliteText.getText(),"Choose your satellite:");

        Assert.assertEquals(nodePayoutsPage.currentSatellite.getText(),"Choose your satellite: 127.0.0.1:10010");

        Assert.assertEquals(nodePayoutsPage.payoutSectionHeader.getText(),"Payout");
        Assert.assertTrue(nodePayoutsPage.payoutTableInfoEstimation.getText().startsWith("Info & Estimation"));
       // Assert.assertTrue(nodePayoutsPage.payoutTablePeriodDropList.isDisplayed());
        Assert.assertEquals(nodePayoutsPage.payoutTableHeaderName.getText(),"Name");
        Assert.assertEquals(nodePayoutsPage.payoutTableHeaderType.getText(),"Type");
        Assert.assertEquals(nodePayoutsPage.payoutTableHeaderPrice.getText(),"Price");
        Assert.assertEquals(nodePayoutsPage.payoutTableHeaderDisk.getText(),"Disk");
        Assert.assertEquals(nodePayoutsPage.payoutTableHeaderBandwidth.getText(),"Bandwidth");
        Assert.assertEquals(nodePayoutsPage.payoutTableHeaderPayouts.getText(),"Payout");
        Assert.assertEquals(nodePayoutsPage.payoutTableDowload_Name.getText(),"Download");
        Assert.assertEquals(nodePayoutsPage.payoutTableRepaiAudit_Name.getText(),"Repair & Audit");
        Assert.assertEquals(nodePayoutsPage.payoutTableDiskMonth_Name.getText(),"Disk Average Month");
        Assert.assertEquals(nodePayoutsPage.payoutTableGrossTotal_Name.getText(),"Gross Total");
        Assert.assertEquals(nodePayoutsPage.payoutTableTotal_Name.getText(),"TOTAL");
        Assert.assertEquals(nodePayoutsPage.payoutTableDownload_Type.getText(),"Egress");
        Assert.assertEquals(nodePayoutsPage.payoutTableRepairAudit_Type.getText(),"Egress");
        Assert.assertEquals(nodePayoutsPage.payoutTableDiskMonth_Type.getText(),"Storage");
        Assert.assertEquals(nodePayoutsPage.payoutTableDownload_Price.getText(),"$20 / TB");
        Assert.assertEquals(nodePayoutsPage.payoutTableRepairAudit_Price.getText(),"$10 / TB");
        Assert.assertEquals(nodePayoutsPage.payoutTableDiskMonth_Price.getText(),"$1.5 / TBm");
        Assert.assertEquals(nodePayoutsPage.payoutTableDownload_Disk.getText(),"--");
        Assert.assertEquals(nodePayoutsPage.payoutTableRepairAudit_Disk.getText(),"--");
        Assert.assertTrue(nodePayoutsPage.payoutTableDiskMonth_Disk.isDisplayed());
        Assert.assertTrue(nodePayoutsPage.payoutTableTotal_Disk.getText().endsWith("h"));
        Assert.assertTrue(nodePayoutsPage.payoutTableDownload_Bandwidth.getText().contains("B"));
        Assert.assertTrue(nodePayoutsPage.payoutTableRepairAudit_Bandwidth.getText().contains("B"));
        Assert.assertEquals(nodePayoutsPage.payoutTableDiskAverage_Bandwidth.getText(),"--");
        Assert.assertTrue(nodePayoutsPage.payoutTableTotal_Bandwidth.getText().contains("B"));
        Assert.assertTrue(nodePayoutsPage.payoutTableDownload_Payout.getText().startsWith("$"));
        Assert.assertTrue(nodePayoutsPage.payoutTableRepairaudit_Payout.getText().startsWith("$"));
        Assert.assertTrue(nodePayoutsPage.payoutTableTDiskMonth_Payout.getText().startsWith("$"));
        Assert.assertTrue(nodePayoutsPage.payoutTableGrossTotal_Payout.getText().startsWith("$"));
        Assert.assertTrue(nodePayoutsPage.payoutTableTotal_Payout.getText().startsWith("$"));


        Actions action = new Actions(driver);
        action.moveToElement(nodePayoutsPage.heldAmountTotal_value).click().perform();

        Assert.assertEquals(nodePayoutsPage.payoutTableHeldback_Name.getText(),"Held Back");
        Assert.assertTrue(nodePayoutsPage.payoutTableHeldback_Payout.getText().startsWith("-$"));
        Assert.assertEquals(nodePayoutsPage.heldAmountSectionHeader.getText(),"Held Amount");
        Assert.assertEquals(nodePayoutsPage.heldAmountText.getText(),"Learn more about held back here");
        Assert.assertEquals(nodePayoutsPage.heldAmountLink.getAttribute("href"),"https://documentation.storj.io/resources/faq/held-back-amount");
        Assert.assertTrue(nodePayoutsPage.heldAmountRate_value.getText().endsWith("%"));
        Assert.assertEquals(nodePayoutsPage.heldAmountRate_Label.getText(),"Held Amount Rate");
        Assert.assertTrue(nodePayoutsPage.heldAmountTotal_value.getText().startsWith("$"));
        Assert.assertEquals(nodePayoutsPage.heldAmountTotal_label.getText(),"Total Held Amount");

        Assert.assertTrue(nodePayoutsPage.heldAmountMonthOnNetwork.getText().startsWith("It is your"));
    }




    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
