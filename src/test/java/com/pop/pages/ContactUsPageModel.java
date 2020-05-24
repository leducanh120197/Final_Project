package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPageModel extends BaseModel {
//	public By selectSubject = By.id("id_contact");
//	public By txtEmail = By.id("email");
//	public By txtOrder = By.id("id_order");
//
//	public By inputFileSelect = By.xpath("//*[@id=\"fileUpload\"]");
//	public By btnSent = By.id("submitMessage");
//	public By txtMess = By.id("message");
//	public By mess = By.xpath("//p[contains(text(),\"message has been successfully\")]");
//	public void insertData() {
//		Select select = new Select(webDriver.findElement(selectSubject));
//		select.selectByVisibleText("Webmaster");
//		webDriver.findElement(txtEmail).sendKeys("abc@gmail.com");
//		webDriver.findElement(txtOrder).sendKeys("order");
//		webDriver.findElement(inputFileSelect).sendKeys("C:\\Users\\LQA\\OneDrive\\___Code\\FinalProject\\Setup\\File.txt");
//		webDriver.findElement(txtMess).sendKeys("Mess");
//		webDriver.findElement(btnSent).click();
//	}
	@FindBy(id = "id_contact")
	WebElement idContact;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "id_order")
	WebElement idOrder;

	@FindBy(xpath = "//*[@id=\"fileUpload\"]")
	WebElement fileUpload;

	@FindBy(id = "submitMessage")
	WebElement submitMessage;

	@FindBy(id = "message")
	WebElement message;

	@FindBy(xpath = "//p[contains(text(),\"message has been successfully\")]")
	WebElement messageSuccessfully;

	public ContactUsPageModel(WebDriver webDriver) {
		super(webDriver);
	}

	public void inputdata() {
		String strLink = "C:\\Users\\LQA\\OneDrive\\___Code\\FinalProject\\Setup\\File.txt";
		Select select = new Select(idContact);
		select.selectByVisibleText("Webmaster");
		type("email", this.email);
		type("id order", this.idOrder);
		type(strLink, this.fileUpload);
		type("message", this.message);
		click(500, this.submitMessage, "submitMessage");
	}

	public String getMess() {
		return getText(messageSuccessfully);
//		return webDriver.findElement(mess).getText();
	}

}
