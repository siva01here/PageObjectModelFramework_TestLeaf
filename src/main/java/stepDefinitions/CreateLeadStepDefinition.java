package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import driverManager.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateLeadStepDefinition extends BaseClass{
	
	@When("User clicks on the CRMSFA link")
	public void clickCRMSFALink()
	{
		try
		{
			DriverManager.getDriver().findElement(By.linkText("CRM/SFA")).click();
			Hooks.logTestStep("CRMSFA link is clicked fine", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("CRMSFA link is not clicked fine "+e.toString(), "Fail");
		}
	}
	
	@When("User clicks on Leads link")
	public void clickLeadsLink()
	{
		try
		{
			DriverManager.getDriver().findElement(By.linkText("Leads")).click();
			Hooks.logTestStep("Leads link is clicked fine", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Leads link is not clicked"+e.toString(), "Fail");
		}
	}
	
	@When("User clicks on Create Lead link")
	public void clickCreateLeadLink()
	{
		try
		{
			DriverManager.getDriver().findElement(By.linkText("Create Lead")).click();
			Hooks.logTestStep("Create Lead link is clicked", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Create lead link is not clicked "+e.toString(), "Fail");
		}
	}
	
	@When("User enters the company name as {string}")
	public void enterCompanyName(String cName)
	{
		try
		{
			DriverManager.getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
			Hooks.logTestStep("Company name entered fine", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Company name is not entered "+e.toString(), "Fail");
		}
	}
	
	@When("User enters the first name as {string}")
	public void enterFirstName(String fName)
	{
		try
		{
			DriverManager.getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
			Hooks.logTestStep("First name is entered fine", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("First name is not entered "+e.toString(), "Fail");
		}
	}
	
	@When("User enters the last name as {string}")
	public void enterLastName(String lName)
	{
		try
		{
			DriverManager.getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
			Hooks.logTestStep("Last name is entered fine", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Last name is not entered "+e.toString(), "Fail");
		}
	}
	
	@When("User clicks on Create Lead button")
	public void clickCreateLeadButton()
	{
		try
		{
			DriverManager.getDriver().findElement(By.className("smallSubmit")).click();
			Hooks.logTestStep("Create Lead button is clicked", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Create lead is not clicked "+e.toString(), "Fail");
		}
	}
	
	@Then("Lead should be created successfully")
	public void verifyCreateLead()
	{
		String actTitle= DriverManager.getDriver().getTitle();
		String expTitle= "View Lead | opentaps CRM";
		try
		{
			Assert.assertTrue(actTitle.equals(expTitle));
			Hooks.logTestStep("Create Lead is verified fine", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Create Lead is not verified fine"+e.toString(), "Fail");
		}
	}
	
	@Then("Lead should have the company name as {string}")
	public void verifyCompanyName(String compName)
	{
		String actCompName=DriverManager.getDriver().findElement(By.id("viewLead_companyName_sp")).getText().replaceAll("[^a-zA-Z]", "");
		try
		{
			Assert.assertTrue(actCompName.equals(compName));
			Hooks.logTestStep("Company Name is verified fine", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Company Name is not verified fine "+e.toString(), "Fail");
		}
	}
	
	@Then("Lead should have the first name as {string}")
	public void verifyFirstName(String fName)
	{
		String actFirstName=DriverManager.getDriver().findElement(By.id("viewLead_firstName_sp")).getText().replaceAll("[^a-zA-Z]", "");
		
		try
		{
			Assert.assertTrue(actFirstName.equals(fName));
			Hooks.logTestStep("First Name is verified fine", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("First Name is not verified fine "+e.toString(), "Fail");
		}
	}
	
	@Then("Lead should have the last name as {string}")
	public void verifyLastName(String lName)
	{
		String actLastName=DriverManager.getDriver().findElement(By.id("viewLead_lastName_sp")).getText().replaceAll("[^a-zA-Z]", "");
		try
		{
			Assert.assertTrue(actLastName.equals(lName));
			Hooks.logTestStep("Last Name is verified fine", "Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Last Name is not verified fine "+e.toString(), "Fail");
		}
	}
	
	

}
