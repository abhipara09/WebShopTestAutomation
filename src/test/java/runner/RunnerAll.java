package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", plugin = { "pretty", "html:target/cucumberHtmlReport", // HTML
																												// Report

		"pretty:target/cucumber-json-report.json", // JSON Report
		"pretty:target/cucumber.xml" }, 
		glue = { "stepdefinitions" })
public class RunnerAll {

}
