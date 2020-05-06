package com.pop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount extends Base {
	private By headingCreateAccount = By.xpath("//h1[contains(text(),\"Create an account\")]");

	private By radioGender = By.xpath("//*[@id=\"id_gender1\"]");
	private By txtFirstName = By.xpath("//*[@id=\"customer_firstname\"]");
	private By txtLastName = By.xpath("//*[@id=\"customer_lastname\"]");
//	private By txtEmail = By.xpath("//*[@id=\"email\"]");
	private By txtPassWord = By.xpath("//*[@id=\"passwd\"]");
	private By selectDays = By.xpath("//*[@id=\"days\"]");
	private By optionDay = By.xpath("//*[@id=\"days\"]/option[13]");
	private By selectMonths = By.xpath("//*[@id=\"months\"]");
	private By optionMonth = By.xpath("//*[@id=\"months\"]/option[2]");
	private By selectYears = By.xpath("//*[@id=\"years\"]");
	private By optionYear = By.xpath("//*[@id=\"years\"]/option[25]");
	private By txtAddressFirtsName = By.xpath("//*[@id=\"firstname\"]");
	private By txtAddressLastName = By.xpath("//*[@id=\"lastname\"]");
	private By txtCompany = By.xpath("//*[@id=\"company\"]");
	private By txtAddress1 = By.xpath("//*[@id=\"address1\"]");
	private By txtAddress2 = By.xpath("//*[@id=\"address2\"]");
	private By txtCity = By.xpath("//*[@id=\"city\"]");
	private By selectStates = By.xpath("//*[@id=\"id_state\"]");
	private By optionState = By.xpath("//*[@id=\"id_state\"]/option[2]");
	private By txtPostCode = By.xpath("//*[@id=\"postcode\"]");
	private By selectCountrys = By.xpath("//*[@id=\"id_country\"]");
	private By optionCountry = By.xpath("//*[@id=\"id_country\"]/option[2]");
	private By txtOther = By.xpath("//*[@id=\"other\"]");
	private By txtPhone = By.xpath("//*[@id=\"phone\"]");
	private By txtPhoneMobile = By.xpath("//*[@id=\"phone_mobile\"]");
	private By txtAlias = By.xpath("//*[@id=\"alias\"]");
	private By btnRegister = By.xpath("//*[@id=\"submitAccount\"]/span");

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