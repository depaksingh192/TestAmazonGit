package AmazonTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import userdefinedfunctions.pageobjectmodel.BaseScreen;
import userdefinedfunctions.pageobjectmodel.CustomReporter;
import userdefinedfunctions.pageobjectmodel.CustomListeners;
import utility.Logger;

@Listeners({CustomReporter.class, CustomListeners.class})

public class TestAmazonMobile extends BaseScreen {

    private static final By MOBILE_TAB = By.xpath("//*[@id='nav-xshop-container']//following-sibling::div[@class='nav-div' and *[contains(text(),'Mobiles')]]");
    private static final By FILTER_CATEGORY_NEW = By.xpath("(//*[@id='s-refinements']//*[contains(text(),'Item Condition')]/parent::*//following-sibling::ul//li//*[@type='checkbox'])[1]//following-sibling::*[@class='a-icon a-icon-checkbox']");
    private static final By FILTER_CATEGORY_PRICE = By.xpath("//*[@id='s-refinements']//*[contains(text(),'Price')]/ancestor::*[contains(@class, 'a-section')]//li//*[contains(text(),'₹10,000 - ₹20,000')]");
    private static final By TABS_MOBILE_ACC = By.xpath("//*[@id='nav-subnav']//*[contains(@class,'nav-a') and contains(text(),'Mobiles & Accessories')]");
    private static final By MOBILES_LINK = By.xpath("//*[@class='nav-fullWidthSubnavFlyout nav-flyout']//*[contains(@href,'Aelectronic') and contains(text(),'Mobiles')]");
    private static final By SEE_ALL_MOBILE_BUTTON = By.xpath("//*[contains(@id,'CardInstance')]//*[contains(@class,'search-result-card')]//*[contains(@href,'electronics')]");
    private static final By RETURNS_AND_ORDERS = By.xpath("//*[@id='nav-tools']//*[contains(@href,'order-history')]");
    private static final By CREATEACC_BUTTON = By.xpath("//*[@class='a-section a-spacing-base']//*[contains(@id,'createAccountSubmit') and contains(text(),'Create')]");
    private static final By FORM_NAME = By.xpath("//*[contains(@id,'ap_register_form')]//input[contains(@id,'customer_name')]");
    private static final By FORM_EMAIL = By.xpath("//*[contains(@id,'ap_register_form')]//input[contains(@id,'email')]");
    private static final By FORM_PASS = By.xpath("//*[contains(@id,'ap_register_form')]//input[@name='password']");
    private static final By FORM_PASS_AGAIN = By.xpath("//*[contains(@id,'ap_register_form')]//input[@name='passwordCheck']");
    private static final By FORM_SUBMIT = By.xpath("//*[contains(@id,'ap_register_form')]//input[contains(@type,'submit')]");
    private static final By ALERT_INVALID_EMAIL= By.xpath("//*[contains(@id,'ap_register_form')]//*[contains(@class,'alert-content') and contains(text(),'Enter a valid email address')]");
    private static final By LOCATION_BUTTON =By.xpath("//*[@id='nav-global-location-slot']");
    private static final By INPUT_ZIP = By.xpath("//*[@class='a-popover-wrapper GLUX_Popover']//*[contains(@id,'ZipInput')]//input[contains(@type,'text')]");
    private static final By APPLY_BUTTON = By.xpath("//*[@class='a-popover-wrapper GLUX_Popover']//*[contains(@id,'ZipInput')]//*[contains(@type,'submit')]");
    		
    private Logger logger;

    @BeforeClass
    public void setUp() {
        logger = new Logger(BaseScreen.class); // Initialize the logger
        logger.info("Start the tests for Mobilescreen");

        setUpDriver(); // Initialize WebDriver
        implicitlyWait(20); // Set implicit wait
        getDriver().get("https://www.amazon.in"); // Navigate to the URL

        // Set the WebDriver instance in the CustomListeners class
        CustomListeners.setDriver(getDriver());
    }

    @Test(priority = 1, groups = {"Mobiles"})
    public void clickAndOpenMobile() throws InterruptedException {
        WebElement MobileTab = getDriver().findElement(MOBILE_TAB);
        Click(MobileTab);

        validateHardAssertion(getTitle(), "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in");
        Thread.sleep(1000);
    }

    @Test(priority = 2, groups = {"Mobiles"})
    public void filterNewMobileAndRange() {
        WebElement MobileNew = getDriver().findElement(FILTER_CATEGORY_NEW);
        explicitWaitElementClickable(1000, MobileNew);

        Click(getDriver().findElement(FILTER_CATEGORY_PRICE));
    }

    @Test(priority = 3, groups = {"Mobiles"})
    public void hoverMobileTab() {
        WebElement MobileTab = getDriver().findElement(TABS_MOBILE_ACC);
        hoveroverElement(MobileTab);

        WebElement MobileLink = getDriver().findElement(MOBILES_LINK);
        Click(MobileLink);
    }

    @Test(priority = 4, groups = {"Mobiles", "MobileSearch"})
    public void seeAllMobile() {
        WebElement seeAllMobile = getDriver().findElement(SEE_ALL_MOBILE_BUTTON);
        Click(seeAllMobile);
    }
    
    @DataProvider(name="createAccountData")
    public Object[][] testDataMobile(){
    	return new Object[][] {
    		{"testjohn", "john4" ,"test@5565","test@5565"},
    		{"testjenny","jenny@gmail","test@12345","test@12345"}
    		
    	};
    }

    @Test(priority = 5,dataProvider="createAccountData", groups = {"Mobiles", "MobileSearch"})
    public void testCreateAccount(String name, String email, String password, String comfirmPasword) throws InterruptedException {
	    Click(getDriver().findElement(RETURNS_AND_ORDERS));
	    Click(getDriver().findElement(CREATEACC_BUTTON));

	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(FORM_NAME));
	    
	    getDriver().findElement(FORM_NAME).sendKeys(name);
	    getDriver().findElement(FORM_EMAIL).sendKeys(email);
	    getDriver().findElement(FORM_PASS).sendKeys(password);
	    getDriver().findElement(FORM_PASS_AGAIN).sendKeys(comfirmPasword);
	    
	    Click(getDriver().findElement(FORM_SUBMIT));
	    
	    validateSoftAssertion(getDriver().findElement(ALERT_INVALID_EMAIL).getText(),"Enter a valid email address");
	    
	    getDriver().navigate().back();
	    getDriver().navigate().back();
	    
    }
    
    @Test(priority = 6, groups = {"Mobiles", "MobileSearch"})
    @Parameters({"zipcode"})
    public void enterZipCode(@Optional("000000") String zipcode) { // Default value if not provided
        Click(getDriver().findElement(LOCATION_BUTTON));
        getDriver().findElement(INPUT_ZIP).sendKeys(zipcode);
        Click(getDriver().findElement(APPLY_BUTTON));
    }
    
    //@AfterClass
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit(); // Quit the WebDriver after all tests
        }
    }
}