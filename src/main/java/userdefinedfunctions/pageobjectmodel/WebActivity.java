package userdefinedfunctions.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebdriverManager;

public interface WebActivity {

    default WebDriver getDriver() {
        return WebdriverManager.getInstance().getDriver();
    }

    void maximizeBrowser();

    void minimizeBrowser();
    
    void setWindowSize(int x, int y);
    
    void setWindowFull();

    void navigateForward();

    void navigateBackward();
    
    void refreshPage();
    
    void navigateToUrl(String url);

    void openInNewTab(String url);

    void switchToAnotherWindow();

    void handleFrames(List<WebElement> framesid);

    String getTitle();

    void validateHardAssertion(String actual, String expected);
    
    void validateHardAssertTrue(Boolean str);

    void validateSoftAssertion(String actual, String expected);
    
    void validateSoftAssertionTrue(Boolean str);

    void explicitWaitVisibiltyOFElement(int duration, WebElement ele);
    
    void explicitWaitElementClickable(int duration, WebElement ele);

    
    void explicitWaitElementToBeSelected(int duration, WebElement ele);
    
    void explicitWaitAlertIsPresent(int duration);

    void implicitlyWait(int duration);

    default void navigateTo(String url) {
        getDriver().navigate().to(url);
    }

    default void quitWindow() {
        getDriver().quit();
    }

    default void closeWindow() {
        getDriver().close();
    }
}