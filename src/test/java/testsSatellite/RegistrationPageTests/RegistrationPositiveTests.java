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
import pages.SystemParams;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegistrationPositiveTests {
    public static WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
    public void setUp( @Optional("Chrome") String browser) throws Exception {
        SystemParams systemParams = new SystemParams(driver);
        driver = systemParams.selecting(browser);

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
