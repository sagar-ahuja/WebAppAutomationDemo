package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(), 'Naveen K')]")
	WebElement userLabel;
	
	@FindBy(xpath = "//td[contains(text(), 'Contacts')")
	WebElement contactsLabel;
	
	@FindBy(name = "title")
	WebElement titleElement;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "surname")
	WebElement lastName;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type = 'submit' and @value = 'Save']")
	WebElement saveBtn;
	
	//@FindBy(xpath = "//a[contains(text(), 'Alex Hales')]//parent::td//preceding-sibling::td//input")
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyLoggedInUser() {
		
		return userLabel.isDisplayed();
	}
	
	public void selectCheckBox(String text) {
		WebElement chkboxSelection = driver.findElement(By.xpath("//a[contains(text(), '"+text+"')]//parent::td//preceding-sibling::td//input"));
		chkboxSelection.click();
	}
	
	public void createNewContacts(String title, String fName, String lName, String comp) {
		Select sel = new Select(titleElement);
		sel.selectByVisibleText(title);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comp);
		
		saveBtn.click();
		
	}

}
