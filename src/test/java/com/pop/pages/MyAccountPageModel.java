package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPageModel extends BaseModel {
	public By headingMyAccount = By.xpath("//*[@id=\"center_column\"]/h1");
	public By linkHome = By.xpath("//*[@id=\"center_column\"]/ul/li/a/span");
	
	
	
	public MyAccountPageModel (WebDriver webDriver) {
		super(webDriver);
	}
	
	public boolean isMyAccountPage() {
		if(isElementPresent(headingMyAccount)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public HomePageModel backToHomePage() {
		webDriver.findElement(linkHome).click();
		return new HomePageModel(webDriver);
	}
}
