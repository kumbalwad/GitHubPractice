package com.qa.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.Whatsapp;

public class WhatsappTest extends Whatsapp{

	@BeforeClass
	public void launcBrowser()
	{
		browserLaunch();
	}
	
	@Test
	public void sendMsgTest() {
//		Whatsapp a=new Whatsapp();
		sendMsgTo();
	}
}
