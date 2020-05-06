package com.pop.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.pop.pages.ContactUsPage;

public class HomePage extends Base {
	private By btnSignUp = By.linkText("Sign in");
	private By txtSubmitNewLetter = By.xpath("//*[@id=\"newsletter-input\"]");
	private By btnSubmitNewLetter = By.xpath("//*[@id=\"newsletter_block_left\"]//button");
	private By alertSubscribed = By.xpath("//*[@id=\"columns\"]/p[contains(text(),\"successfully subscribed\")]");
	private By linkContactUs = By.xpath("//*[@id=\"contact-link\"]/a");
	
	private By btnSearch = By.xpath("//*[@id=\"searchbox\"]/button");
	private By txtSearch = By.xpath("//*[@id=\"search_query_top\"]");
	private By styleSearch = By.xpath("//*[@style=\"position: absolute; display: block; width: 370px; top: 198px; left: 437.484px;\"]");
	private By listSuggestions = By.xpath("//div[@class=\"ac_results\"]/ul/li");
	//div[@class="ac_results"]/ul/li[contains(text(),"Dress")]
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginAndSinup clickSignin() {
		driver.findElement(btnSignUp).click();
		return new LoginAndSinup(driver);
	}
	
	public ContactUsPage clickContactUs() {
		driver.findElement(linkContactUs).click();
		return new ContactUsPage(driver);
	}

	public HomePage submitLetter(String email) {
		driver.findElement(txtSubmitNewLetter).sendKeys(email);
		driver.findElement(btnSubmitNewLetter).click();
		return new HomePage(driver);
	}
	
	public boolean Subscribed() {
		if(isElementPresent(alertSubscribed)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public int totalSuggestions (String key) {
		driver.findElement(txtSearch).sendKeys(key);
		driver.findElement(txtSearch).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(driver.findElements(listSuggestions).size());
		if(isElementPresent(listSuggestions)) {
			return driver.findElements(listSuggestions).size();
		}
		return 0;
	}
}
