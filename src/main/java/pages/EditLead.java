package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import base.BaseClass;


public class EditLead extends BaseClass {
	
	public EditLead(WebDriver driver, ExtentTest node)
	{
		this.driver=driver;
		this.objExtNode=node;
	}
	
	public EditLead editLeadDescription(String desc)
	{
		try
		{
			driver.findElement(By.id("updateLeadForm_description")).sendKeys(desc);
			reportStep("Description entered fine","Pass");
		}catch(Exception e)
		{
			reportStep("Description is not entered "+e.toString(),"Fail");
		}
		return this;
	}
	
	public ViewLeadPage clickUpdateLeadButton()
	{
		try
		{
			driver.findElement(By.className("smallSubmit")).click();
			reportStep("Update lead button is clicked fine ","Pass");
		}catch(Exception e)
		{
			reportStep("Update lead button is not clicked "+e.toString(),"Fail");
		}
		return new ViewLeadPage(driver,objExtNode);
	}
	
	
	
	

}
