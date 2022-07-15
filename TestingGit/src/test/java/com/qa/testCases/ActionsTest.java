package com.qa.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.ActionsRelatedMethods;

public class ActionsTest extends ActionsRelatedMethods {
	
	@BeforeClass
	public void launcBrowser()
	{
		browserLaunch();
	}
	
	@Test(enabled=true)
	public void testCase1()
	{
//		maouseHoveringMethod();
//		dragAndDropMethod();
		keyBoardHandlingMethod();
	}

}
