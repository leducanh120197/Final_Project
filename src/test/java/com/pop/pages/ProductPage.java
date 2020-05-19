package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Base{
	public By NAME_PRODUCT = By.xpath("//h1[@itemprop=\"name\"]");
	public By BACK_HOME = By.xpath("//a[@title=\"Return to Home\"]");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getProductName() {
		return driver.findElement(NAME_PRODUCT).getText();
	}

	public HomePage clickBackHomePage() {
		driver.findElement(BACK_HOME).click();
		return new HomePage(driver);
	}
}
