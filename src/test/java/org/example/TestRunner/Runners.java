package org.example.TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/main/resources/features",
    glue = {"org.example.StepDefinitions"},
    plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","junit:target/cukes.xml","rerun:target/rerun.txt"},
    tags= "@smoke"
)


public class Runners extends AbstractTestNGCucumberTests {


}
