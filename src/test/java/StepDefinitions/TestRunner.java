package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature", glue = {
		"StepDefinitions" }, plugin = {"pretty", "junit:target/JUnitReport/report.xml"},  monochrome = true, tags = "@smokeTest")

public class TestRunner {

}