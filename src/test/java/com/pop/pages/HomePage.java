package com.pop.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.pop.pages.ContactUsPage;

public class HomePage extends Base {
	public By btnSignUp = By.linkText("Sign in");
	public By txtSubmitNewLetter = By.xpath("//*[@id=\"newsletter-input\"]");
	public By btnSubmitNewLetter = By.xpath("//*[@id=\"newsletter_block_left\"]//button");
	public By alertSubscribed = By.xpath("//*[@id=\"columns\"]/p[contains(text(),\"successfully subscribed\")]");
	public By linkContactUs = By.xpath("//*[@id=\"contact-link\"]/a");

	public By BTN_SEARCH = By.xpath("//*[@id=\"searchbox\"]/button");
	public By TXT_SEARCH = By.xpath("//*[@id=\"search_query_top\"]");
	public By styleSearch = By
			.xpath("//*[@style=\"position: absolute; display: block; width: 370px; top: 198px; left: 437.484px;\"]");
	public By listSuggestions = By.xpath("//div[@class=\"ac_results\"]/ul/li");
//	public By BTN_CONTINUE_SHOPPING = By.xpath("//*[@id=\"layer_cart\"]//span[@title=\"Continue shopping\"]");
	public By BTN_CONTINUE_SHOPPING = By.xpath("//*[@id=\"layer_cart\"]//div[@class=\"button-container\"]/span/span");

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

	public boolean subscribed() {
		if (isElementPresent(alertSubscribed)) {
			return true;
		} else {
			return false;
		}
	}

	public String createXpathSearchWithKey(String key) {
		return "//div[@class=\"ac_results\"]/ul/li[contains(translate(text(),\"ABCDEFGHIJKLMNOPQRSTUVWXYZ\",\"abcdefghijklmnopqrstuvwxyz\"),\""
				+ key + "\")]";
	}

	public String createXpathSearchWithIndex(int indexOfSuggestion) {
		return "//div[@class=\"ac_results\"]/ul/li[" + indexOfSuggestion + "]";
	}

	public void sendKeyAndAppearSuggestions(String key) {
		driver.findElement(TXT_SEARCH).sendKeys(key);
		driver.findElement(TXT_SEARCH).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public int getTotalSuggestions() {
		return driver.findElements(listSuggestions).size();
	}

	public int[] getListTotalSuggestions(String key) {
		int[] listTotalSuggestions = new int[2];
		sendKeyAndAppearSuggestions(key);
//		if (isElementPresent(listSuggestions)) {
		listTotalSuggestions[0] = driver.findElements(listSuggestions).size();
		listTotalSuggestions[1] = driver.findElements(By.xpath(createXpathSearchWithKey(key))).size();
		return listTotalSuggestions;
//		}
//		return null;
	}

	public String getTextSuggestion(int indexOfSuggestion) {
		return driver.findElement(By.xpath(createXpathSearchWithIndex(indexOfSuggestion))).getText();
	}

	public ProductPage clickSuggestion(int indexOfSuggestion) {
		driver.findElement(By.xpath(createXpathSearchWithIndex(indexOfSuggestion))).click();
		return new ProductPage(driver);
	}

	public SearchPage clickSearch(String key) {
		driver.findElement(TXT_SEARCH).sendKeys(key);
		driver.findElement(BTN_SEARCH).click();
		return new SearchPage(driver);
	}

	public String createXpathAddToCartWithIndex(int indexOfProduct) {
//		String x = "//*[@id=\"homefeatured\"]/li[1]/div//a[@title=\"Add to cart\"]";
		return "//*[@id=\"homefeatured\"]/li[" + indexOfProduct + "]/div//a[@title=\"Add to cart\"]";
	}
	
	public void clickAddToCartI(int indexOfProduct){
		driver.findElement(By.xpath(createXpathAddToCartWithIndex(indexOfProduct))).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(BTN_CONTINUE_SHOPPING).click();
		if(indexOfProduct == 3) {
			driver.findElement(BTN_CONTINUE_SHOPPING).click();
		}
		System.out.println(indexOfProduct);
//		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

}
