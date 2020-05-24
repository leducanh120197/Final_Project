package com.pop.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pop.pages.HomePageModel;
import com.pop.pages.GmailPageModel;

public class NewLetterTest extends BaseTest{
	
	// testcase 3
	@Test(enabled = true)
	public void submitNewLetter() {
		HomePageModel home = new HomePageModel(webDriver).submitLetter("anhld.lqa-1@gmail.com");
		if(home.subscribed()) {
			System.out.println("Subscribed");
		}		
		else {
			System.out.println("Can not");
		}
		
		//Check mail
		String handleHome = webDriver.getWindowHandle();
		((JavascriptExecutor) webDriver).executeScript("window.open('https://mail.google.com/mail/u/3/#inbox','_blank');");
		GmailPageModel gmailPage = new GmailPageModel(webDriver);
//		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("xxx");
		
		Set<String> handles = webDriver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(handleHome)) {
				webDriver.switchTo().window(handle);
			}
		}
		gmailPage = gmailPage.loginGmail();
		if(gmailPage.checkGmail()) {
			System.out.println("Received");
		}
		else {
			System.out.println("Not Received");
		}
	}
//	
//	@BeforeMethod
//	public void beforeMethod() {
//		System.setProperty("webdriver.chrome.driver", ".//webdriver//chromedriver.exe");
//		webDriver = new ChromeDriver();
//		webDriver.get("http://automationpractice.com/index.php");
//
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//	}
}
