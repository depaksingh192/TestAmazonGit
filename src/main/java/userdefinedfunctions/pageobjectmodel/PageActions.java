package userdefinedfunctions.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.WebdriverManager;

public interface PageActions {

    default WebDriver getDriver() {
        return WebdriverManager.getInstance().getDriver();
    }

    void Click(WebElement element);

    void doubleClick(WebElement element);

    void hoveroverElement(WebElement element);

    void scrollToElement(WebElement element);

    void scrollToTimes(int i);
    
    void scrollHorizontal(WebElement scrollableElement);
    
    void scrollToBottom(WebElement scrollableElement);
    
    void scrollToTop(WebElement scrollableElement);

    void selectByText(WebElement element, String text);

    void selectByValue(WebElement element, String value);

    void selectByIndex(WebElement element, int n);

    void contextClick();

    void moveToElementClick(WebElement element);

    void clickAndHold(WebElement element, Integer time);

    void dragAndDrop(WebElement elementsource, WebElement elementtarget);

	
    
    
}