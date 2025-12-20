package cucumberrunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = "src/test/resources/featurefiles", // Path to feature files
    glue = {"userdefinedfunctions.stepdefinitions.AmazonHome", "cucumberrunner"}, // Step definitions
    tags = "@amazon, @web", // Tags to filter scenarios
    plugin = {
        "pretty", // Prints Gherkin steps in the console
        "html:target/cucumber-reports.html", // HTML report
        "json:target/cucumber-reports/cucumber.json" // JSON report
    },
    monochrome = true // Makes console output readable
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @Override
    @org.testng.annotations.DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}




