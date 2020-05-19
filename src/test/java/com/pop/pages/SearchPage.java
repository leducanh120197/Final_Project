package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends Base {
	public By ALERT_SEARCH = By.xpath("//p[@class=\"alert alert-warning\"]");
	
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public String getAlertSearch() {
		return driver.findElement(ALERT_SEARCH).getText();
	}
}
