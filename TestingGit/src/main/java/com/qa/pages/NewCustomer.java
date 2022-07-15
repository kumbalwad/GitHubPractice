package com.qa.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomer extends LoginPage {
	@FindBy(partialLinkText = "New Customer")
	public WebElement newCustomer;

	@FindBy(xpath = "//iframe[@title='3rd party ad content']")
	public WebElement mainFrame;

	@FindBy(xpath = "//iframe[@id='ad_iframe']")
	public WebElement adFrame;
	
	@FindBy(xpath = "//div[@id='dismiss-button']")
	public WebElement closeFrame1;

	@FindBy(xpath = "//div[@id='card']//descendant::div[@id='dismiss-button']")
	public WebElement closeFrame;

	@FindBy(xpath = "//input[@name='name']")
	public WebElement name;

	@FindBy(xpath = "//input[@name='dob']")
	public WebElement dob;

	@FindBy(xpath = "//textarea[@name='addr']")
	public WebElement addr;

	@FindBy(xpath = "//input[@name='city']")
	public WebElement city;

	@FindBy(xpath = "//input[@name='state']")
	public WebElement state;

	@FindBy(xpath = "//input[@name='pinno']")
	public WebElement zipPin;

	@FindBy(xpath = "//input[@name='telephoneno']")
	public WebElement telephone;

	@FindBy(xpath = "//input[@name='emailid']")
	public WebElement email;

	public NewCustomer() {
		PageFactory.initElements(driver, this);
	}

	public void customerDetails() {
		newCustomer.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.switchTo().frame(mainFrame);
//		
		try {
			driver.switchTo().frame(adFrame);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", closeFrame1);
		}
		catch(Exception E){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", closeFrame);
		}
		
//		driver.switchTo().frame(adFrame);
//		closeFrame.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", closeFrame);
//		String str=property.getProperty("customerName");
//		name.sendKeys(property.getProperty("customerName"));
		
		waitForSec(5);

		List<String> keyList = new ArrayList<String>();

		keyList.add("CustomerName");
		keyList.add("DOB");
		keyList.add("CustomerAddr");
		keyList.add("CustomerCity");
		keyList.add("CustomerState");
		keyList.add("Pin");
		keyList.add("TelephoneNO");
		keyList.add("EmailId");

		List<WebElement> webList = new ArrayList<WebElement>();

		webList.add(name);
		webList.add(dob);
		webList.add(addr);
		webList.add(city);
		webList.add(state);
		webList.add(zipPin);
		webList.add(telephone);
		webList.add(email);

		for (int i=0; i<8; i++){
			
			webList.get(i).sendKeys(property.getProperty(keyList.get(i)));
		}

	}

}
