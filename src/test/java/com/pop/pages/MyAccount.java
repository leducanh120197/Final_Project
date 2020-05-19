package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount extends Base {
	public By headingMyAccount = By.xpath("//*[@id=\"center_column\"]/h1");
	public By linkHome = By.xpath("//*[@id=\"center_column\"]/ul/li/a/span");
	
	
	
	public MyAccount (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isMyAccountPage() {
		if(isElementPresent(headingMyAccount)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public HomePage backToHomePage() {
		driver.findElement(linkHome).click();
		return new HomePage(driver);
	}
}
