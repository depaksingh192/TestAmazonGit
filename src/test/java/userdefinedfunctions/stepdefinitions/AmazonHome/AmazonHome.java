package userdefinedfunctions.stepdefinitions.AmazonHome;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import AmazonTests.TestAmazonHome;

public class AmazonHome {
	
	TestAmazonHome amzHome;
	
	@Given("^User launches amazon.in$")
	public void userlaunchesAmazon() {
		amzHome = new TestAmazonHome();
		amzHome.launchAmazon();
		
		
	}
	
	@And("^User verifies title of webpage$")
    public void uservalidatesTitleofAmazon() {
		amzHome = new TestAmazonHome();
		amzHome.assertTitle();
		
	}
//	
//	@When("^User clicks on language selector and select \"([^\"]*)\" Language$")
//	public void userselectLanguage(String language) {
//	    // Code to handle the language selection
//		amzHome = new TestAmazonHome();
//		amzHome.changeLanguage();
//	    System.out.println("Selected language: " + language);
//	    // Add logic to click on the language selector and select the specified language
//	}
//	
//	@Then("^User quits the application$")
//	public void userquitsAmazon() {
//		amzHome = new TestAmazonHome();
//		amzHome.quitAmazon();
//		
//	}

	
}
