package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class WebdriverManager {

    private static WebdriverManager instance;
    private WebDriver driver;

    // Private constructor to prevent instantiation
    private WebdriverManager() {}

    // Singleton instance getter
    public static WebdriverManager getInstance() {
        if (instance == null) {
            instance = new WebdriverManager();
        }
        return instance;
    }

    // Get WebDriver instance
    public WebDriver getDriver() {
        if (driver == null) {
            try {
                initializeDriver();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize WebDriver");
            }
        }
        return driver;
    }

    // Initialize WebDriver based on browser configuration
    private void initializeDriver() throws IOException {
        String browser = ConfigLoader.loadProperties("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(ConfigLoader.loadProperties("headless"));

        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--disable-cache", "--disable-application-cache", "--disable-offline-load-stale-cache");
                chromeOptions.addArguments("--disable-gpu"); // Optional: Disable GPU for better compatibility
                chromeOptions.addArguments("--window-size=1920,1080"); // Optional: Set window size for headless mode
                ChromeDriverService chromeService = ChromeDriverService.createDefaultService();
                driver = new ChromeDriver(chromeService, chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                firefoxOptions.addPreference("browser.cache.disk.enable", false);
                firefoxOptions.addPreference("browser.cache.memory.enable", false);
                firefoxOptions.addPreference("browser.cache.offline.enable", false);
                firefoxOptions.addPreference("network.http.use-cache", false);
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "safari":
                // SafariDriver does not require WebDriverManager setup
                driver = new SafariDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
    }

    // Quit WebDriver and reset instance
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset driver instance
        }
    }
}