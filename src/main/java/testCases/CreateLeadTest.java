package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class CreateLeadTest extends BaseClass
{
	
	@BeforeTest
	public void setExcelFileName()
	{
		excelFileName="CreateLeadTestData";
		testName="Create Lead Test";
		testDescription="Create Lead with mandatory details test";
		testCategory="Functional";
		testAuthor="Sivakumar Ramanan";
	}

	@Test(dataProvider="getData")
	public void createLeadTestCase(String uName, String pwd, String compName, String fName, String lName)
	{
		//Passing the driver reference from baseclass to page classes

		LoginPage objLoginPage= new LoginPage(driver,objExtNode);
		objLoginPage
			.enterUsername(uName)
			.enterPassword(pwd)
			.clickLoginButton()
			.clickCRMSFALink()
			.clickOnLeadsLink()
			.clickCreateLeadLink()
			.enterCompanyName(compName)
			.enterFirstName(fName)
			.enterLastName(lName)
			.clickCreateLeadButton()
			.verifyFirstName(fName);
	}
}
