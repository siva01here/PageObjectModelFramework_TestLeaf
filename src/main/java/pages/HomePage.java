package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class HomePage extends BaseClass
{
	public HomePage(WebDriver driver,ExtentTest node)
	{
		this.driver=driver;
		//this.objExtTest=test;
		this.objExtNode=node;
	}

	public MyHomePage clickCRMSFALink()
	{
		try
		{
			driver.findElement(By.linkText("CRM/SFA")).click();
			reportStep("CRM/SFA link is clicked successfully", "Pass");
		}catch(Exception e)
		{
			reportStep("CRM/SFA link is not clicked sucessfully"+e.toString(),"Fail");
		}
		return new MyHomePage(driver,objExtNode);
	}

	public LoginPage clickLogoutButton()
	{
		
		try
		{
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Logout button is clicked successfully", "Pass");
		}catch(Exception e)
		{
			reportStep("Logout button is not clicked sucessfully"+e.toString(),"Fail");
		}
		return new LoginPage(driver,objExtNode);

	}

}
