package com.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.FrameworkBase;

public class CreateAccount extends FrameworkBase {

	@FindBy(xpath = "//span[text()='Create an Account']")
	public WebElement create;

	@FindBy(xpath = "//input[@title='Middle Name/Initial']")
	public WebElement middleName;

	@FindBy(xpath = "//input[@class='input-text validate-email required-entry']")
	public WebElement email;

	@FindBy(xpath = "//a[text()='Sign up']")
	public WebElement signUpBtn;

	@FindBy(xpath = "//input[@name='firstname']")
	public WebElement firstname;

	@FindBy(xpath = "//input[@name='lastname']")
	public WebElement lastname;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement emailID;

	@FindBy(xpath = "//input[@name='phonenumber']")
	public WebElement phonenumber;

	@FindBy(xpath = "//input[@name='address1']")
	public WebElement street;

	@FindBy(xpath = "//input[@name='city']")
	public WebElement city;

	@FindBy(xpath = "//select[@id='stateselect']")
	public WebElement state;

	@FindBy(xpath = "//input[@name='postcode']")
	public WebElement postcode;

	@FindBy(xpath = "//select[@id='inputCountry']")
	public WebElement country;

	Select select = null;
//	public CreateAccount() {
//		PageFactory.initElements(driver, this);
//	}

	public void customerDetails() {
		create.click();
		waitForSec(3);
		middleName.sendKeys(property.getProperty("middlenameTest"));
		email.sendKeys(property.getProperty("emailaddress"));

	}

	public void signUpPhpTravels() {
		PageFactory.initElements(driver, this);

		waitForSec(10);
		signUpBtn.click();

		waitForSec(3);
		String currentWindow = driver.getWindowHandle();

		Set<String> handle = driver.getWindowHandles();
		Iterator<String> itr = handle.iterator();
		while (itr.hasNext()) {

			String nextWindow = itr.next();
			driver.switchTo().window(nextWindow);

			String title = driver.getTitle();
			System.out.println("Next Window Title= " + title);
		}

		firstname.sendKeys("Rocky");
		lastname.sendKeys("Bhai");
		emailID.sendKeys("rocky@gmail.com");
		phonenumber.sendKeys("+911234567890");
		street.sendKeys("kphb");
		city.sendKeys("Hyderabad");
		postcode.sendKeys("500072");

		select = new Select(country);
		select.selectByValue("IN");
		waitForSec(2);
		select = new Select(state);
		select.selectByVisibleText("Telangana");

		waitForSec(5);

		driver.switchTo().window(currentWindow);
		String title1 = driver.getTitle();
		System.out.println("Current Window Title= " + title1);
	}
}