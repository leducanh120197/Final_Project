package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageModel extends BaseModel{
	public By NAME_PRODUCT = By.xpath("//h1[@itemprop=\"name\"]");
	public By BACK_HOME = By.xpath("//a[@title=\"Return to Home\"]");
	
	public ProductPageModel(WebDriver webDriver) {
		super(webDriver);
	}
	
	public String getProductName() {
		return webDriver.findElement(NAME_PRODUCT).getText();
	}

	public HomePageModel clickBackHomePage() {
		webDriver.findElement(BACK_HOME).click();
		return new HomePageModel(webDriver);
	}
}
