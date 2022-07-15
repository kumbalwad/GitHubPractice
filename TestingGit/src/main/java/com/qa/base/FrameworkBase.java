package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameworkBase {

	public static WebDriver driver = null;
	public static Properties property = null;

	String path = System.getProperty("user.dir");

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		String str = property.getProperty("url");
		driver.get(str);
		driver.manage().window().maximize();
	}

	public FrameworkBase() {

		property = new Properties();
		try {
			FileInputStream file = new FileInputStream(path + "/src/main/java/com/qa/confg/UserDetails.properties");
			property.load(file);
		} catch (Exception e) {
		}
	}

	public static void waitForSec(int i) {
		try {
			Thread.sleep(i*1000);
		} catch (Exception e) {

		}
	}

}
