package userdefinedfunctions.pageobjectmodel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utility.WebdriverManager;

public class BaseScreen implements WebActivity, PageActions {
	
    private static final By CARS_BIKES_LINK = By.xpath("//*[@id='nav-xshop-container']//ul//*[contains(text(),'Car & Motorbike')]");
    private static final By LANGUAGE_SELECTOR = By.xpath("//*[@class='nav-div'][1]//a[1]//*[@class='icp-nav-link-inner']");
    private static final By LANGUAGE_FLYOUT=By.id("icp-nav-flyout");
    private static final By LANGUAGE_OPTION_KANNADA = By.xpath("//*[@id='nav-flyout-icp']//div[@class='nav-template nav-flyout-content nav-tpl-itemList']//li[6]//a//*[contains(text(),'ಕನ್ನಡ')]");
    private static final By SEARCH_BOX= By.xpath("//*[@id='nav-belt']//*[@id='twotabsearchtextbox' and contains(@placeholder, 'Search Amazon.in')]");
    private static final By ALL_SEARCH_DROPDOWN =By.xpath("//*[@id='searchDropdownBox']");
    private static final By SEARCH_SUBMIT=By.xpath("//*[@class='nav-search-submit nav-sprite']");
    private static final By ACCOUNT_ANDLIST =By.xpath("//*[@id='nav-link-accountList']");
    private static final By SIGIN_ACCOUNT_ANDLIST =By.xpath("(//*[@class='nav-template nav-flyout-content'])[2]//*[@class='nav-action-inner']");
    
    
    
    public Actions actions;

   
   
    
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver.get();
    }
    

    public void setUpDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver.set(new ChromeDriver());
//        wait = new WebDriverWait(BaseScreen.getDriver(), 20);
    	
    	
        getDriver().manage().window().maximize();
    }

    public void tearDownDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
