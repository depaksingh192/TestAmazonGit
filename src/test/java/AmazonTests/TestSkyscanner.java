package AmazonTests;

import java.time.Duration;
import java.time.Year;
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

public class TestSkyscanner {
	private static final By CALENDERFRAME = By.xpath("//*[@class='demo-frame']");
	private static final By CALENDERTEXTBOX = By.id("datepicker");

	private static final By CALENDERDATE = By.xpath("//*[@id='ui-datepicker-div']//table//tbody//tr[3]//td[3]");
	private static final By CALENDERNEXT = By.xpath("//*[@id='ui-datepicker-div']//a[@class='ui-datepicker-next ui-corner-all']//span");
	private static final By CALENDERPREVIOUS = By.xpath("//*[@id='ui-datepicker-div']//a[@class='ui-datepicker-prev ui-corner-all']//span");
	private static final By CALENDERMONTH= By.xpath("//*[@class='ui-datepicker-title']//*[@class='ui-datepicker-month']");
	private static final By CALENDERYEAR= By.xpath("//*[@class='ui-datepicker-title']//*[@class='ui-datepicker-year']");
	
	//skyscanner
	private static final By RETURN_BUTTON = By.xpath("//*[@id='popoverContainer-TripTypeTopLevel']//*[@class='BpkSelectableChip_bpk-chip__ZjVmY BpkSelectableChip_bpk-chip--on-dark__N2UyY']");
	private static final By MUTI_CITY_BUTTON =By.xpath("//*[@class='bpk-popover--container']//*[@id='popover-TripTypeTopLevel']//*[contains(text(),'Multi')]");
	private static final By DEPART_BUTTON_ONE =By.xpath("//*[@class='DatesSearchControlGroup_DatesInputButton__N2NiN']//button");
	private static final By DEPART_ONE_NEXT =By.xpath("//*[@class='SearchControlSelectorPopOver_container__NWI4O SearchControlSelectorPopOver_MultiCityDatesSelectorPopover__YzZhN']//*[@class='DesktopDatePicker_form__OWJhO']//button[2]");
	private static final By DEPART_ONE_CAL_MONTH=By.xpath("//*[@class='CustomCalendar_CalendarsContainer__ZWNkY']//h2");
//	private static final By DEPART_ONE_CAL_YEAR=By.xpath("");	
//	private static final By DEPART_ONE_CAL_DATES=By.xpath("");
	private static final By DEPART_ONE_CAL_CONFIRM=By.xpath("//*[@class='DatePickerFooter_container__YmI0N']//button[contains(text(),'Confirm')]");
	

//	public static void main(String[] args) {
	
	public static WebDriver driver;
	
	@BeforeClass
     public void setUp() {
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.skyscanner.co.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		
     }
    
	
	static void selectFutureDate(WebDriver driver, String month, int year, String date) {
	    List<WebElement> CalenderMonths = driver.findElements(DEPART_ONE_CAL_MONTH);
	    int currentYear = Year.now().getValue();

	    // Navigate to the correct year
	    while (currentYear < year) {
	        WebElement nextButton = driver.findElement(DEPART_ONE_NEXT);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
	        nextButton.click();

	        // Update the current year after clicking the "Next" button
	        currentYear++;
	    }

	    // Navigate to the correct month
	    while (true) {
	        if (CalenderMonths.get(0).getText().equals(month) || CalenderMonths.get(1).getText().equals(month)) {
	            break;
	        }

	        WebElement nextButton = driver.findElement(DEPART_ONE_NEXT);
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
	        nextButton.click();
	    }

	    // Select the date
	    if (CalenderMonths.get(0).getText().equals(month)) {
	        List<WebElement> allDates = driver.findElements(By.xpath("//*[@class='CustomCalendar_CalendarGroup__ZWNhY'][1]//div[@class='CustomCalendar_WeekContainer__NDdkN']//*[@class='CustomCalendar_WeekRow__MDdjM']//*[@class='CustomCalendar_day__MGE5Y']"));
	        for (WebElement dte : allDates) {
	            if (date.equals(dte.getText())) {
	                dte.click();
	                break;
	            }
	        }
	    } else {
	        List<WebElement> allDates = driver.findElements(By.xpath("//*[@class='CustomCalendar_CalendarGroup__ZWNhY'][2]//div[@class='CustomCalendar_WeekContainer__NDdkN']//*[@class='CustomCalendar_WeekRow__MDdjM']//*[@class='CustomCalendar_day__MGE5Y']"));
	        for (WebElement dte : allDates) {
	            if (date.equals(dte.getText())) {
	                dte.click();
	                break;
	            }
	        }
	    }
	}
	



	
	@Test
	public void clickToDestination() {
		
		Assert.assertTrue(driver.findElement(RETURN_BUTTON).isDisplayed());
		driver.findElement(RETURN_BUTTON).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		driver.findElement(MUTI_CITY_BUTTON).click();
		driver.findElement(DEPART_BUTTON_ONE).click();

	    String month = "March";
	    int year = 2027;
	    String date = "15";

        
	    selectFutureDate(driver,month,year,date);
	    driver.findElement(DEPART_ONE_CAL_CONFIRM).click();
	    
//	    selectFutureDate(driver,month,year,date);
  	
	        }

	@Test
     
     @AfterClass
     public void tearDown() {
//		Logger.getAnonymousLogger().info("Tearing down");
    	 
     }
		
		
		

	}


