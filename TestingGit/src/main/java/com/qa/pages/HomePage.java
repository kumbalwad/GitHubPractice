package com.qa.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.FrameworkBase;

public class HomePage extends FrameworkBase {

	@FindBy(partialLinkText = "Log out")
	public WebElement signOut;

	@FindBy(xpath = "//ul[@class='menusubnav']//a")
	public List<WebElement> listElements;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void logout() {
	
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		signOut.click();
		driver.switchTo().alert().accept();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), "GTPL Bank Home Page");
	}

	public void menuList() {
		
		List<String> actualList=new ArrayList<String>();
		
		for (WebElement ele : listElements) {
			actualList.add(ele.getText());
			System.out.println("webelement list= " + ele.getText());
		}
		System.out.println("Actual List="+actualList);
		
		List<String> expectedList=new ArrayList<>();
		expectedList.add("New Customer");
		expectedList.add("Manager");
		expectedList.add("Edit Customer");
		expectedList.add("Delete Customer");
		expectedList.add("New Account");
		expectedList.add("Edit Account");
		expectedList.add("Delete Account");
		expectedList.add("Mini Statement");
		expectedList.add("Customised Statement");
		expectedList.add("Log out");
		System.out.println("Expected List="+expectedList);
		
		Collections.sort(actualList);
		Collections.sort(expectedList);
		
		System.out.println("After sort Actual List="+actualList);
		System.out.println("After sort Expected List="+expectedList);
		Assert.assertEquals(actualList, expectedList);
	}

}
