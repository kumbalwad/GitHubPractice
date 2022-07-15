package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.FrameworkBase;

public class Whatsapp extends FrameworkBase {

	@FindBy(xpath = "//span[text()='Baburao Garke']//ancestor::div[@role='row']//parent::div")
	public WebElement clickOnChat;
	@FindBy(xpath = "//div[@title='Type a message']")
	public WebElement inputBox;
	@FindBy(xpath = "//div[@class='_3HQNh _1Ae7k']//child::button")
	public WebElement send;

	public void sendMsgTo() {
		waitForSec(40);
		PageFactory.initElements(driver, this);
		clickOnChat.click();
//		driver.findElement(By.xpath("//span[text()='Baburao Garke']//ancestor::div[@role='row']//parent::div")).click();
		for (int i = 0; i < 100; i++) {
			inputBox.sendKeys("Le Good Night");
			send.click();
		}

	}

}
