package com.qa.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.pages.CreateAccount;

public class CreateAccountTest extends CreateAccount {

	@BeforeClass
	public void launchBrowser() {
		browserLaunch();
	}

	@Test
	public void phpTravel() {
		signUpPhpTravels();
	}
}