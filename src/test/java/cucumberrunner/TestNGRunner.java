package cucumberrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@CucumberOptions(
    features = "src/test/resources/featurefiles", // Path to feature files
    glue = {"userdefinedfunctions.stepdefinitions.AmazonTests.AmazonMobiles", "cucumberrunner"}, // Step definitions
    tags = "@mobiles", 
    plugin = {
        "pretty", // Prints Gherkin steps in the console
        "html:target/cucumber-reports.html", // HTML report
        "json:target/cucumber-reports/cucumber.json" // JSON report
    },
    monochrome = true // Makes console output readable
)
public class TestNGRunner extends AbstractTestNGCucumberTests {

    private static WebDriver driver;

//    static {
//        // Set up ChromeDriver path
//    	System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
//
//        // Configure ChromeOptions to avoid CDP
//    	 ChromeOptions options = new ChromeOptions();
//         options.addArguments("--disable-dev-shm-usage"); // Overcome resource issues
//         options.addArguments("--no-sandbox"); // Bypass OS security model
//         options.addArguments("--headless"); // Optional: Run in headless mode
//         options.addArguments("--disable-gpu"); // Disable GPU rendering
//         options.addArguments("--remote-allow-origins=*"); // Allow remote origins
//
//         // Initialize WebDriver
//         driver = new ChromeDriver(options);
//
//        // Initialize WebDriver
//        driver = new ChromeDriver(options);
//    }

    @Override
    @org.testng.annotations.DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}