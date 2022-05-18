package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class MyHomePage extends BaseClass
{

	public MyHomePage(WebDriver driver, ExtentTest node)
	{
		this.driver=driver;
		//this.objExtTest=test;
		this.objExtNode=node;
	}

	public MyLeadsPage clickOnLeadsLink()
	{
		try
		{
			driver.findElement(By.linkText("Leads")).click();
			reportStep("Leads link is clicked sucessfully","Pass");
		}catch(Exception e)
		{
			reportStep("Leads link is not clicked sucessfully "+e.toString(),"Fail");
		}
		
		return new MyLeadsPage(driver,objExtNode);
	}

}
