//package userdefinedfunctions.pageobjectmodel;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.devtools.DevTools;
//import org.openqa.selenium.devtools.v138.network.Network;
//import org.openqa.selenium.devtools.v138.network.model.Request;
//import org.openqa.selenium.devtools.v138.network.model.Response;
//
//import utility.WebdriverManager;
//
//import java.util.Optional;
//
//public class WebElementsFinderClass {
//
//
//    // Example method to demonstrate DevTools usage
//    public void captureNetworkLogs() {
//        WebDriver driver = WebdriverManager.getDriver();
//
//        if (driver instanceof org.openqa.selenium.chrome.ChromeDriver) {
//            DevTools devTools = ((org.openqa.selenium.chrome.ChromeDriver) driver).getDevTools();
//            devTools.createSession();
//
//            // Enable network logging
//            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
//
//            // Listen to network requests
//            devTools.addListener(Network.requestWillBeSent(), request -> {
//                System.out.println("Request URL: " + request.getRequest().getUrl());
//                System.out.println("Request Method: " + request.getRequest().getMethod());
//            });s
//
//            // Listen to network responses
//            devTools.addListener(Network.responseReceived(), response -> {
//                System.out.println("Response URL: " + response.getResponse().getUrl());
//                System.out.println("Response Status: " + response.getResponse().getStatus());
//            });
//        } else {
//            throw new UnsupportedOperationException("DevTools is only supported for ChromeDriver.");
//        }
//    }
//
//    public void referenceAboveWebElement() {
//        // Implement logic to find and interact with elements above a reference element
//    }
//
//    public void referenceBelowWebElement() {
//        // Implement logic to find and interact with elements below a reference element
//    }
//
//    public void referenceLeftWebElement() {
//        // Implement logic to find and interact with elements to the left of a reference element
//    }
//
//    public void referenceRightWebElement() {
//        // Implement logic to find and interact with elements to the right of a reference element
//    }
//}