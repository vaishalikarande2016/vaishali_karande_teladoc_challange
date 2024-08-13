package TestRunners;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
(features="src/test/cucumber/",glue={"StepDefinitions"},plugin= {"pretty","html:target/cucumber-report.html"})

public class TestRunner extends AbstractTestNGCucumberTests{

	
}
