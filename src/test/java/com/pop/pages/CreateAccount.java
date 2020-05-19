package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount extends Base {
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
		driver.findElement(radioGender).click();
		driver.findElement(txtFirstName).sendKeys("Duc Anh");
		driver.findElement(txtLastName).sendKeys("Le");
//		driver.findElement(txtEmail).sendKeys();
		driver.findElement(txtPassWord).sendKeys("123456");
		
		driver.findElement(selectDays).click();
		driver.findElement(optionDay).click();
		driver.findElement(selectMonths).click();
		driver.findElement(optionMonth).click();
		driver.findElement(selectYears).click();
		driver.findElement(optionYear).click();
		
		driver.findElement(txtAddressFirtsName).sendKeys("Duc Anh");
		driver.findElement(txtAddressLastName).sendKeys("Le");
		driver.findElement(txtCompany).sendKeys("LQA");
		driver.findElement(txtAddress1).sendKeys("Dan Nhiem");
		driver.findElement(txtAddress2).sendKeys("Dan");
		driver.findElement(txtCity).sendKeys("Ha Noi");
		
		driver.findElement(selectStates).click();
		driver.findElement(optionState).click();
		
		driver.findElement(txtPostCode).sendKeys("10000");
		
		driver.findElement(selectCountrys).click();
		driver.findElement(optionCountry).click();
		
		driver.findElement(txtOther).sendKeys("other");
		driver.findElement(txtPhone).sendKeys("1234567890");
		driver.findElement(txtPhoneMobile).sendKeys("1234567899");
		driver.findElement(txtAlias).sendKeys("Alias");
		
	}
	public MyAccount clickRegister() {
		driver.findElement(btnRegister).click();
		return new MyAccount(driver);
	}

	public CreateAccount(WebDriver driver) {
		this.driver = driver;
	}
}