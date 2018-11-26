package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtilities;

public class LoginPage extends TestBase{
	
	
	// Define Page Factory or Object Repository
	
	@FindBy(name = "username")
	WebElement uname;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	WebElement crmLogo;
	
	@FindBy(xpath = "//font[contains(text(), 'Sign Up')]")
	WebElement signUpLink;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions or Methods or Features
	
	public String validateTitleOfPage() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String _username, String _password) {
		uname.sendKeys(_username);
		pwd.sendKeys(_password);
		//loginBtn.click();
		 TestUtilities.clickElement(driver, loginBtn);
		
		return new HomePage();
	}
	
	public SignUpPage signUpClick() {
		TestUtilities.clickElement(driver, signUpLink);
		return new SignUpPage();
	}
	

}
