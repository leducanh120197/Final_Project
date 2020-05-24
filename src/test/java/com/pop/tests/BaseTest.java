package com.pop.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pop.helpers.helper;


public class BaseTest {
	protected WebDriver webDriver;
	
	public void log(String message) {
		System.out.println(message);
	}
	public void log(String message, String suffix) {
		for(int i =0;i<9;i++) {
			message+=suffix;
		}
		System.out.println(message);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("START----index----------------");
		System.setProperty("webdriver.chrome.driver", ".//webdriver//chromedriver.exe");
		webDriver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", ".//webdriver//geckodriver.exe");
//		driver = new FirefoxDriver();
		
		webDriver.get("http://automationpractice.com/index.php");
		
	}

	@AfterMethod
	public void afterMethod() {
		helper.pause(20000);
		System.out.println("-------------------- END --------------------");
		webDriver.close();
	}
}
