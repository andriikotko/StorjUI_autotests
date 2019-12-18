package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.NodeDashboard.NodeDashboardPage;
import pages.Tabs.AccountTab_Billing;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainForExperiments {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println(System.getProperty("os.name"));
//
//      WebDriver driver;
//
//        System.setProperty("webdriver.edge.driver", NodeDashboardPage.EDGEDRIVERPATH);
//        driver = new EdgeDriver();
//        driver.manage().window().setSize(new Dimension(NodeDashboardPage.Width, NodeDashboardPage.Height));
//        driver.get(NodeDashboardPage.DASHBOARDURL);


        //executing bash script
//        Process p;
//        try {
//            String[] cmd = { "sh", "/home/andrii/Downloads/scrips/storj_setup_projectLimit_1.sh"};
//            p = Runtime.getRuntime().exec(cmd);
//            p.waitFor();
//            BufferedReader reader=new BufferedReader(new InputStreamReader(
//                    p.getInputStream()));
//            String line;
//            while((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }

//          ANOTHER WAY EXECUTE BASH SCRIPT
//        Process p;
//
//            String[] cmd = { "sh", "/home/andrii/Downloads/scrips/storj_setup.sh"};
//            p = Runtime.getRuntime().exec(cmd);
//            p.waitFor();
//            BufferedReader reader=new BufferedReader(new InputStreamReader(
//                    p.getInputStream()));
//            String line;
//            while((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//

        //  System.out.println("done");
//        WebDriver driver;
//
//        System.setProperty("webdriver.opera.driver", NodeDashboardPage.OPERADRIVERPATH);
//        driver = new OperaDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(NodeDashboardPage.Width, NodeDashboardPage.Height));
//        driver.get(NodeDashboardPage.DASHBOARDURL);

//
//
//
//        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div"));
//        System.out.println(list.size());
//
//          List<String> list2 = new ArrayList<>();
//        for (WebElement webElement : list) {
//            list2.add(webElement.getText());
//        }
//
//        System.out.println(driver.getCurrentUrl());
//

//
//
//         //GO TO FILE - OPEN AND READ FILE FROM PC
//        FileReader fileReader = new FileReader("/home/andrii/.local/share/storj/local-network/satellite/0/config.yaml");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        String satellitePort;
//
//        while ((satellitePort = bufferedReader.readLine())!= null){
//            if (satellitePort.startsWith("console.address:")){
//                satellitePort=satellitePort.substring(27,32);
//                break;
//            }
//        }
//        System.out.println(satellitePort);


//
        //         connection to databace with SQLITE
        long database_result = 0;
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:/home/andrii/.local/share/storj/local-network/storagenode/0/storage/bandwidth.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select SUM(amount) from bandwidth_usage_rollups");

            System.out.println(rs.getLong(1));
            //database_result = rs.getLong("amount");
            database_result = rs.getLong(1);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(database_result);

        database_result = 12345678;
        String someresult = Double.toString(database_result / 1.0);
        int rozryad = someresult.indexOf(".");
        System.out.println(someresult);
        System.out.println(rozryad);

        String shortValue = "";
        Double shownResult1 = database_result / 1.0;
        String shownResult = "";
        System.out.println(shownResult);
//        if (someresult.indexOf(".")>0){
//            switch (rozryad){
//                case (rozryad<=3 && rozryad>1):
//                    shortValue = " Bytes";
//                    shownResult = Double.toString(shownResult1)+ shortValue;
//                    break;
//                case (rozryad<=6 && rozryad>3):
//                    shortValue = " kB";
//                    shownResult = Math.round((shownResult1/1000)*100.0)/100.0 + shortValue;
//                    break;
//                case rozryad<=9 && rozryad>6:
//                    shortValue = " MB";
//                    shownResult = Math.round((shownResult1/1000000)*100.0)/100.0 + shortValue;
//                    break;
//                case rozryad<=12 && rozryad>9:
//                    shortValue = " GB";
//                    shownResult = Math.round((shownResult1/1000000000)*100.0)/100.0 + shortValue;
//                    break;
//                default:
//                    shownResult = "something went wrong";
//            }
//        }

        if (rozryad <= 3 && rozryad > 1) {
            shortValue = " Bytes";
            shownResult = Double.toString(shownResult1) + shortValue;
            System.out.println(shownResult);
        }


        if (rozryad <= 6 && rozryad > 3) {
            shortValue = " kB";
            shownResult = Math.round((shownResult1 / 1000) * 100.0) / 100.0 + shortValue;
            System.out.println(shownResult);
        }
        if (rozryad <= 9 && rozryad > 6) {
            shortValue = " MB";
            shownResult = Math.round((shownResult1 / 1000000) * 100.0) / 100.0 + shortValue;
            System.out.println(shownResult);

        }
        if (rozryad <= 12 && rozryad > 9) {
            shortValue = " GB";
            shownResult = Math.round((shownResult1 / 1000000000) * 100.0) / 100.0 + shortValue;
            System.out.println(shownResult);
        } else {
            shownResult = "something went wrong";
        }
        System.out.println(shownResult);




        //SCROLL TO ELEMENT
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();",accountTab_billing.depositHistoryViewAllButton);


        // WEBDRIVER WAIT
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));






    }
}


