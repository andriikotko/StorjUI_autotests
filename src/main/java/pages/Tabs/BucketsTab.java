package pages.Tabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BucketsTab {
    final WebDriver driver;

    public BucketsTab(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/p")
    public WebElement bucketsHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div/svg/rect")
    public WebElement bucketsNotificationIcon;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div/p")
    public WebElement bucketsNOtificationText;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/div/input")
    public WebElement bucketsSearch;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div[1]/p")
    public WebElement bucketNameHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div[2]/p")
    public WebElement storageUsedHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div[3]/p")
    public WebElement egressUsedHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[1]/div[4]/p")
    public WebElement objectsStoredHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]")
    public WebElement firstBucketNameValue;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]")
    public WebElement firstBucketStorageUsed;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div[1]/div[3]")
    public WebElement firstBucketEgressUsed;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div[1]/div[4]")
    public WebElement firstBucketObjectsStored;


    ///BUCKETS TAB FOR PROJECT WITHOUT BUCKETS

    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/svg/path[1]")
    public WebElement noBucketsHeaderIcon;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]/h1")
    public WebElement noBucketsHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/p[1]")
    public WebElement noBucketsHeaderNotification;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/p[2]")
    public WebElement noBucketsHowCreateHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div/h2")
    public WebElement noBucketsUplinkCLI;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div/p")
    public WebElement noBucketsCreateUplinkNotification;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/div/a")
    public WebElement noBucketsLinkToDocumentation;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[3]/img")
    public WebElement noBucketsImage;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/p[3]/a")
    public WebElement noBucketsLinkToS3;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/h2")
    public WebElement noBucketsNextStepHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div[2]/p")
    public WebElement noBucketsNextStepText;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/p[3]")
    public WebElement noBucketsTextBeforeLinkS3;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[4]/div[1]")
    public WebElement noBucketsIconNextStep;



    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]")
    public WebElement bucketsDiv;
}
