package com.crm.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase{
	LoginPage loginPage;
	SignUpPage signUpPage;
	
	public SignUpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intitialisation();
		loginPage = new LoginPage();
		signUpPage = loginPage.signUpClick();
	}
	
	@Test(priority = 1)
	public void enterDetailsTest() {
		signUpPage.selectDropDownValue(prop.getProperty("dropdownselection"));
		signUpPage.enterYourName(prop.getProperty("firstname"), prop.getProperty("lastname"));
		signUpPage.enterYourEmail(prop.getProperty("email"));
		signUpPage.enterUserName(prop.getProperty("username"));
		signUpPage.enterPassword(prop.getProperty("password"));
		signUpPage.agreeTermsAndSubmit();
		
	}
		
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}

}
