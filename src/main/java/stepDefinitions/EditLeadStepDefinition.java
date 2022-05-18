package stepDefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import driverManager.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditLeadStepDefinition extends BaseClass{
	@When("User clicks on Edit lead button")
	public void clickEditButton()
	{
		DriverManager.getDriver().findElement(By.linkText("Edit")).click();
	}
	
	@When("User updates the description as {string}")
	public void editDescription(String desc)
	{
		DriverManager.getDriver().findElement(By.id("updateLeadForm_description")).sendKeys(desc);
	}
	
	
	@When("User clicks on update button")
	public void clickUpdateButton()
	{
		DriverManager.getDriver().findElement(By.className("smallSubmit")).click();
	}
	
	@Then("Updated descirption is displayed as {string} on the view lead page")
	public void verifyUpdatedDescription(String desc)
	{
		String actDesc=DriverManager.getDriver().findElement(By.id("viewLead_description_sp")).getText();
		Assert.assertTrue(actDesc.equals(desc));
	}
	
	

}
