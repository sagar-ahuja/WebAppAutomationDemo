package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//a[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[@title = 'New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//td[@class = 'headertext']")
	WebElement usrNameHeaderText;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ContactsPage clickOnContactsPage() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsPage() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public void clickOnNewContact() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	

}
