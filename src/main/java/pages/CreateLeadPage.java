package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class CreateLeadPage extends BaseClass
{
	public CreateLeadPage(WebDriver driver,ExtentTest node)
	{
		this.driver=driver;
		//this.objExtTest=test;
		this.objExtNode=node;
	}

	public CreateLeadPage enterCompanyName(String companyName)
	{
		try
		{
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
			reportStep("Company name is entered fine","Pass");
		}catch(Exception e)
		{
			reportStep("Company name is not entered fine"+e.toString(),"Fail");
		}
		return this;

	}

	public CreateLeadPage enterFirstName(String fName)
	{
		
		try
		{
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
			reportStep("First name is entered fine","Pass");
		}catch(Exception e)
		{
			reportStep("First name is not entered fine"+e.toString(),"Fail");
		}
		return this;

	}

	public CreateLeadPage enterLastName(String lName)
	{
		try
		{
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
			reportStep("Last name is entered fine","Pass");
		}catch(Exception e)
		{
			reportStep("Last name is not entered fine"+e.toString(),"Fail");
		}
		return this;
	}

	
	public ViewLeadPage clickCreateLeadButton()
	{
		try
		{
			driver.findElement(By.className("smallSubmit")).click();
			reportStep("Create Lead button is clicked fine","Pass");
		}catch(Exception e)
		{
			reportStep("Create Lead button is not clicked fine"+e.toString(),"Fail");
		}
		return new ViewLeadPage(driver,objExtNode);
	}

}
