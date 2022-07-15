package com.qa.testCases;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.CreateAccount;
import com.qa.pages.LoginPage;

public class LoginTest extends CreateAccount{
	
	
	@BeforeClass
	public void launchBrowser()
	{
		browserLaunch();
	}
	
	@Test
	public void testCase1()
	{
		LoginPage lp=new LoginPage();
		lp.crendential("mngr412525", "redapah");
	}

	@AfterClass
	public void tearDown()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		driver.close();
	}
}
