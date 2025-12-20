package cucumberrunner;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utility.WebdriverManager;

public class SetupTeardown {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize WebDriver using WebDriverManager
        driver = WebdriverManager.getInstance().getDriver();
    }

    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        if (driver != null) {
            // Take screenshot after every step
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Step Screenshot");
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            // Take screenshot if the scenario fails
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Failed Test Screenshot");
            }
            // Quit the driver
            WebdriverManager.getInstance().quitDriver();
        }
    }

    public static WebDriver getDriver() {
        return WebdriverManager.getInstance().getDriver();
    }
}