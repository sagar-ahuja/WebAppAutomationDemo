package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	@FindBy(name = "payment_plan_id")
	WebElement dropDown;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "surname")
	WebElement lastName;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "email_confirm")
	WebElement emailConfirmation;
	
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "passwordconfirm")
	WebElement passwordConfirmation;
	
	@FindBy(name = "agreeTerms")
	WebElement checkBox;
	
	@FindBy(name = "submitButton")
	WebElement submitBtn;
	
	
	// Initialize the page factory
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Methods
	public void selectDropDownValue(String _text) {
		Select drop = new Select(dropDown);
		drop.selectByVisibleText(_text);
	}
	
	public void enterYourName(String _fName, String _lName) {
		firstName.sendKeys(_fName);
		lastName.sendKeys(_lName);
	}
	
	public void enterYourEmail(String _mailText) {
		email.sendKeys(_mailText);
		emailConfirmation.sendKeys(_mailText);
	}
	
	public void enterUserName(String _uName) {
		username.sendKeys(_uName);
	}
	
	public void enterPassword(String _pwd) {
		password.sendKeys(_pwd);
		passwordConfirmation.sendKeys(_pwd);
	}
	
	public void agreeTermsAndSubmit() {
		checkBox.click();
		submitBtn.submit();
	}
	
	
	
	
	

}
