package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp)
	{
	
			//Home page	
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//LoginPage
			LoginPage lp=new LoginPage(driver);
			//lp.setEmail(p.getProperty("email"));
			//lp.setPassword(p.getProperty("password"));
			lp.setEmail(email);	// for DDT
			lp.setPassword(pwd);	// for DDT
			lp.clickLogin();
			
			
			//MyAccount
			MyAccountPage macc=new MyAccountPage(driver);
			boolean targetPage=macc.isMyAccountPageExists();
			
			
			//	Data is valid - login success - test pass - logout
			//	login failed - test fail

			//	Data is invalid - login success - test fail - logout
			//	login failed - test pass			

			if(exp.equalsIgnoreCase("Valid"))
			{
			if(targetPage == true)
			{
			macc.clickLogout();
			Assert.assertTrue(true);			
			}
			else
			{
			Assert.assertTrue(false);
			}
			}


			if(exp.equalsIgnoreCase("Invalid"))
			{
			if(targetPage == true)
			{
			macc.clickLogout();
			Assert.assertTrue(false);
			}
			
			}}}			
			
			
			
			



