package com.pop.tests;

import org.testng.annotations.Test;

import com.pop.pages.HomePage;
import com.pop.pages.LoginAndSinup;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
	@Test
	public void Login() {
		HomePage home = new HomePage(driver);
		LoginAndSinup login = home.clickSignin();
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
