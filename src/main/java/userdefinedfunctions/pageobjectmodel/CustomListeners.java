package userdefinedfunctions.pageobjectmodel;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class CustomListeners implements ITestListener {

    private static WebDriver driver;

    // Set the location to store screenshots
    private static final String SCREENSHOT_PATH = "C:\\Users\\j712\\eclipse-workspace\\com.AmazonTests\\target";
    
    // Default no-argument constructor
    public CustomListeners() {
    }

    public static void setDriver(WebDriver driver) {
        CustomListeners.driver = driver;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        takeScreenshot(result, "Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(result, "Failure");
    }

    private void takeScreenshot(ITestResult result, String status) {
        // Create a screenshot file
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String testName = result.getName();
        String filePath = SCREENSHOT_PATH + File.separator + testName + "_" + status + ".png";

        try {
            FileUtils.copyFile(screenshot, new File(filePath));
            System.out.println("Screenshot saved for " + status + " case: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onStart(ITestResult result) {
        // Optional: Add logic for when the test starts
    	
    	 System.out.println("Test Started: " + result.getName());
    	    // Example: Log the start time
    	    System.out.println("Start Time: " + System.currentTimeMillis());
    }

   

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        // Example: Log the start time
        System.out.println("Start Time: " + System.currentTimeMillis());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
        // Example: Summarize results
        System.out.println("Passed Tests: " + context.getPassedTests().size());
        System.out.println("Failed Tests: " + context.getFailedTests().size());
        System.out.println("Skipped Tests: " + context.getSkippedTests().size());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // Optional: Add logic for skipped tests
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Optional: Add logic for partial success
    }
}