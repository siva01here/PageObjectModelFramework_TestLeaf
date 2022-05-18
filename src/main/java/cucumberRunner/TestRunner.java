package cucumberRunner;

import io.cucumber.testng.CucumberOptions;
import stepDefinitions.BaseClass;



@CucumberOptions(features="features",
			glue="stepDefinitions",
			monochrome=true,
			publish=true,
			tags="@Smoke"
)

public class TestRunner extends BaseClass{
	
	
	

}
