package cucumber.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/java/cucumber",glue="cucumber.stepDefinition",monochrome=true,plugin= {"html:target/cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests{

}
