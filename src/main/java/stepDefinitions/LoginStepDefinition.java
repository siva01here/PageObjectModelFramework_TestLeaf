package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import driverManager.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition extends BaseClass {
	
	String appURL="http://leaftaps.com/opentaps/control/main";
	
	@Given("User is on the login page of the application")
	public void loadURL()
	{
		DriverManager.getDriver().get(appURL);
		try
		{
			Hooks.logTestStep("Application URL launched fine","Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Application URL didnt get launched fine", "Fail");
		}
	}
	
	@When("User enters the username as {string}")
	public void enterUserName(String userName)
	{
		DriverManager.getDriver().findElement(By.id("username")).sendKeys(userName);
		try
		{
			Hooks.logTestStep("Username entered fine","Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Username is not entered", "Fail");
		}
	}
	
	@When("User enters the password as {string}")
	public void enterPassword(String password)
	{
		DriverManager.getDriver().findElement(By.id("password")).sendKeys(password);
		try
		{
			Hooks.logTestStep("Password is entered fine","Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Password is not entered", "Fail");
		}
	}
	
	@When("User clicks on the login button")
	public void clickLoginButton()
	{
		DriverManager.getDriver().findElement(By.className("decorativeSubmit")).click();
		try
		{
			Hooks.logTestStep("Login button is clicked fine","Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Login button is not clicked", "Fail");
		}
	}
	
	@Then("Home page of the application should be displayed")
	public void verifyHomePage()
	{
		String actTitle=DriverManager.getDriver().getTitle();
		String expTitle="Leaftaps - TestLeaf Automation Platform";
		
		
		try
		{
			Assert.assertTrue(actTitle.equals(expTitle));
			Hooks.logTestStep("Homepage verified fine","Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Homepage is not launched", "Fail");
		}
	}
	
	@When("User clicks on the logout button")
	public void clickLogoutButton()
	{
		DriverManager.getDriver().findElement(By.className("decorativeSubmit")).click();
		try
		{
			Hooks.logTestStep("Logout button is clicked fine","Pass");
		}catch(Exception e)
		{
			Hooks.logTestStep("Logout button is not clicked", "Fail");
		}
	}
	
	@Then("Login page of the application should be displayed")
	public void verifyLoginPage()
	{
		String actTitle=DriverManager.getDriver().getTitle();
		String expTitle="Leaftaps - TestLeaf Automation Platform";
		
		
		try
		{
			Assert.assertTrue(actTitle.equals(expTitle));
			Hooks.logTestStep("Login page is verified fine","Pass");
			
		}catch(Exception e)
		{
			Hooks.logTestStep("Login page is not verified", "Fail");
		}
	}
	
	@Then("Error message should be displayed on the application")
	public void verifyErrorOnLogin()
	{
		String[] expResults= {"following error occurred during login: User not found.","following error occurred during login: Password incorrect.","username was empty reenter","password was empty reenter"};
		String actResult=DriverManager.getDriver().findElement(By.xpath("//p[contains(text(),'login') or contains(text(),'empty')]")).getText();
		
		
		boolean result=false;
		for(String s: expResults)
		{
			if(s.equals(actResult))
			{
				result=true;
				break;
			}
		}
		
		Assert.assertTrue(result);
	}
	
	

}
