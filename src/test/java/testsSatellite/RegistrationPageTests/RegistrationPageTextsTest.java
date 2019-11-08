package testsSatellite.RegistrationPageTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.RegistrationPage;

public class RegistrationPageTextsTest {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {

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
            System.setProperty("webdriver.gecko.driver", HomePage.GECKODRIVERPATH+chosingOS);
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if(browser.equalsIgnoreCase("Chrome")){
            //set path to chromedriver.exe
            System.setProperty("webdriver.chrome.driver",HomePage.CHROMEDRIVERPATH+chosingOS);
            //create chrome instance
            driver = new ChromeDriver();
        }
        //  Check if parameter passed as 'Opera'
        else if(browser.equalsIgnoreCase("Opera")){
            //set path to Edge.exe
            System.setProperty("webdriver.opera.driver", HomePage.OPERADRIVERPATH+chosingOS);
            driver = new OperaDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.get(HomePage.REGISTERURL);
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(registrationPage.logoStorj));
    }

    @Test
    public void registrationElementsVisibilityTest(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

        Assert.assertTrue(registrationPage.fullNameInput.getAttribute("placeholder").endsWith("Enter Full Name"));
        Assert.assertTrue(registrationPage.nicknameInput.getAttribute("placeholder").endsWith("Enter Nickname"));
        Assert.assertTrue(registrationPage.emailInput.getAttribute("placeholder").endsWith("Enter Email"));
        Assert.assertTrue(registrationPage.passwordInput.getAttribute("placeholder").endsWith("Enter Password"));
        Assert.assertTrue(registrationPage.repeatPasswordInput.getAttribute("placeholder").endsWith("Confirm Password"));
        Assert.assertEquals(registrationPage.createAccountButton.getText(),"Create Account");
        Assert.assertEquals(registrationPage.loginButton.getText(),"Login");
        Assert.assertEquals(registrationPage.signUpHeader.getText(),"Sign Up to Storj");
        Assert.assertEquals(registrationPage.fullNameHeader.getText(), "Full Name");
        Assert.assertEquals(registrationPage.nicknameHeader.getText(),"Nickname");
        Assert.assertEquals(registrationPage.emailHeader.getText(),"Email");
        Assert.assertEquals(registrationPage.passwordHeader.getText(),"Password");
        Assert.assertEquals(registrationPage.confirmPasswordHeader.getText(), "Confirm Password");
//        Assert.assertTrue(registrationPage.hintBoxPassword.isDisplayed());
//        Assert.assertTrue(registrationPage.passwordInfoButton.isDisplayed());
//        Assert.assertTrue(registrationPage.hintBoxConfirmPassword.isDisplayed());  - in special test
//        Assert.assertTrue(registrationPage.confirmPasswordInfoButton.isDisplayed());
        Assert.assertEquals(registrationPage.termsConditionsHeader.getText(),"I agree to the Terms & Conditions");
        Assert.assertTrue(registrationPage.termsConditionsLink.getAttribute("href").endsWith("https://tardigrade.io/terms-of-use/"));
    }

    @Test
    public void registrationPasswordHintTextTest(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        Actions actions = new Actions(driver);
        actions.moveToElement(registrationPage.hintBoxPassword).click().perform();

        Assert.assertEquals(registrationPage.passwordInfoButton.getText(), "Use 6 or more characters with a mix of letters, numbers & symbols");
    }
    @Test
    public void registrationConfirmPasswordHintTextTest(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        Actions actions = new Actions(driver);
        actions.moveToElement(registrationPage.hintBoxConfirmPassword).click().perform();

        Assert.assertEquals(registrationPage.confirmPasswordInfoButton.getText(), "Use 6 or more characters with a mix of letters, numbers & symbols");
    }




    @AfterMethod
    public void tearDown()
    {driver.quit();}


}
