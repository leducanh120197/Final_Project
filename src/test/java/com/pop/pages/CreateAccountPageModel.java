package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPageModel extends BaseModel {
	public By headingCreateAccount = By.xpath("//h1[contains(text(),\"Create an account\")]");

	public By radioGender = By.xpath("//*[@id=\"id_gender1\"]");
	public By txtFirstName = By.xpath("//*[@id=\"customer_firstname\"]");
	public By txtLastName = By.xpath("//*[@id=\"customer_lastname\"]");
//	public By txtEmail = By.xpath("//*[@id=\"email\"]");
	public By txtPassWord = By.xpath("//*[@id=\"passwd\"]");
	public By selectDays = By.xpath("//*[@id=\"days\"]");
	public By optionDay = By.xpath("//*[@id=\"days\"]/option[13]");
	public By selectMonths = By.xpath("//*[@id=\"months\"]");
	public By optionMonth = By.xpath("//*[@id=\"months\"]/option[2]");
	public By selectYears = By.xpath("//*[@id=\"years\"]");
	public By optionYear = By.xpath("//*[@id=\"years\"]/option[25]");
	public By txtAddressFirtsName = By.xpath("//*[@id=\"firstname\"]");
	public By txtAddressLastName = By.xpath("//*[@id=\"lastname\"]");
	public By txtCompany = By.xpath("//*[@id=\"company\"]");
	public By txtAddress1 = By.xpath("//*[@id=\"address1\"]");
	public By txtAddress2 = By.xpath("//*[@id=\"address2\"]");
	public By txtCity = By.xpath("//*[@id=\"city\"]");
	public By selectStates = By.xpath("//*[@id=\"id_state\"]");
	public By optionState = By.xpath("//*[@id=\"id_state\"]/option[2]");
	public By txtPostCode = By.xpath("//*[@id=\"postcode\"]");
	public By selectCountrys = By.xpath("//*[@id=\"id_country\"]");
	public By optionCountry = By.xpath("//*[@id=\"id_country\"]/option[2]");
	public By txtOther = By.xpath("//*[@id=\"other\"]");
	public By txtPhone = By.xpath("//*[@id=\"phone\"]");
	public By txtPhoneMobile = By.xpath("//*[@id=\"phone_mobile\"]");
	public By txtAlias = By.xpath("//*[@id=\"alias\"]");
	public By btnRegister = By.xpath("//*[@id=\"submitAccount\"]/span");

	public void insertInformation() {
		webDriver.findElement(radioGender).click();
		webDriver.findElement(txtFirstName).sendKeys("Duc Anh");
		webDriver.findElement(txtLastName).sendKeys("Le");
//		webDriver.findElement(txtEmail).sendKeys();
		webDriver.findElement(txtPassWord).sendKeys("123456");
		
		webDriver.findElement(selectDays).click();
		webDriver.findElement(optionDay).click();
		webDriver.findElement(selectMonths).click();
		webDriver.findElement(optionMonth).click();
		webDriver.findElement(selectYears).click();
		webDriver.findElement(optionYear).click();
		
		webDriver.findElement(txtAddressFirtsName).sendKeys("Duc Anh");
		webDriver.findElement(txtAddressLastName).sendKeys("Le");
		webDriver.findElement(txtCompany).sendKeys("LQA");
		webDriver.findElement(txtAddress1).sendKeys("Dan Nhiem");
		webDriver.findElement(txtAddress2).sendKeys("Dan");
		webDriver.findElement(txtCity).sendKeys("Ha Noi");
		
		webDriver.findElement(selectStates).click();
		webDriver.findElement(optionState).click();
		
		webDriver.findElement(txtPostCode).sendKeys("10000");
		
		webDriver.findElement(selectCountrys).click();
		webDriver.findElement(optionCountry).click();
		
		webDriver.findElement(txtOther).sendKeys("other");
		webDriver.findElement(txtPhone).sendKeys("1234567890");
		webDriver.findElement(txtPhoneMobile).sendKeys("1234567899");
		webDriver.findElement(txtAlias).sendKeys("Alias");
		
	}
	public MyAccountPageModel clickRegister() {
		webDriver.findElement(btnRegister).click();
		return new MyAccountPageModel(webDriver);
	}

	public CreateAccountPageModel(WebDriver webDriver) {
		super(webDriver);
	}
}