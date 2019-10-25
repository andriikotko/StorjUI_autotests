package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.Tabs.AccountTab_Billing;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainForExperiments {
    public static void main(String[] args) throws InterruptedException, IOException {


        Process p;
        try {
            String[] cmd = { "sh", "/home/andrii/Downloads/scrips/storj_setup2.sh"};
            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            BufferedReader reader=new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

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

        System.out.println("done");
//        WebDriver driver;
//
//        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);
//
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        //driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
//        driver.manage().window().maximize();
//        driver.get(HomePage.HOMEURL);
//
//        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);
//
//        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
//        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
//        LoginPage.btn_Login.click();
//        Thread.sleep(4500);
//
//        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//        homePage.billingTab.click();
//        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);
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

//        FileReader fileReader = new FileReader("/home/andrii/.local/share/storj/local-network/storagenode/0/config.yaml");
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//
//        String satelliteID;
//
//        while ((satelliteID = bufferedReader.readLine())!= null){
//            if (satelliteID.startsWith("storage.whitelisted-satellites:")){
//                satelliteID=satelliteID.substring(32,83);
//                break;
//            }
//        }
//        System.out.println(satelliteID);


    }
}

