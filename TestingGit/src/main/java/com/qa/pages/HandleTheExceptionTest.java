package com.qa.pages;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class HandleTheExceptionTest {

	@Test(expectedExceptions = ArithmeticException.class)
	public void arithmeticException() {
		int a = 5, b = 0;
		int c = a / b;

		System.out.println("exception is handeled by testNG" + c);
	}

	@Test(expectedExceptions = NullPointerException.class)
	public void nullPointerException() {
		String str = null;
		System.out.println(str.length());
	}
	
	@Test
	public void skipTestCase() {
		System.out.println("before skiping test case");
		
		throw new SkipException("I am skiping this test case");
	}
}
