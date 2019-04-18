package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features",
		glue = { "stepDefinition" }, format = { "pretty", "json:cucumber.json",
				"html:target/cucumber-reports" }, monochrome = true, dryRun = false, strict = true)

public class TestRunner {

}
