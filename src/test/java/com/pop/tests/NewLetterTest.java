package com.pop.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pop.pages.HomePage;
import com.pop.pages.GmailPage;

public class NewLetterTest {
	WebDriver driver;
	
	// testcase 3
	@Test(enabled = true)
	public void submitNewLetter() {
		HomePage home = new HomePage(driver).submitLetter("anhld.lqa-1@gmail.com");
		if(home.subscribed()) {
			System.out.println("Subscribed");
		}		
		else {
			System.out.println("Can not");
		}
		
		//Check mail
		
		String handleHome = driver.getWindowHandle();
		((JavascriptExecutor) driver).executeScript("window.open('https://mail.google.com/mail/u/3/#inbox','_blank');");
		GmailPage gmailPage = new GmailPage(driver);
//		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("xxx");
		
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(handleHome)) {
				driver.switchTo().window(handle);
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
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", ".//webdriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

	}

	@AfterMethod
	public void afterMethod() {
	}
}
