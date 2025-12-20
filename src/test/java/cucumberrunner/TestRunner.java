package cucumberrunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/featurefiles", // Path to the feature files
    glue = {"userdefinedfunctions.stepdefinitions.AmazonHome", "cucumberrunner"}, // Path to the step definitions
    tags = "@amazon and @web", // Tags to filter scenarios
    plugin = {
        "pretty", // Prints Gherkin steps in the console
        "html:target/cucumber-reports.html", // Generates an HTML report
        "json:target/cucumber-reports/cucumber.json" // Generates a JSON report
    },
    monochrome = true // Makes console output more readable
)

public class TestRunner {

}