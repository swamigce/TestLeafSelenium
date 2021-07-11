package parallelExecution;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/*@CucumberOptions (features="src/test/java/features/SFDCLogin.feature", 
					glue="steps", 
					monochrome = true, 
					publish=true)*/
@CucumberOptions (features="src/test/java/features/SFDCLogin.feature", 
glue="steps", 
monochrome = true, 
publish=true)
public class RunSFDCTest extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider (parallel=true)
	public Object[][] scenarios(){
		
		return super.scenarios();
	}
}
