package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPageModel extends BaseModel {
	public By ALERT_SEARCH = By.xpath("//p[@class=\"alert alert-warning\"]");
	
	
	public SearchPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	
	public String getAlertSearch() {
		return webDriver.findElement(ALERT_SEARCH).getText();
	}
}
