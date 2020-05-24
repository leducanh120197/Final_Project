package com.pop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pop.pages.HomePageModel;

import com.pop.helpers.helper;

public class BuyTest extends BaseTest{
	@Test
	public void buy() {
		HomePageModel home = new HomePageModel(webDriver);
		for(int i=1;i<=3;i++) {
			home.clickAddToCartWithIndex(i);
			System.out.println(i);
		}
	}
}
