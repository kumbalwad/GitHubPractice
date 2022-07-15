package com.qa.pages;

import org.testng.annotations.Test;

public class GroupTestCase {

	@Test(dependsOnGroups="Smoke")
	public void testCase1() {
		System.out.println("this is test case 1");

	}

	@Test(groups="Sanity")
	public void testCase2() {
		System.out.println("this is test case 2");

	}

	@Test(groups="Smoke")
	public void testcase3() {
		System.out.println("this is test case 3");
	}
}
