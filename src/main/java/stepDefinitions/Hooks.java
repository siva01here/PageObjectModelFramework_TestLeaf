package stepDefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass{
	
	ExtentHtmlReporter objExtHtml;
	public static ExtentReports objExtReport;
	public static ExtentTest objExtTest;
	
	@Before
	public void beforeScenario(Scenario scenario)
	{
		objExtHtml= new ExtentHtmlReporter("./reports/CucumberExtentHtmlReport.html");
		objExtReport= new ExtentReports();
		objExtReport.attachReporter(objExtHtml);
		objExtReport.setSystemInfo("Environment", "Test Environment");
		objExtReport.setSystemInfo("Author", "Sivakumar Ramanan");
		objExtTest=objExtReport.createTest(scenario.getName());
	}
	
	public static void logTestStep(String desc, String status)
	{
		if(status.equalsIgnoreCase("Pass"))
		{
			objExtTest.pass(desc);
		}
		else
		{
			objExtTest.fail(desc);
		}
	}
	
	@After
	public void afterScenario()
	{
		objExtReport.flush();
	}
	
	@BeforeStep
	public void beforeStep()
	{
		//System.out.println("Before step scenarios");
	}

	@AfterStep
	public void afterStep()
	{
		//System.out.println("After step scenarios");
	}
	
	@BeforeAll
	public static void beforeAll()
	{
		System.out.println("Before all scenarios");
	}
	
	@AfterAll
	public static void afterAll()
	{
		System.out.println("After all scenarios");
	}
}
