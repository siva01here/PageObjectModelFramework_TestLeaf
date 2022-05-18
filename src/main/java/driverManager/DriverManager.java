package driverManager;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	
	static ThreadLocal<WebDriver> thDriver =new ThreadLocal<WebDriver>();
	//static ThreadLocal<Hooks> thHooks= new ThreadLocal<Hooks>();
	
	public static void setDriver(WebDriver driver)
	{
		thDriver.set(driver);
	}
	
	
	public static synchronized WebDriver getDriver()
	{
		return thDriver.get();
	}
	
//	public static void setHooks(Hooks objHooks)
//	{
//		thHooks.set(objHooks);
//	}
//	
//	
//	public static synchronized Hooks getHooks()
//	{
//		return thHooks.get();
//	}
	
	

}
