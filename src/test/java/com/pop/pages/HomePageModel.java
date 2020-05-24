package com.pop.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pop.pages.ContactUsPageModel;

public class HomePageModel extends BaseModel {
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
//	public By BTN_CONTINUE_SHOPPING = By.xpath("//*[@id=\"layer_cart\"]//div[@class=\"button-container\"]/span/span");

	@FindBy (xpath = "//*[@id=\"layer_cart\"]//div[@class=\"button-container\"]/span/span")
	WebElement btnContinueShopping;
	public HomePageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public LoginAndSinupPageModel clickSignin() {
		webDriver.findElement(btnSignUp).click();
		return new LoginAndSinupPageModel(webDriver);
	}

	public ContactUsPageModel clickContactUs() {
		webDriver.findElement(linkContactUs).click();
		return new ContactUsPageModel(webDriver);
	}

	public HomePageModel submitLetter(String email) {
		webDriver.findElement(txtSubmitNewLetter).sendKeys(email);
		webDriver.findElement(btnSubmitNewLetter).click();
		return new HomePageModel(webDriver);
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
		webDriver.findElement(TXT_SEARCH).sendKeys(key);
		webDriver.findElement(TXT_SEARCH).click();
		webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public int getTotalSuggestions() {
		return webDriver.findElements(listSuggestions).size();
	}

	public int[] getListTotalSuggestions(String key) {
		int[] listTotalSuggestions = new int[2];
		sendKeyAndAppearSuggestions(key);
//		if (isElementPresent(listSuggestions)) {
		listTotalSuggestions[0] = webDriver.findElements(listSuggestions).size();
		listTotalSuggestions[1] = webDriver.findElements(By.xpath(createXpathSearchWithKey(key))).size();
		return listTotalSuggestions;
//		}
//		return null;
	}

	public String getTextSuggestion(int indexOfSuggestion) {
		return webDriver.findElement(By.xpath(createXpathSearchWithIndex(indexOfSuggestion))).getText();
	}

	public ProductPageModel clickSuggestion(int indexOfSuggestion) {
		webDriver.findElement(By.xpath(createXpathSearchWithIndex(indexOfSuggestion))).click();
		return new ProductPageModel(webDriver);
	}

	public SearchPageModel clickSearch(String key) {
		webDriver.findElement(TXT_SEARCH).sendKeys(key);
		webDriver.findElement(BTN_SEARCH).click();
		return new SearchPageModel(webDriver);
	}

	
	public void clickAddToCartWithIndex(int indexOfProduct) {
		String xpath = "//*[@id=\"homefeatured\"]/li[" + indexOfProduct + "]/div//a[@title=\"Add to cart\"]";
		WebElement product = webDriver.findElement(By.xpath(xpath));
		click(product, 500, "Product");
		click(btnContinueShopping, 500, "Continue");
	}
	
	public void clickAddToCart(String productName) {
		String xpath = "(//mat-option)/span[contains(text(),'" + productName + "')]";
		webDriver.findElement(By.xpath(xpath)).click();
	}
}
