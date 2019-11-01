package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
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


//        Process p;
//        try {
//            String[] cmd = { "sh", "/home/andrii/Downloads/scrips/storj_setup2.sh"};
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

//
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
        WebDriver driver;

        System.setProperty("webdriver.opera.driver", NodeDashboardPage.OPERADRIVERPATH);
        driver = new OperaDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(NodeDashboardPage.Width, NodeDashboardPage.Height));
        driver.get(NodeDashboardPage.DASHBOARDURL);

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
//        // connection to databace with SQLITE
//        int database_result =0;
//        Connection conn = null;
//        try {
//            // db parameters
//            String url = "jdbc:sqlite:/home/andrii/.local/share/storj/local-network/storagenode/0/storage/bandwidth.db";
//            // create a connection to the database
//            conn = DriverManager.getConnection(url);
//
//            System.out.println("Connection to SQLite has been established.");
//
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("select amount from bandwidth_usage_rollups");
//            System.out.println(rs.getInt("amount"));
//            database_result = rs.getInt("amount");
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//
//        System.out.println(database_result);
    }
}


