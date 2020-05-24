package com.pop.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pop.pages.ContactUsPageModel;
import com.pop.pages.HomePageModel;

public class ContactUsTest extends BaseTest{
//	WebDriver driver;

	// testcase 4
	@Test
	public void ContactUs4() {
		String mess = "Your message has been successfully sent to our team.";
		
		HomePageModel home = new HomePageModel(webDriver);
		ContactUsPageModel contactUsPageModel = home.clickContactUs();
//		contactUs.insertData();
		contactUsPageModel.inputdata();
		String getMess = contactUsPageModel.getMess();

		assertEquals(mess, getMess);
	}

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
