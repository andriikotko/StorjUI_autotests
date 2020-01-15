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


    @FindBy(how = How.XPATH, using = "//*[@class=\"buckets-header__title\"]")
    public WebElement bucketsHeader;
    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[2]/div/svg/rect")
    public WebElement bucketsNotificationIcon;
    @FindBy(how = How.XPATH, using = "//*[@class=\"buckets-notification__text\"]")
    public WebElement bucketsNOtificationText;
    @FindBy(how = How.XPATH, using = "//*[@class=\"common-search-input\"]")
    public WebElement bucketsSearch;
    @FindBy(how = How.XPATH, using = "//*[text() = \"Bucket Name\"]")
    public WebElement bucketNameHeader;
    @FindBy(how = How.XPATH, using = "//*[text() = \"Storage Used, GB\"]")
    public WebElement storageUsedHeader;
    @FindBy(how = How.XPATH, using = "//*[text() = \"Egress Used, GB\"]")
    public WebElement egressUsedHeader;
    @FindBy(how = How.XPATH, using = "//*[text() = \"Objects Stored\"]")
    public WebElement objectsStoredHeader;
    @FindBy(how = How.XPATH, using = "//*[@class = \"container item-component__item\"][1]/div[1]")
    public WebElement firstBucketNameValue;
    @FindBy(how = How.XPATH, using = "//*[@class = \"container item-component__item\"][1]/div[2]")
    public WebElement firstBucketStorageUsed;
    @FindBy(how = How.XPATH, using = "//*[@class = \"container item-component__item\"][1]/div[3]")
    public WebElement firstBucketEgressUsed;
    @FindBy(how = How.XPATH, using = "//*[@class = \"container item-component__item\"][1]/div[4]")
    public WebElement firstBucketObjectsStored;


    ///BUCKETS TAB FOR PROJECT WITHOUT BUCKETS

    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-numbers-area\"]")
    public WebElement noBucketsStepsImage;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__header__title\"]")
    public WebElement noBucketsHeader;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__header__sub-title\"]")
    public WebElement noBucketsHeaderNotification;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__setup__title\"]")
    public WebElement noBucketsHowCreateHeader1;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__upload__title\"]")
    public WebElement noBucketsHowCreateHeader2;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__usage__title\"]")
    public WebElement noBucketsHowCreateHeader3;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__setup__container__address-info\"]")
    public WebElement noBucketsSetupContainer1;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__upload__container\"]")
    public WebElement noBucketsSetupContainer2;
    @FindBy(how = How.XPATH, using = "//*[@class = \"usage-icon\"]")
    public WebElement noBucketsSetupContainer3;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__footer__button\"]")
    public WebElement noBucketsCreateFirstButton;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__footer__button__label\"]")
    public WebElement noBucketsCreateFirstButtonText;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__footer__help\"]")
    public WebElement noBucketsLinkToWhy;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__setup__container__address-info\"]")
    public WebElement noBucketsSetupStep1;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__setup__container__api-key-info\"]")
    public WebElement noBucketsSetupStep2;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__setup__container__api-key\"]")
    public WebElement noBucketsSetupStep3;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__upload__container__command\"][1]")
    public WebElement noBucketsUploadStep1;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__upload__container__command\"][2]")
    public WebElement noBucketsUploadStep2;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__upload__container__command\"][3]")
    public WebElement noBucketsUploadStep3;
    @FindBy(how = How.XPATH, using = "//*[@class = \"no-buckets-area__steps-area__upload__container__command\"][4]")
    public WebElement noBucketsUploadStep4;



    @FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div[2]/div[2]/div/div/div[1]")
    public WebElement bucketsDiv;
}
