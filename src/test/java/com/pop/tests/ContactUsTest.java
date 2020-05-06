package com.pop.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pop.pages.ContactUsPage;
import com.pop.pages.HomePage;

public class ContactUsTest {
	WebDriver driver;

	// testcase 4
	@Test
	public void ContactUs4() {
		String mess = "Your message has been successfully sent to our team.";
		
		HomePage home = new HomePage(driver);
		ContactUsPage contactUs = home.clickContactUs();
		contactUs.insertData();
		String getMess = contactUs.getMess();

		assertEquals(mess, getMess);
	}

	@BeforeMethod
	public void beforeMethod() {
		
		System.setProperty("webdriver.chrome.driver", ".//Setup//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

	}

	@AfterMethod
	public void afterMethod() {
	}
}
