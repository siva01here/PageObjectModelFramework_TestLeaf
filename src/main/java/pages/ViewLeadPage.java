package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class ViewLeadPage extends BaseClass
{

	public ViewLeadPage(WebDriver driver,ExtentTest node)
	{
		this.driver=driver;
		//this.objExtTest=test;
		this.objExtNode=node;
	}

	public ViewLeadPage verifyFirstName(String expectedFirstName)
	{
		try
		{
			String actualEmpFname=driver.findElement(By.id("viewLead_firstName_sp")).getText();
			Assert.assertEquals(actualEmpFname,expectedFirstName, "Employee first name did not match");
			reportStep("First name matched fine","Pass");
		}catch(Exception e)
		{
			reportStep("First name did not match fine"+e.toString(),"Fail");
		}
		return this;

	}
	
	public ViewLeadPage verifyLeadCompanyName(String compName)
	{
		try
		{		
			String actCompName=driver.findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("[^a-zA-Z]", "");
			System.out.println(compName+"..."+actCompName);
			Assert.assertTrue(actCompName.equals(compName));
			reportStep("Lead company name matched fine","Pass");
		}catch(Exception e)
		{
			reportStep("Lead company name didnt match fine "+e.toString(),"Fail");
		}
		return this;
	}
	
	public ViewLeadPage verifyLeadLastName(String lName)
	{
		try
		{
			String actLastName=driver.findElement(By.id("viewLead_lastName_sp")).getText().replaceAll("[^a-zA-Z]", "");
			System.out.println(lName+"..."+actLastName);
			Assert.assertTrue(actLastName.equals(lName));
			reportStep("Lead Last name matched fine","Pass");
		}catch(Exception e)
		{
			reportStep("Lead Last name didnt match fine "+e.toString(),"Fail");
		}
		
		return this;
	}
	
	public ViewLeadPage verifyUpdatedLeadDescription(String desc)
	{
		try
		{
			
			String actDesc=driver.findElement(By.id("viewLead_description_sp")).getText();
			Assert.assertTrue(actDesc.equals(desc));
			reportStep("Updated lead description matched fine ","Pass");
		}catch(Exception e)
		{
			reportStep("Updated lead description didnt match fine "+e.toString(),"Fail");
		}
		
		return this;
	}
	
	public EditLead clickEditButton()
	{
		try
		{
			driver.findElement(By.linkText("Edit")).click();
			reportStep("Edit lead link is clicked fine ","Pass");
		}catch(Exception e)
		{
			reportStep("Edit lead link is not clicked "+e.toString(),"Fail");
		}
		return new EditLead(driver,objExtNode);
	}

}
