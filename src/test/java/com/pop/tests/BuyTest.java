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

import com.pop.pages.HomePage;

import com.pop.helpers.helper;

public class BuyTest {
	WebDriver driver;

	@Test
	public void buy() {
//		Actions builder = new Actions(driver); 
//		Point location ratingElementDiv[i].getLocation(); 
//		builder.MoveToElement(WaitForElement(By.CssSelector(starElement)), location.X, location.Y).click();
		
//		driver.findElement(By.linkText("Select Your Test")).click();
//		while(true) {
//			new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5"))).perform();
//		}
		HomePage home = new HomePage(driver);
		for(int i=1;i<=3;i++) {
			home.clickAddToCartI(i);
			System.out.println(i);
		}
		
		
	}
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", ".//webdriver//chromedriver.exe");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", ".//webdriver//geckodriver.exe");
//		driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		System.out.println("START--------------------");
	}

	@AfterMethod
	public void afterMethod() {
		helper.pause(20000);
		driver.close();
	}
}
