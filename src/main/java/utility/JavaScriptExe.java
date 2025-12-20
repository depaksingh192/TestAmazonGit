package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.WebdriverManager;


public class JavaScriptExe {

	public WebDriver getDriver() {
        return WebdriverManager.getInstance().getDriver();
    }
	
	public void clickElementJavascript(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();",ele);
	}
	
	public void interactHiddenElementJavascript(String id) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("document.getElementById('id').click();");
	}
	
	public void scrollusingJavascript() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0,500);");
	}
	
	public void scrollToViewusingJavascript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("argument[0].scrollIntoView(true);",element);
	}
	
	public void setValueusingJavascript_locatorID(String inputFieldElementId, String value) {
	    JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    js.executeScript("document.getElementById(arguments[0]).value = arguments[1];", inputFieldElementId, value);
	}

	public void setValueusingJavascript_locatorName(String inputFieldElementName, String value) {
	    JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    js.executeScript("document.getElementsByName(arguments[0])[0].value = arguments[1];", inputFieldElementName, value);
	}

	public void setValueusingJavascript_locatorClass(String inputFieldElementClass, String value) {
	    JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    js.executeScript("document.getElementsByClassName(arguments[0])[0].value = arguments[1];", inputFieldElementClass, value);
	}
	
	public void retrieveElement_usingJavascript(String selector) {
	    JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    WebElement element = (WebElement) js.executeScript("return document.querySelector(arguments[0]);", selector);
	    // Use the retrieved element as needed
	}

	public String retrieveElementAttribute_usingJavascript(String attribute, WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    String attributeValue = (String) js.executeScript("return arguments[0].getAttribute(arguments[1]);", element, attribute);
	    return attributeValue;
	}

	public void switchToiFrame_usingJavascript(String frameName) {
	    JavascriptExecutor js = (JavascriptExecutor) getDriver();
	    js.executeScript("window.frames[arguments[0]].focus();", frameName);
	}
	



//		•	Retrieving Element :
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript(“return document.querySelector(‘selector’);”);
//		•	Retrieving Element Attributes : Getting attributes or properties of elements.
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String attributeValue = (String) js.executeScript(“return arguments[0].getAttribute(‘attribute’);”, element);
//		•	Managing Iframes: Interacting with elements inside iframes by switching to the iframe using JavaScript.
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript(“window.frames[‘frameName’].document.getElementById(‘elementId’).click();”);
//	
	

}
