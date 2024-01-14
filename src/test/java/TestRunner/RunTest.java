package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"AllDriverFiles"},
		glue= {"StepDefination"},
		dryRun=false,
		monochrome=true,
		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

public class RunTest extends AbstractTestNGCucumberTests {

}
