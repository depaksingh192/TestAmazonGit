package AmazonTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import userdefinedfunctions.pageobjectmodel.BaseScreen;
import utility.Logger;


public class TestAmazonHome extends BaseScreen {

	private static final By CARS_BIKES_LINK = By.xpath("//*[@id='nav-xshop-container']//ul//*[contains(text(),'Car & Motorbike')]");
    private static final By LANGUAGE_SELECTOR = By.xpath("//*[@class='nav-div'][1]//a[1]//*[@class='icp-nav-link-inner']");
    private static final By LANGUAGE_FLYOUT=By.id("icp-nav-flyout");
    private static final By LANGUAGE_OPTION_KANNADA = By.xpath("//*[@id='nav-flyout-icp']//div[@class='nav-template nav-flyout-content nav-tpl-itemList']//*[contains(text(),'ಕನ್ನಡ')]");
    private static final By SEARCH_BOX= By.xpath("//*[@id='nav-belt']//*[@id='twotabsearchtextbox' and contains(@placeholder, 'Search Amazon.in')]");
    private static final By ALL_SEARCH_DROPDOWN =By.xpath("//*[@id='searchDropdownBox']");
    private static final By SEARCH_SUBMIT=By.xpath("//*[@class='nav-search-submit nav-sprite']");
    private static final By ACCOUNT_ANDLIST =By.xpath("//*[@id='nav-link-accountList']");
    private static final By SIGIN_ACCOUNT_ANDLIST =By.xpath("(//*[@class='nav-template nav-flyout-content'])[2]//*[@class='nav-action-inner']");
    private static final By SIGN_IN_BOTTOM_FOOTER=By.xpath("//*[@id='CardInstanceHUQev-RxlZZRojF_uoVi3Q']//*[contains(text(),'Sign in')]");
    private static final By TOP_CONTAINER_HEADERS=By.xpath("//*[@id='nav-xshop-container']");
    private static final By PRIME_OFFER=By.xpath("//*[@id='nav-xshop-container']//li[7]");
    private static final By AUTOMATIVE_OFFERS=By.xpath("//*[@id='gw-card-layout']//*[@class='a-cardui-header']//*[contains(text(),'Automotive')]//following::div[@class='a-cardui-footer'][1]");
    private static final By BOTTOM_CARSOUSEL=By.xpath("(//*[@class='a-section a-spacing-none feed-carousel feed-carousel-touch'])[5]");

    private BaseScreen basescreen;
    public Logger logger;
    
    
    @BeforeClass
    public void setUp() {
    	logger = new Logger(BaseScreen.class); // Initialize the logger
        logger.info("Start the tests for Homescreen");

    	basescreen = new BaseScreen();
    }
    

    @Test(priority = 1)
    public void launchAmazon() {

	 	basescreen.implicitlyWait(20);
	 	basescreen.getDriver().get("https://www.amazon.in");
       
    }

	

    @Test(priority = 2)
    public void assertTitle() {
    	 logger.info(basescreen.getTitle());
         basescreen.validateHardAssertion(basescreen.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
  
    	}

    @Test(priority = 3)
    public void validateCarsBikesLink() {
    	


//       basescreen.explicitWaitElementClickable(10,(WebElement) CARS_BIKES_LINK);
    	WebElement carsBikesLink = basescreen.getDriver().findElement(CARS_BIKES_LINK);
       basescreen.validateHardAssertTrue(carsBikesLink.isDisplayed());
    }

    @Test(priority = 4)
    public void validatechangeLanguage() {
        try {
        	
        	
        	basescreen.explicitWaitElementClickable(10,(WebElement) LANGUAGE_SELECTOR);
        	basescreen.validateHardAssertTrue((((WebElement) CARS_BIKES_LINK).isDisplayed()));
        	basescreen.moveToElementClick((WebElement) LANGUAGE_SELECTOR);
        	basescreen.validateHardAssertTrue((((WebElement) LANGUAGE_OPTION_KANNADA).isDisplayed()));
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    @Test(priority = 5)
    public void validateSearch() {
    	
    	try {
    		
    		
    		basescreen.validateSoftAssertionTrue(((WebElement) SEARCH_BOX).isDisplayed());
    		basescreen.validateSoftAssertionTrue(((WebElement) ALL_SEARCH_DROPDOWN).isDisplayed());
    		basescreen.validateSoftAssertionTrue(((WebElement) SEARCH_SUBMIT).isDisplayed());
      } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    	
    }
    
    @Test(priority = 6)
    public void validateTopContainer() {
    	
    	try {
    		basescreen.validateSoftAssertionTrue(((WebElement)TOP_CONTAINER_HEADERS).isDisplayed());
      } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    	
    }
    
    
    @Test(priority = 7)
    public void validateBottomCarousel() {
    	
    	try {
    		basescreen.validateSoftAssertionTrue(((WebElement) BOTTOM_CARSOUSEL).isDisplayed());
      } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    	
    }
    

    @AfterClass(alwaysRun=true)
    public void quitAmazon() {
    	basescreen.quitWindow();
    	logger.info("Tests for Homescreen compleate browser closed");
    }
    
    }







