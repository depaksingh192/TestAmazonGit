package AmazonTests;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestJqueryui {
	private static final By CALENDERFRAME = By.xpath("//*[@class='demo-frame']");
	private static final By CALENDERTEXTBOX = By.id("datepicker");

	private static final By CALENDERDATE = By.xpath("//*[@id='ui-datepicker-div']//table//tbody//tr[3]//td[3]");
	private static final By CALENDERNEXT = By.xpath("//*[@id='ui-datepicker-div']//a[@class='ui-datepicker-next ui-corner-all']//span");
	private static final By CALENDERPREVIOUS = By.xpath("//*[@id='ui-datepicker-div']//a[@class='ui-datepicker-prev ui-corner-all']//span");
	private static final By CALENDERMONTH= By.xpath("//*[@class='ui-datepicker-title']//*[@class='ui-datepicker-month']");
	private static final By CALENDERYEAR= By.xpath("//*[@class='ui-datepicker-title']//*[@class='ui-datepicker-year']");
		
	private static final By DESTINATION = By.xpath("//*[@class='SearchControls_DestinationInput__ZmY5N']//*[@id='destinationInput-label']");
    private static final By ONEWAY = By.xpath("//*[@id='popoverContainer-TripTypeTopLevel']//*[@class='BpkText_bpk-text__MjhhY BpkText_bpk-text--footnote__OWIwY']");
	private static final By MULTICITY = By.xpath("//*[@class='bpk-popover--container']//ul//li[3]");
	private static final By ToCALENDER = By.xpath("");
	private static final By TODATE= By.xpath("(//*[@class='DatesSearchControlGroup_DatesInputButton__NTg4Z']//*[@class='CustomCalendar_WeekContainer__MTFkZ']//div[@class='CustomCalendar_WeekRow__NTM3O'][3])[1]//div[6]");
	private static final By FROMDATE= By.xpath("");
//	private static final By = By.xpath("");

//	public static void main(String[] args) {
	
	public static WebDriver driver;
	
	@BeforeClass
     public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		
     }
    
	
	static void selectFutureDate(WebDriver driver,String month, String year, String date) {
		while (true) {
	        String CalenderYear = driver.findElement(CALENDERYEAR).getText();
	        String CalenderMonth = driver.findElement(CALENDERMONTH).getText();

	        if (CalenderYear.equals(year) && CalenderMonth.equals(month)) {
	            break;
	        }

	        WebElement ele1 = driver.findElement(CALENDERNEXT);

	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(ele1));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
	        ele1.click();
	        
	        
	    }
		 List<WebElement> allDates=driver.findElements(By.xpath("//*[@id='ui-datepicker-div']//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	        for(WebElement dte:allDates) {
	        	if(date.equals(dte.getText())) {
	        		dte.click();
	        		break;
	        	}
	        }
	}
	
	static void selectPastDate(WebDriver driver,String month, String year, String date) {
		while (true) {
	        String CalenderYear = driver.findElement(CALENDERYEAR).getText();
	        String CalenderMonth = driver.findElement(CALENDERMONTH).getText();

	        if (CalenderYear.equals(year) && CalenderMonth.equals(month)) {
	            break;
	        }

	        WebElement ele1 = driver.findElement(CALENDERPREVIOUS);

	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(ele1));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
	        ele1.click();
	        
	        
	    }
		 List<WebElement> allDates=driver.findElements(By.xpath("//*[@id='ui-datepicker-div']//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
	        for(WebElement dte:allDates) {
	        	if(date.equals(dte.getText())) {
	        		dte.click();
	        		break;
	        	}
	        }
	}
	

	
	
	
	@Test
	public void clickToDestination() {
	    WebElement ele = driver.findElement(CALENDERFRAME);

	    // Switch to the calendar frame
	    driver.switchTo().frame(ele);

	    // Click the calendar textbox
	    driver.findElement(CALENDERTEXTBOX).click();

	    String month = "March";
	    String year = "2026";
	    String date = "15";

        
//	    selectFutureDate(driver,month,year,date);
	    selectFutureDate(driver,month,year,date);
	    
	        	
	        	
	        }
	    
	    

	
	
		
		

	@Test
     
     @AfterClass
     public void tearDown() {
//		Logger.getAnonymousLogger().info("Tearing down");
    	 
     }
		
		
		

	}


