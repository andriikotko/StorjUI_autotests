package pages;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

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
import java.nio.charset.StandardCharsets;
import org.postgresql.jdbc4.Jdbc4Connection;
import pages.Tabs.AccountTab_PaymentMethods;


import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.jayway.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static com.jayway.restassured.RestAssured.given;

public class MainForExperiments {
    public static void main(String[] args) throws InterruptedException, IOException {

//        RestAssured.baseURI = "http://127.0.0.1:10002/";
//        Response response = given().
//                headers("cookie","_tokenKey=eyJpZCI6IjJhYTMxOGMyLTlmODItNDU3MC05MjZkLTVkZDdkZTI1NDc1YSIsImV4cGlyZXMiOiIyMDIwLTAyLTA0VDEyOjQzOjQ1LjIwNTQ3NzU3NiswMjowMCJ9Cg==.dACXbnCInzqj4qhKEn-IDCqFNLpkby-aVN7ojyvtR2c=").
//                log().all().
//                when().get("/api/v0/payments/cards").
//                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().log().status().
//                extract().response();
//
//        String responceToString = response.asString();
//        System.out.println(responceToString);
//
//        JsonPath jsonPath = new JsonPath(String.valueOf(response));
//        String cardID = jsonPath.get("[0].expMonth");
//        System.out.println(cardID);


        for (int i = 0; i <150 ; i++) {


        RestAssured.baseURI = "http://192.168.1.23:8080";
        Response response = given().
                log().all().
                when().get("/solutions").
                then().assertThat().statusCode(200).
                extract().response();

        String responceToString = response.asString();
        System.out.println(responceToString);}








//        System.out.println(System.getProperty("os.name"));
//
//      WebDriver driver;
//
//        System.setProperty("webdriver.edge.driver", NodeDashboardPage.EDGEDRIVERPATH);
//        driver = new EdgeDriver();
//        driver.manage().window().setSize(new Dimension(NodeDashboardPage.Width, NodeDashboardPage.Height));
//        driver.get(NodeDashboardPage.DASHBOARDURL);


        // REQUEST FOR SECRET WITH HTTP CLIENT

//        final HttpClient httpClient = new HttpClient();
//        final String url = "http://localhost:10002/registrationToken/?projectsLimit=2";
//        final String token = " secure_token";
//        String secret = "";
//
//        try (final Response response = httpClient.post(url, "", token)) {
//            if (response.code() == 200) {
//                System.out.println(response.body().toString());
//                secret = response.body().string();}
//
//            }
//
//        secret = (secret.split("\""))[3];



        // CURL REQUEST
//
//        String command = "curl --header \"Authorization: secure_token\" http://localhost:10002/registrationToken/?projectsLimit=2" ;
//        Process process = Runtime.getRuntime().exec(command);
//        BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
//        System.out.println(process.exitValue());
//        String strTemp = "";
//        while (null != (strTemp = br.readLine())) {
//            System.out.println(strTemp);}
//
//        process.destroy();


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
//        long database_result = 0;
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
//            ResultSet rs = stmt.executeQuery("select SUM(amount) from bandwidth_usage_rollups");
//
//            System.out.println(rs.getLong(1));
//            //database_result = rs.getLong("amount");
//            database_result = rs.getLong(1);
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
//
//        database_result = 12345678;
//        String someresult = Double.toString(database_result / 1.0);
//        int rozryad = someresult.indexOf(".");
//        System.out.println(someresult);
//        System.out.println(rozryad);
//
//        String shortValue = "";
//        Double shownResult1 = database_result / 1.0;
//        String shownResult = "";
//        System.out.println(shownResult);


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
//
//        if (rozryad <= 3 && rozryad > 1) {
//            shortValue = " Bytes";
//            shownResult = Double.toString(shownResult1) + shortValue;
//            System.out.println(shownResult);
//        }
//
//
//        if (rozryad <= 6 && rozryad > 3) {
//            shortValue = " kB";
//            shownResult = Math.round((shownResult1 / 1000) * 100.0) / 100.0 + shortValue;
//            System.out.println(shownResult);
//        }
//        if (rozryad <= 9 && rozryad > 6) {
//            shortValue = " MB";
//            shownResult = Math.round((shownResult1 / 1000000) * 100.0) / 100.0 + shortValue;
//            System.out.println(shownResult);
//
//        }
//        if (rozryad <= 12 && rozryad > 9) {
//            shortValue = " GB";
//            shownResult = Math.round((shownResult1 / 1000000000) * 100.0) / 100.0 + shortValue;
//            System.out.println(shownResult);
//        } else {
//            shownResult = "something went wrong";
//        }
//        System.out.println(shownResult);


        //SCROLL TO ELEMENT
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();",accountTab_billing.depositHistoryViewAllButton);


        // WEBDRIVER WAIT
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.visibilityOf(loginPage.notificationArea));

            // CONNECTION TO POSTGRESql
//        Connection conn = null;
//        try {// db parameters
//            String url = "jdbc:postgresql://localhost/test123?sslmode=disable";
//            // create a connection to the database
//            conn = DriverManager.getConnection(url, "postgres", "postgres");
//
//            System.out.println("Connection to postgresql has been established.");
//
//            String schema = "satellite/0";
//
//            Statement stmt = conn.createStatement();
//
//            stmt.execute("set search_path to '" + schema + "'");
//
//            System.out.println("done");
//
//            ResultSet rs = stmt.executeQuery("select email from users where short_name like 'shortName2%'");
//
//            while (rs.next()){
//                String mail = rs.getString("email");
//                System.out.println(mail);
//            }
//            //database_result = rs.getLong("amount");
//           // database_result = rs.getLong(1);
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


           //  ADD USER CARD AND PROJECT / INCREASING LIMITS
//        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
//        //create chrome instance
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
//
//        for (int i = 1; i < 113; i++) {
//            // login
//
//            try {
//                driver.get(HomePage.HOMEURL);
//                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//                Thread.sleep(500);
//                // This is to Instantiate Home Page and LogIn Page class
//                HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//                LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
//                // Once both classes Initialised, use their Web Element Objects
//                LoginPage.userNameField.sendKeys("test"+i+"@g.com");
//                LoginPage.passwordField.sendKeys("123qwe");
//                LoginPage.btn_Login.click();
//                //Thread.sleep(4500);
//
//
//                homePage.billingTab.click();
//                AccountTab_PaymentMethods accountTab_paymentMethods = PageFactory.initElements(driver, AccountTab_PaymentMethods.class);
//                accountTab_paymentMethods.addCreditCard();
//                WebDriverWait wait = new WebDriverWait(driver, 30);
//                wait.until(ExpectedConditions.visibilityOf(LoginPage.notificationArea));
//
//                homePage.createNewProject();
//                System.out.println(i);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//
//
//        }




    }
}


