package userdefinedfunctions.stepdefinitions.AmazonTests;

import AmazonTests.TestAmazonMobile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AmazonMobiles {

    TestAmazonMobile testMobile;
    
    

    @Before
    public void setUp() {
        System.out.println("Setup: This runs before each scenario.");
        testMobile = new TestAmazonMobile();
        testMobile.setUp();
    }

    @Given("^User launches amazon and clicks on Mobile Tab$")
    public void userLaunchesAmazonAndClicksMobileTab() throws InterruptedException {
        
        testMobile.clickAndOpenMobile();
       
//            throw new io.cucumber.java.PendingException();
        }
       
       

    @And("^User filters New Mobile and range$")
    public void userFiltersNewMobileAndSelectsRange() {
        testMobile.filterNewMobileAndRange();
//        throw new io.cucumber.java.PendingException();
    }

    @When("^User hovers over Mobile Tab and navigate to Link$")
    public void userHoversOverMobileTabAndNavigatesToLink() {
        testMobile.hoverMobileTab();
//        throw new io.cucumber.java.PendingException();
    }
    
    @Then("^User clicks on see all Mobiles$")
    public void userClicksOnSeeAllMobiles() {
    	testMobile.seeAllMobile();
//    	throw new io.cucumber.java.PendingException();
    	
    }
    
//    @And("^User tries to create Account and validate invalid message$")
//    public void userCreatesInvalidAccount() {
//    	testMobile.testCreateAccount();
//    	
//    }
//    
    

    @After
    public void tearDown() {
        System.out.println("Teardown: This runs after each scenario.");
        // Add cleanup code here
    }
}