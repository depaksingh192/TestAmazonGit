package AmazonTests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import userdefinedfunctions.pageobjectmodel.BaseScreen;
import utility.Logger;


public class TestAmazonCarsBikes {
	
	
	private static final By CARS_BIKES_LINK = By.xpath("");
    private static final By LANGUAGE_SELECTOR = By.xpath("");
    private static final By LANGUAGE_FLYOUT=By.id("");
    
    private BaseScreen basescreen;
    public Logger logger;
    
    @BeforeClass
    public void setUp() {
    	logger = new Logger(BaseScreen.class); // Initialize the logger
        logger.info("Start the tests for Homescreen");

    	basescreen = new BaseScreen();
    }
	
    
    
    
    @AfterClass(alwaysRun = true)
    public void quitAmazon() {
    	basescreen.quitWindow();
    	logger.info("Tests for Homescreen completec browser closed");
    }
	
	
	//String xpth_CARS_BIKES_LINK= "//*[@id='nav-xshop-container']//ul//*[contains(text(),'Car & Motorbike')]";
	//
	//homescreen.explicitWaitElementClickable(10,xpth_CARS_BIKES_LINK);
	//
	//
	//String xpth_LANGUAGE_SELECTOR="//*[@class='nav-div'][1]//a[1]//*[@class='icp-nav-link-inner']";
	//homescreen.explicitWaitElementClickable(10,xpth_LANGUAGE_SELECTOR);
	//
	//
	//String xpth_LANGUAGE_OPTION_KANNADA="//*[@id='nav-flyout-icp']//div[@class='nav-template nav-flyout-content nav-tpl-itemList']//li[6]//a//*[contains(text(),'ಕನ್ನಡ')]";
	//homescreen.explicitWaitElementClickable(10,xpth_LANGUAGE_OPTION_KANNADA);

}
