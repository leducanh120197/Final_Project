package com.pop.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAndSinup extends Base {
	
	public By txtEmailCreate = By.xpath("//*[@id=\"email_create\"]");
	public By btnCreateAccount  = By.id("SubmitCreate");
	public By errorRegistered = By.xpath("//*[@id=\"create_account_error\"]//li[contains(text(),\"registered\")];");
	public By errorInvalid = By.xpath("//*[@id=\"create_account_error\"]//li[contains(text(),\"Invalid\")]");
	public By txtEmail = By.id("email");
	public By txtPassWord = By.id("passwd");
	public By btnSignIn = By.id("SubmitLogin");
	
//	public By txtPassWord = By.xpath("//*[@id=\"passwd\"]");
//	public By btnSignIn = By.xpath("//*[@id=\"SubmitLogin\"]/span");
	
	
	public LoginAndSinup(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginAndSinup clickCreateAccountInvalid(String email) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(txtEmailCreate).sendKeys(email);
		driver.findElement(btnCreateAccount).click();
		return new LoginAndSinup(driver);
	}
	
	public CreateAccount clickCreateAccount(String email) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(txtEmailCreate).sendKeys(email);
		driver.findElement(btnCreateAccount).click();
		return new CreateAccount(driver);
	}
	
	public boolean errorInvalid() {
		if(isElementPresent(errorInvalid)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
