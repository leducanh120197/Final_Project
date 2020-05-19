package com.pop.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.pop.helpers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

import com.pop.pages.HomePage;
import com.pop.pages.ProductPage;
import com.pop.pages.SearchPage;

public class SearchTest {

	WebDriver driver;

	// testcase Search 6-1
	@Test
	public void checkSuggestionsInfor() {
		HomePage home = new HomePage(driver);
		String key = "shirt";
		int[] listTotalSuggestions = home.getListTotalSuggestions(key);
		int totalSuggestions = listTotalSuggestions[0];
		int totalSuggestionsHasKey = listTotalSuggestions[1];
		System.out.println(totalSuggestions);
		System.out.println(totalSuggestionsHasKey);
		assertEquals(totalSuggestions, totalSuggestionsHasKey);
	}

	// testcase Search 6-3
	@Test
	public void checkSuggestionClick() {
		HomePage home = new HomePage(driver);
		String key = "dress";
		home.sendKeyAndAppearSuggestions(key);
		int countSuggestions = home.getTotalSuggestions();
		if (countSuggestions > 0) {
			for (int index = 1; index <= countSuggestions; index++) {
				try {
					home.sendKeyAndAppearSuggestions(key);
					String nameSuggestion = home.getTextSuggestion(index);
					ProductPage productPage = home.clickSuggestion(index);
					String productName = productPage.getProductName();
					assertTrue(nameSuggestion.toLowerCase().contains(productName.toLowerCase()),
							"Can not find [" + productName + "] in " + nameSuggestion);
					System.out.println(nameSuggestion + " : " + productName);
				} catch (Exception e) {
//					e.printStackTrace();
				}
			}
		}
		else {
			System.out.println("No suggestion");
		}
	}
	
	// testcase Search 7
	@Test
	public void checkResultWithErrorKey() {
		HomePage home = new HomePage(driver);
		String key = "dresSss";
		String strActual = "No results were found for your search \""+ key +"\"";
		SearchPage searchPage = home.clickSearch(key);
		String alert = searchPage.getAlertSearch();
		assertEquals(strActual, alert);
	}
	

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", ".//webdriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
	}

	@AfterMethod
	public void afterMethod() {
		helper.pause(5000);
		driver.close();
	}
}
