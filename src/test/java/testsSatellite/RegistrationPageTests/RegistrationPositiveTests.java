package testsSatellite.RegistrationPageTests;

import okhttp3.Response;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.HttpClient;
import pages.RegistrationPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegistrationPositiveTests {
    public static WebDriver driver;
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(HomePage.Width,HomePage.Height));
        driver.get(HomePage.REGISTERURL);
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown()
    {driver.quit();}

    @Test
    public void backToLoginPageTest(){
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);

        registrationPage.loginButton.click();

        Assert.assertTrue(driver.getCurrentUrl().endsWith("/login"));
    }

    @Test
    public void validRegistrationTest() throws IOException, InterruptedException {
        RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);


        final HttpClient httpClient = new HttpClient();
        final String url = "http://localhost:10002/registrationToken/?projectsLimit=2";
        final String token = " secure_token";
        String secret = "";

        try (final Response response = httpClient.post(url, "", token)) {
            if (response.code() == 200) {
                secret = response.body().string();}
            }
        secret = (secret.split("\""))[3];
        driver.get(HomePage.REGISTERURL+"?token="+secret);
        Thread.sleep(2000);

        registrationPage.fullNameInput.sendKeys("testFullName");
//        registrationPage.nicknameInput.sendKeys("testShortName");
        registrationPage.emailInput.sendKeys("testNewEmail"+(Math.random()*100) +"@gmail.com");
        registrationPage.passwordInput.sendKeys("Welcome123");
        registrationPage.repeatPasswordInput.sendKeys("Welcome123");
        registrationPage.termsConditionsCheckbox.click();
        registrationPage.createAccountButton.click();

        Thread.sleep(1000);

        Assert.assertTrue(registrationPage.checkEmailLogo.isDisplayed());
        Assert.assertTrue(registrationPage.checkEmailClose.isDisplayed());
        Assert.assertTrue(registrationPage.checkEmailTimer.isDisplayed());
        Assert.assertEquals(registrationPage.checkEmailHeader.getText(), "Check your inbox for your verification email");
        Assert.assertTrue(registrationPage.checkEmailText.getText().startsWith("Didn’t receive a verification email?"));
        Assert.assertEquals(registrationPage.checkEmailResendButton.getText(), "Resend Email");
       // Assert.assertFalse(registrationPage.checkEmailResendButton.isEnabled());


    //    Assert.assertTrue(registrationPage.errorNotification.getText().endsWith("we are unable to create your account. This is an invite-only alpha, please join our waitlist to receive an invitation"));



    }
}
