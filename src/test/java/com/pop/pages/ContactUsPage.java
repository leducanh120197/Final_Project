package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends Base {
	public By selectSubject = By.id("id_contact");
	public By txtEmail = By.id("email");
	public By txtOrder = By.id("id_order");

	public By inputFileSelect = By.xpath("//*[@id=\"fileUpload\"]");
	public By btnSent = By.id("submitMessage");
	public By txtMess = By.id("message");
	public By mess = By.xpath("//p[contains(text(),\"message has been successfully\")]");

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void insertData() {
		Select select = new Select(driver.findElement(selectSubject));
		select.selectByVisibleText("Webmaster");
		driver.findElement(txtEmail).sendKeys("abc@gmail.com");
		driver.findElement(txtOrder).sendKeys("order");
		driver.findElement(inputFileSelect)
				.sendKeys("C:\\Users\\LQA\\OneDrive\\___Code\\FinalProject\\Setup\\File.txt");
		driver.findElement(txtMess).sendKeys("Mess");
		driver.findElement(btnSent).click();
	}
	public String getMess() {
		return driver.findElement(mess).getText();
	}

}
