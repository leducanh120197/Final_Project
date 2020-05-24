package com.pop.tests;

import org.testng.annotations.Test;

import com.pop.pages.HomePageModel;
import com.pop.pages.LoginAndSinupPageModel;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class LoginTest extends BaseTest{
	@Test
	public void login() {
		HomePageModel home = new HomePageModel(webDriver);
		LoginAndSinupPageModel login = home.clickSignin();
	}
}
