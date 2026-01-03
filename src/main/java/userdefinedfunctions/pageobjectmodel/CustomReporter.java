package userdefinedfunctions.pageobjectmodel;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomReporter implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        System.out.println("Generating Custom HTML Report...");

        // Define the HTML file path
        File reportFile = new File(outputDirectory + File.separator + "CustomReport.html");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile))) {
            // Start HTML structure
            writer.write("<html><head><title>TestNG Custom Report</title></head><body>");
            writer.write("<h1>TestNG Custom Report</h1>");

            // Iterate through each suite
            for (ISuite suite : suites) {
                writer.write("<h2>Suite: " + suite.getName() + "</h2>");

                // Iterate through each result in the suite
                suite.getResults().forEach((testName, result) -> {
                    try {
                        writer.write("<h3>Test: " + testName + "</h3>");
                        writer.write("<p>Passed Tests: " + result.getTestContext().getPassedTests().getAllResults().size() + "</p>");
                        writer.write("<p>Failed Tests: " + result.getTestContext().getFailedTests().getAllResults().size() + "</p>");
                        writer.write("<p>Skipped Tests: " + result.getTestContext().getSkippedTests().getAllResults().size() + "</p>");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            }

            // End HTML structure
            writer.write("</body></html>");
            System.out.println("Custom HTML Report Generated Successfully at: " + reportFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}