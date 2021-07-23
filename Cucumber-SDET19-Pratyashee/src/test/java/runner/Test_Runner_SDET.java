package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/Register/Cucumber.feature"},
glue={"stepDefinition"},
dryRun = false,
strict = true,
plugin = {"html:testoutput/cucumber.html", "junit:testoutput/cucumber.xml", "json:testoutput/cucumber.json"})

public class Test_Runner_SDET {

}
