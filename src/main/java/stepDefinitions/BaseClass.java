package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driverManager.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends AbstractTestNGCucumberTests{
	
	WebDriver driver;
	Hooks objHooks;
	
	
		
	@BeforeMethod
	public void setUpMethod()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		DriverManager.setDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown()
	{
		DriverManager.getDriver().quit();
	}

}
