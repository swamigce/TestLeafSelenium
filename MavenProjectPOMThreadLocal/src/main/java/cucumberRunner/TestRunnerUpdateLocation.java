package cucumberRunner;

import baseClasses.SeleniumBaseClass;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features="src/main/java/cucumberFeatures/UpdateLocation.feature", 
glue="pagesPOM", 
monochrome = true, 
publish=true)
public class TestRunnerUpdateLocation extends SeleniumBaseClass{

}
