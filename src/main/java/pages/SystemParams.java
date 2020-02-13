package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;


public class SystemParams {
    public static String CHROMEDRIVERPATH = "./src/main/resources/chromedriver";
    public static String CHROMEDRIVERPATHWIN = "./src/main/resources/chromedriver.exe";
    public static String CHROMEDRIVERPATHMAC = "./src/main/resources/chromedrivermac";
    public static String GECKODRIVERPATH = "./src/main/resources/geckodriver";
    public static String GECKODRIVERPATHWIN = "./src/main/resources/geckodriver.exe";
    public static String OPERADRIVERPATH = "./src/main/resources/operadriver";
    public static String OPERADRIVERPATHWIN = "./src/main/resources/operadriver.exe";
    public static String EDGEDRIVERPATHMAC = "./src/main/resources/msedgedriver";
    public static String SAFARIDRIVERPATHMAC = "./src/main/resources/safaridriver";
    WebDriver driver;
    public SystemParams(WebDriver driver){

        this.driver = driver;

    }




    public WebDriver selecting(  String browser) throws Exception {

        String OS = System.getProperty("os.name");
        String chosingOS = "";
        if (OS.equals("Linux")) {
            switch (browser) {
                case "Firefox":
                    chosingOS = GECKODRIVERPATH;
                    System.setProperty("webdriver.gecko.driver", chosingOS);
                    driver = new FirefoxDriver();
                    break;
                case "Chrome":
                    chosingOS = CHROMEDRIVERPATH;
                    System.setProperty("webdriver.chrome.driver", chosingOS);
                    driver = new ChromeDriver();
                    break;
                case "Opera":
                    chosingOS = OPERADRIVERPATH;
                    System.setProperty("webdriver.opera.driver", chosingOS);
                    driver = new OperaDriver();
                    break;

                default:
                    chosingOS = "";
            }
        } else if (OS.substring(0, 4).equals("Windo")) {
            switch (browser) {
                case "Firefox":
                    chosingOS = GECKODRIVERPATHWIN;
                    System.setProperty("webdriver.gecko.driver", chosingOS);
                    driver = new FirefoxDriver();
                    break;
                case "Chrome":
                    chosingOS = CHROMEDRIVERPATHWIN;
                    System.setProperty("webdriver.chrome.driver", chosingOS);
                    driver = new ChromeDriver();
                    break;
                case "Opera":
                    chosingOS = OPERADRIVERPATHWIN;
                    System.setProperty("webdriver.opera.driver", chosingOS);
                    driver = new OperaDriver();
                    break;
                default:
                    chosingOS = "";
            }
        } else if (OS.substring(0, 3).equals("Mac")) {
            switch (browser) {
                case "Firefox":
                    chosingOS = GECKODRIVERPATH;
                    System.setProperty("webdriver.gecko.driver", chosingOS);
                    driver = new FirefoxDriver();
                    break;
                case "Chrome":
                    chosingOS = CHROMEDRIVERPATHMAC;
                    System.setProperty("webdriver.chrome.driver", chosingOS);
                    driver = new ChromeDriver();
                    break;
                case "Opera":
                    chosingOS = OPERADRIVERPATHWIN;
                    System.setProperty("webdriver.opera.driver", chosingOS);
                    driver = new OperaDriver();
                    break;
                case "Safari":
                    chosingOS = SAFARIDRIVERPATHMAC;
                    System.setProperty("webdriver.safari.driver", chosingOS);
                    driver = new SafariDriver();
                    break;
                default:
                    chosingOS = "";
            }

        } else {
            //If no os passed throw exception
            throw new Exception("os is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.get(HomePage.HOMEURL);
        System.out.println(driver);
        return driver;
    }

}
