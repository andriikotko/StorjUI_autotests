package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.Tabs.AccountTab_Billing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainForExperiments {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", HomePage.CHROMEDRIVERPATH);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().setSize(new Dimension(HomePage.Width, HomePage.Height));
        driver.manage().window().maximize();
        driver.get(HomePage.HOMEURL);

        LoginPage LoginPage = PageFactory.initElements(driver, LoginPage.class);

        LoginPage.userNameField.sendKeys(pages.HomePage.ACCOUNT);
        LoginPage.passwordField.sendKeys(pages.HomePage.PASSWORD);
        LoginPage.btn_Login.click();
        Thread.sleep(4500);

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.billingTab.click();
        AccountTab_Billing accountTab_billing = PageFactory.initElements(driver, AccountTab_Billing.class);



        List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div[2]/div[3]/div"));
        System.out.println(list.size());

          List<String> list2 = new ArrayList<>();
        for (WebElement webElement : list) {
            list2.add(webElement.getText());
        }

        System.out.println(driver.getCurrentUrl());


    }
}

