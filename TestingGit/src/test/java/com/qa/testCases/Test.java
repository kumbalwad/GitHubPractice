package com.qa.testCases;
import org.testng.annotations.BeforeClass;

import com.qa.pages.LoginPage;


public class Test extends LoginPage {
	
	@BeforeClass
	public void launchBrowser()
	{
		browserLaunch();
	}
	
	
	public void testCase1()
	{
		LoginPage lp=new LoginPage();
		lp.crendential("mngr412525", "redapah");
	}
	
}
