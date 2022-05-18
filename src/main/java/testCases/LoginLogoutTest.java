package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class LoginLogoutTest extends BaseClass {
	
	@BeforeTest
	public void setUpTestDetails()
	{
		excelFileName="LoginTestData";
		testName="Login Test";
		testDescription="Login Logout Test with multiple user credentials";
		testCategory="Smoke & Functional";
		testAuthor="Sivakumar Ramanan";
	}
	
	@Test(dataProvider="getData")
	public void loginLogOutTestCase(String userName, String password)
	{
		LoginPage objLogin= new LoginPage(driver,objExtNode);
		objLogin
		.enterUsername(userName)
		.enterPassword(password)
		.clickLoginButton()
		.clickLogoutButton();
	}

}
