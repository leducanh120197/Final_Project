package com.pop.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailPageModel extends BaseModel {
//	public By txtEmailLogin = By.id("identifierId"); //*[@id="identifierId"]
	public By txtEmailLogin = By.xpath("//*[@id=\"identifierId\"]"); 
	public By btnEmailLogin = By.id("identifierNext");//*[@id="identifierNext"]
	
	public By txtPassLogin = By.xpath("//*[@id=\"password\"]//input"); //input[@type="password"]
	public By btnPassLogin = By.id("passwordNext"); //*[@id="passwordNext"]/span/span
	
	public By trSelenium = By.xpath("//*[@id=\":2p\"]/tbody/tr[contains(text(),\"selenium\")]");
	
	public GmailPageModel(WebDriver webDriver) {
		super(webDriver);
	}
	
	public boolean checkGmail() {
		if(isElementPresent(trSelenium)) {
			return true;
		}
		else {
			return false;
		}
	}
	public GmailPageModel loginGmail() {
		webDriver.findElement(txtEmailLogin).sendKeys("anhld.lqa@gmail.com");
		webDriver.findElement(btnEmailLogin).click();
		webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		webDriver.findElement(txtPassLogin).sendKeys("Lqa213465");
		webDriver.findElement(btnPassLogin).click();
		return new GmailPageModel(webDriver);
		
	}

}
