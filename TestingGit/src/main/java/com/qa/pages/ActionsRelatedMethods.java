package com.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.FrameworkBase;

public class ActionsRelatedMethods extends FrameworkBase{

	@FindBy(xpath="//span[text()='Jobs']")
	public WebElement job;
	
	@FindBy(xpath="//a[text()='JOB-A-THON']")
	public WebElement jobAThon;
	
	@FindBy(xpath="//iframe[@class='demo-frame lazyloaded']")
	public WebElement iframe;
	
	@FindBy(xpath="//h5[text()='High Tatras 4']//following-sibling::img")
	public WebElement dragElement;
	
	@FindBy(xpath="//div[@id='trash']")
	public WebElement dropElement;
	
	@FindBy(xpath="//input[@id='target']")
	public WebElement inputKey;
	
	public static Actions act=null;
	
	public void maouseHoveringMethod()
	{
		//topGeeks site
		PageFactory.initElements(driver, this);
		waitForSec(2);
		act=new Actions(driver);
		
		act.moveToElement(job).build().perform();
		jobAThon.click();
	}
	
	public void dragAndDropMethod() {
		
		PageFactory.initElements(driver, this);
		
		driver.switchTo().frame(iframe);
		
		act=new Actions(driver);
//		act.moveToElement(dragElement).clickAndHold().moveToElement(dragElement).build().perform();
		//OR
//		act.moveToElement(dragElement).clickAndHold().build().perform();
//		act.moveToElement(dropElement).release().build().perform();
		//OR
		act.dragAndDrop(dragElement, dropElement).build().perform();
	}
	
	public void keyBoardHandlingMethod()
	{
		PageFactory.initElements(driver, this);
		act=new Actions(driver);
		waitForSec(3);
		act.sendKeys(Keys.ENTER).build().perform();
		
		waitForSec(3);
		act.sendKeys(Keys.ESCAPE).build().perform();
		
		act.keyDown(inputKey,Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();
	}
}
