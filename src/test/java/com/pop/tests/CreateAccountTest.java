package com.pop.tests;

import org.testng.annotations.Test;

import com.pop.pages.HomePageModel;
import com.pop.pages.LoginAndSinupPageModel;
import com.pop.pages.CreateAccountPageModel;
import com.pop.pages.MyAccountPageModel;

public class CreateAccountTest extends BaseTest{
	// testcase 1
	@Test
	public void createAccountInvalid() {
		LoginAndSinupPageModel loginAndSignup = new HomePageModel(webDriver).clickSignin();
//		LoginAndSinup loginAndSignup = home.clickSignin();
		loginAndSignup = loginAndSignup.clickCreateAccountInvalid("abc123");
		if (loginAndSignup.errorInvalid()) {
			System.out.println("Invalid");
		} else {
			System.out.println("Not Invalid");
		}

	}

	// testcase 2
	@Test
	public void createAccount() {
		LoginAndSinupPageModel loginAndSignup = new HomePageModel(webDriver).clickSignin();
//		LoginAndSinup loginAndSignup = home.clickSignin();
		CreateAccountPageModel createAcc = loginAndSignup.clickCreateAccount("anhld@gmail.com");
		createAcc.insertInformation();

		MyAccountPageModel myAcc = createAcc.clickRegister();
		if (myAcc.isMyAccountPage()) {
			System.out.println("Registed");
		} else {
			System.out.println("Can not register");
		}

	}

//	@BeforeMethod
//	public void beforeMethod() {
//		System.setProperty("webdriver.chrome.driver", ".//webdriver//chromedriver.exe");
//		webDriver = new ChromeDriver();
//		webDriver.get("http://automationpractice.com/index.php");
//
//	}
//
//	@AfterMethod
//	public void afterMethod() {
//	}
}
