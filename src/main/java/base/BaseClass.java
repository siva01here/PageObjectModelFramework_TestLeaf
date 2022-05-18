package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class BaseClass {
	
	public WebDriver driver;
	public String excelFileName; //initially set to null and when test method gets executed filename will be set by @beforeTest
	public String testName, testDescription, testCategory,testAuthor;
	public static ExtentReports objExtReport;
	public ExtentTest objExtTest, objExtNode;
	
	@BeforeSuite
	public void startReport()
	{
		ExtentHtmlReporter objExtHtmlReporter= new ExtentHtmlReporter("./reports/ExtentreportResults.html");
		objExtReport = new ExtentReports();
		objExtReport.attachReporter(objExtHtmlReporter);
	}
	
	@BeforeClass
	public void setTestDetails()
	{
		objExtTest=objExtReport.createTest(testName,testDescription);
		objExtTest.assignAuthor(testAuthor);
		objExtTest.assignCategory(testCategory);
	}
	
	public void reportStep(String stepDesc, String status)
	{
		if(status.equalsIgnoreCase("Pass"))
		{
			try {
				objExtNode.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././screenshots/img"+takeScreenshot()+".png").build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else if(status.equalsIgnoreCase("Fail"))
		{
			try {
				objExtNode.fail(stepDesc, MediaEntityBuilder.createScreenCaptureFromPath(".././screenshots/img"+takeScreenshot()+".png").build());
			} catch (IOException e) {
				e.printStackTrace();
			}
			throw new RuntimeException("Check the extent report for failure info");
		}
	}
	
	public int takeScreenshot()
	{
		int num=(int)(Math.random()*99999*10000);
		TakesScreenshot objScreenshot=(TakesScreenshot)driver;
		File srcScreenshot=objScreenshot.getScreenshotAs(OutputType.FILE);
		File targetScreenshot=new File("./screenshots/img"+num+".png");
		try {
			FileUtils.copyFile(srcScreenshot,targetScreenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
		
	}
	
	@AfterSuite
	public void stopReport()
	{
		objExtReport.flush();
	}
	
	@DataProvider(name="getData")
	public String[][] getTestData()
	{
		return ReadExcel.readData(excelFileName);

	}


	@BeforeMethod
	public void setUpTest()
	{
		objExtNode = objExtTest.createNode(testName,testDescription);
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/main");
	}


	@AfterMethod
	public void tearDownTest()
	{

		driver.close();
	}

}
