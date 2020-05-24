package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseModel {
	protected WebDriver webDriver;

	/**
	 * method return web title
	 */
	public String getTitle() {
		return webDriver.getTitle();
	}

	/**
	 * method return web title
	 */
	public String getCurrentUrl() {
		return webDriver.getCurrentUrl();
	}

	/**
	 * method to wait a few second and click into element
	 */
	public static void iwait(long timer) {
		try {
			System.out.println("wait in " + timer + " milisecs");
			Thread.sleep(timer);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * method to click into element and wait a few second
	 */
	public void click(WebElement webElement, long timer) {
		System.out.println("click: "+ webElement);
		webElement.click();
		iwait(timer);
	}

	/**
	 * method to wait a few second and click into element
	 */
	public void click(long timer, WebElement webElement) {
		iwait(timer);
		System.out.println("click: " + webElement +" in  "+ timer + " miliseconds");
		webElement.click();
	}
	/**
	 * method to click into element
	 */
	public void click(WebElement webElement) {
		System.out.println("click " + webElement);
		webElement.click();
	}
	/**
	 * method to click into element and wait a few second
	 */
	public void click(WebElement webElement, long timer, String nameElement) {
		System.out.println("click: "+ nameElement);
		webElement.click();
		iwait(timer);
	}

	/**
	 * method to wait a few second and click into element
	 */
	public void click(long timer, WebElement webElement, String nameElement) {
		iwait(timer);
		System.out.println("click: " + nameElement +" in  "+ timer + " miliseconds");
		webElement.click();
	}
	/**
	 * method to click into element
	 */
	public void click(WebElement webElement, String nameElement) {
		System.out.println("click " + nameElement);
		webElement.click();
	}
	/**
	 * method to wait a second and click into element
	 */
	public void Click(WebElement webElement) {
		System.out.println("click in a second");
		iwait(1000);
		webElement.click();
	}

	/**
	 * method to click into element by js
	 */
	public void clickJs(WebElement webElement) {
		System.out.println("click");
		JavascriptExecutor executor = (JavascriptExecutor) this.webDriver;
		executor.executeScript("arguments[0].click();", webElement);
		// arguments[0].removeAttribute('disabled')
	}

	/**
	 * method to click into element by js
	 */
	public void removeAttributeByJs(WebElement webElement, String attribute) {
		JavascriptExecutor executor = (JavascriptExecutor) this.webDriver;
		executor.executeScript("arguments[0].removeAttribute('" + attribute + "');", webElement);
	}

	/**
	 * method to type into element
	 */
	public void type(String keysToSend, WebElement webElement) {
		System.out.println("type " + keysToSend + " into " + webElement);
		webElement.sendKeys(keysToSend);
	}

	/**
	 * method to type into element
	 */
	public void type(WebElement webElement, String keysToSend) {
		System.out.println("type " + keysToSend + " into " + webElement);
		webElement.sendKeys(keysToSend);
	}

	/**
	 * method to type into element
	 */
	public void type(Keys keysToSend, WebElement webElement) {
		System.out.println("type " + keysToSend);
		webElement.sendKeys(keysToSend);
	}

	/**
	 * method to clear into element
	 */
	public void clear(WebElement webElement) {
		System.out.println("clear " + webElement);
		webElement.clear();
	}
	
	public String getText(WebElement webElement) {
		return webElement.getText();
	}

	/**
	 * method to log information
	 */
	public void log(String message) {
		System.out.println(message);
	}

	/**
	 * method to log information
	 */
	public void log(String message, String suffix) {
		for (int i = 0; i < 9; i++) {
			message += suffix;
		}
		System.out.println(message);
	}

	public BaseModel(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(this.webDriver, this);
	}

//	public void clickOptionWithContainsText(String containsText) {
//		String xpath = "(//mat-option)/span[contains(text(),'" + containsText + "')]";
//		webDriver.findElement(By.xpath(xpath)).click();
//	}

	public boolean isElementPresent(By locator) {
		try {
			webDriver.findElement(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public WebElement waitAndGetElement(By locator, long timeOut) throws InterruptedException {
		for (int i = 0; i < timeOut / 500; i++) {
			if (isElementPresent(locator))
				return webDriver.findElement(locator);
			else {
				System.out.println("Element not available");
				iwait(500);
			}
		}
		return null;
	}
}
