package com.pop.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAndSinupPageModel extends BaseModel {
	
	public By txtEmailCreate = By.xpath("//*[@id=\"email_create\"]");
	public By btnCreateAccount  = By.id("SubmitCreate");
	public By errorRegistered = By.xpath("//*[@id=\"create_account_error\"]//li[contains(text(),\"registered\")];");
	public By errorInvalid = By.xpath("//*[@id=\"create_account_error\"]//li[contains(text(),\"Invalid\")]");
	public By txtEmail = By.id("email");
	public By txtPassWord = By.id("passwd");
	public By btnSignIn = By.id("SubmitLogin");
	
//	public By txtPassWord = By.xpath("//*[@id=\"passwd\"]");
//	public By btnSignIn = By.xpath("//*[@id=\"SubmitLogin\"]/span");
	
	
	public LoginAndSinupPageModel(WebDriver webDriver) {
		super(webDriver);
	}
	
	public LoginAndSinupPageModel clickCreateAccountInvalid(String email) {
		webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		webDriver.findElement(txtEmailCreate).sendKeys(email);
		webDriver.findElement(btnCreateAccount).click();
		return new LoginAndSinupPageModel(webDriver);
	}
	
	public CreateAccountPageModel clickCreateAccount(String email) {
		webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		webDriver.findElement(txtEmailCreate).sendKeys(email);
		webDriver.findElement(btnCreateAccount).click();
		return new CreateAccountPageModel(webDriver);
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
