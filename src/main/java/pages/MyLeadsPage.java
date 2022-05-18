package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class MyLeadsPage extends BaseClass
{
	public MyLeadsPage(WebDriver driver, ExtentTest node)
	{
		this.driver=driver;
		//this.objExtTest=test;
		this.objExtNode=node;
	}

	public CreateLeadPage clickCreateLeadLink()
	{
		try
		{
			driver.findElement(By.xpath("//a[text()='Create Lead']")).click();
			reportStep("Create lead link is clicked sucessfully ","Pass");
		}catch(Exception e)
		{
			reportStep("Create lead link is not clicked sucessfully "+e.toString(),"Fail");
		}
		
		return new CreateLeadPage(driver,objExtNode);
	}

}
