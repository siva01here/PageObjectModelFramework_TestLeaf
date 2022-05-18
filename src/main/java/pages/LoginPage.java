package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;

public class LoginPage extends BaseClass{
	
	public LoginPage(WebDriver driver, ExtentTest node)
	{
		//assigning the driver reference in param to driver reference in this class which is coming from baseclass
		//so both test and POM class have same driver reference now
		//this.driver (refers to base class driver)
		//driver (refers to driver from test class)
		this.driver=driver;
		//this.objExtTest=test;
		this.objExtNode=node;
	}
	

	public LoginPage enterUsername(String uName)
	{
		try
		{
			driver.findElement(By.id("username")).sendKeys(uName);
			reportStep("UserName entered successfully", "Pass");
		}catch(Exception e)
		{
			reportStep("UserName is not entered sucessfully"+e.toString(),"Fail");
		}
		return this;
	}


	public LoginPage enterPassword(String pwd)
	{
		try
		{
			driver.findElement(By.id("password")).sendKeys(pwd);
			reportStep("Password entered successfully", "Pass");
		}catch(Exception e)
		{
			reportStep("Password is not entered sucessfully"+e.toString(),"Fail");
		}
		return this;

	}


	public HomePage clickLoginButton()
	{
		try
		{
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Login button is clicked entered successfully", "Pass");
		}catch(Exception e)
		{
			reportStep("Login button is not clicked sucessfully"+e.toString(),"Fail");
		}
		
		
		return new HomePage(driver,objExtNode);

	}

}
