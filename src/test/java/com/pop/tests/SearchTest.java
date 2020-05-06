package com.pop.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pop.pages.HomePage;

public class SearchTest {

	WebDriver driver;

	// testcase 5
	@Test
	public void Search5() {
		HomePage home = new HomePage(driver);
		String key = "bababababa";
//		String xpathWithKey = "//div[@class=\"ac_results\"]/ul/li[contains(text(),\""+ key +"\")]";
		String xpathWithKey = "//div[@class=\"ac_results\"]/ul/li[contains(translate(text(),\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\",\"abcdefghijklmnopqrstuvwxyz\"),\""+ key +"\")]";
		int totalSuggestions = home.totalSuggestions(key);
		int suggestionsHasKey = driver.findElements(By.xpath(xpathWithKey)).size();
		System.out.println(totalSuggestions);
		System.out.println(suggestionsHasKey);
		assertEquals(totalSuggestions, suggestionsHasKey);
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
