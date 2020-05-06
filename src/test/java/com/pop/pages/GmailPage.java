package com.pop.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailPage extends Base {
//	private By txtEmailLogin = By.id("identifierId"); //*[@id="identifierId"]
	private By txtEmailLogin = By.xpath("//*[@id=\"identifierId\"]"); 
	private By btnEmailLogin = By.id("identifierNext");//*[@id="identifierNext"]
	
	private By txtPassLogin = By.xpath("//*[@id=\"password\"]//input"); //input[@type="password"]
	private By btnPassLogin = By.id("passwordNext"); //*[@id="passwordNext"]/span/span
	
	private By trSelenium = By.xpath("//*[@id=\":2p\"]/tbody/tr[contains(text(),\"selenium\")]");
	
	public GmailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean checkGmail() {
		if(isElementPresent(trSelenium)) {
			return true;
		}
		else {
			return false;
		}
	}
	public GmailPage loginGmail() {
		driver.findElement(txtEmailLogin).sendKeys("anhld.lqa@gmail.com");
		driver.findElement(btnEmailLogin).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(txtPassLogin).sendKeys("Lqa213465");
		driver.findElement(btnPassLogin).click();
		return new GmailPage(driver);
		
	}

}
