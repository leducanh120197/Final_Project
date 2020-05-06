package com.pop.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pop.pages.HomePage;
import com.pop.pages.LoginAndSinup;
import com.pop.pages.CreateAccount;
import com.pop.pages.MyAccount;

public class CreateAccountTest {
	WebDriver driver;
	
	// testcase 1
	@Test (enabled = false)
	public void createAccountInvalid() {
		LoginAndSinup loginAndSignup = new HomePage(driver).clickSignin();
//		LoginAndSinup loginAndSignup = home.clickSignin();
		loginAndSignup = loginAndSignup.clickCreateAccountInvalid("abc123");
		if (loginAndSignup.errorInvalid()) {
			System.out.println("Invalid");
		}
		else {
			System.out.println("Not Invalid");
		}
		
	}
	
	// testcase 2
	@Test (enabled = true)
	public void createAccount() {
		LoginAndSinup loginAndSignup = new HomePage(driver).clickSignin();
//		LoginAndSinup loginAndSignup = home.clickSignin();
		CreateAccount createAcc = loginAndSignup.clickCreateAccount("anhld@gmail.com");
		createAcc.insertInformation();
		
		MyAccount myAcc = createAcc.clickRegister();
		if(myAcc.inMyAccountPage()) {
			System.out.println("Registed");
		}
		else {
			System.out.println("Can not register");
		}

	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", ".//Setup//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

	}

	@AfterMethod
	public void afterMethod() {
	}
}
