package pages.NodeDashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NodeDashboardPage {
    WebDriver driver;

    public NodeDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public static String DASHBOARDURL = "http://localhost:13002";
    public static String CHROMEDRIVERPATH = "./src/main/resources/chromedriver";
    public static Integer Width = 1280;
    public static Integer Height = 1000;


    @FindBy (how = How.XPATH, using = "//*[@id=\"app\"]/div/div[1]/div/div[1]/svg")
    public WebElement dasboardStorjLogo;
}