//	@Override
//	public WebDriver getDriver() {
//		// TODO Auto-generated method stub
//		return PageActions.super.getDriver();
//	}

	// Maximize the browser
    @Override
    public void maximizeBrowser() {
        getDriver().manage().window().maximize();
        
        
     }
    
    // Minimize the browser
    @Override
    public void minimizeBrowser() {
        getDriver().manage().window().minimize();
       
    }
    
    @Override
    public void setWindowSize(int x, int y) {
    	
    	// Set the position of the window
    	getDriver().manage().window().setPosition(new Point(x,y));
	
    }
    
    
    //set Fullscreen
    @Override
    public void setWindowFull() {
    	
    	getDriver().manage().window().fullscreen();
    	
    }
    

    //Forward navigation
    @Override
    public void navigateForward() {
    	
         getDriver().navigate().forward();
         
       
    }
    
   
    
    //Backward navigation
    @Override
    public void navigateBackward() {
        getDriver().navigate().back();
        
    }
    
    public void refreshPage() {
    	
    	getDriver().navigate().refresh();
    	
    }
    
    
    public void navigateToUrl(String url) {
    	getDriver().navigate().to(url);
    }

    
    
    //Navigate to a URL in a new tab
    @Override
    public void openInNewTab(String url) {
    	
    	JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.open('" + url + "', '_blank');");
        for (String tab : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(tab);
        }
    }

    
   //Navigate to a URL in a new window
    @Override
    public void switchToAnotherWindow() {
        for (String winHandles : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(winHandles);
        }
    }

    
    //Switches to each frame in the provided list of frames and then switches back to the default content
    @Override
    public void handleFrames(List<WebElement> framesid) {
        for (WebElement frame : framesid) {
            getDriver().switchTo().frame(frame);
        }
        getDriver().switchTo().defaultContent();
    }
    
    
    //Performs a single click on the specified web element
    @Override
    public void Click(WebElement element) {
        element.click();
    }
    
    //Performs a double-click action on the specified web element
    @Override
    public void doubleClick(WebElement element) {
       actions = new Actions(getDriver());
       actions.doubleClick(element);
    }
    
    

    //Moves the mouse pointer over the specified web element (hover action)
    @Override
    public void hoveroverElement(WebElement element) {
        actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
        
    }
    
    //Used to scroll into view of an element
    @Override
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    
    }
    
    @Override
	public void scrollToTimes(int i) {
		// TODO Auto-generated method stub
		for(int x=0;x<=i;x++) {
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			try {
			js.executeScript("window.scrollBy(0,300);");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
    
    //Used for interacting with drop-down menus
    @Override
    public void selectByText(WebElement element, String text) {
        
        Select sel= new Select(element);
        sel.selectByVisibleText(text);
    }
    
    public void selectByValue(WebElement element, String value) {
        Select sel = new Select(element);
        sel.selectByValue(value);
    }

    public void selectByIndex(WebElement element, int n) {
    	Select sel = new Select(element);
        sel.selectByIndex(n);
    }
    
    //Performs a right-click (context click) action
	@Override
	public void contextClick() {
		actions = new Actions(getDriver());
		actions.contextClick();
		
	}
    
	//Moves the mouse pointer to the specified element and performs a click
	@Override
	public void moveToElementClick(WebElement element) {
		actions = new Actions(getDriver());
		actions.moveToElement(element).click().build().perform();
		
	}
    
	//Performs a click-and-hold action on the specified element for a given duration
	@Override
	public void clickAndHold(WebElement element,Integer time) {
		actions = new Actions(getDriver());
	    actions.clickAndHold(element).perform(); // Hold the element
	    try {
	        Thread.sleep(time); // Hold for 2 seconds (2000 milliseconds)
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    actions.release(element).perform(); // Release the element
	}
   
	//Performs a drag-and-drop action on the specified element
		@Override
		public void dragAndDrop(WebElement elementsource, WebElement elementtarget) {
			actions = new Actions(getDriver());
			actions.dragAndDrop(elementsource,elementtarget).perform();
			
		}
	
	//Validate the page title
	@Override
	public String getTitle() {
		return getDriver().getTitle();
		
	}
    
	//Validate using hard assertion
	@Override
	public void validateHardAssertion(String actual, String expected) {
		Assert.assertEquals(actual,expected);
		
	}
	public void validateHardAssertTrue(Boolean str) {
		Assert.assertTrue(str);
		
	}

	
	//Validate using soft assertion
	@Override
	public void validateSoftAssertion(String actual, String expected) {
		SoftAssert softassrt = new SoftAssert();
		softassrt.assertEquals(actual,expected);
        softassrt.assertAll();
		
	}
	
	//Validate using soft assertion
		@Override
		public void validateSoftAssertionTrue(Boolean str) {
			SoftAssert softassrt = new SoftAssert();
			softassrt.assertTrue(str);
	        softassrt.assertAll();
			
		}
    
	//Sets an implicit wait for the specified duration
	@Override
	public void implicitlyWait(int duration) {
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
		
	}
    
	//Used to handle dynamic elements that may take time to be visible of element
	@Override
	public void explicitWaitVisibiltyOFElement(int duration , WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf((ele)));
		
		
	}

	
	//Used to handle dynamic elements that may take time to be ready to be clickable
	@Override
	public void explicitWaitElementClickable(int duration, WebElement xpth) {
		
//		WebElement ele =getDriver().findElement(By.xpath(xpth));
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeClickable(xpth));
	
	}
	
	//Used to handle wait till dynamic elements to be selected
	@Override
	public void explicitWaitElementToBeSelected(int duration, WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.elementToBeSelected(ele));
		
	}
	
	@Override
	public void explicitWaitAlertIsPresent(int duration) {
		
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
		
		

	//Use scrollLeft to scroll horizontally
	@Override
	public void scrollHorizontal(WebElement scrollableElement) {
		
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollLeft += 500;", scrollableElement);
		
	}

	//Scrolls to the bottom of the page
	@Override
	public void scrollToBottom(WebElement scrollableElement) {
       
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
	}

	//Scrolls to the top of the page
	@Override
	public void scrollToTop(WebElement scrollableElement) {
        
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    js.executeScript("window.scrollTo(0, 0);");
		
	}

	

}