package com.qa.pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.base.FrameworkBase;

public class LoginPage extends FrameworkBase{
	public static Logger logger=LogManager.getLogger(LoginPage.class);

	@FindBy(name="uid")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void crendential(String id, String pass)
	{
		
			logger.error("this is error message");
			logger.info("this is error message");
			logger.warn("this is error message");
			logger.fatal("this is error message");
			
		
		username.sendKeys(id);
		password.sendKeys(pass);
		loginBtn.click();
		String str=driver.findElement(By.xpath("//marquee[contains(text(),'Welcome')]")).getText();
		Assert.assertEquals(str, "Welcome To Manager's Page of GTPL Bank");
	}
}
