package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtilities;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	String sheetname = "Contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intitialisation();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.switchTo().frame("mainpanel");
		contactsPage = homePage.clickOnContactsPage();
	}
	
	
	@Test (priority = 1)
	public void userIDTextTest() {
		Assert.assertTrue(contactsPage.verifyLoggedInUser());
	}
	
	@Test (priority = 2)
	public void checkBoxSelectionTest() {
		contactsPage.selectCheckBox("Alex Hales");
	}
	
	@DataProvider
	public Object[][] getExcelDataTest() {
		Object[][] data = TestUtilities.readDataFile(sheetname);
		return data;
	}
	
	
	@Test (priority = 3, dataProvider = "getExcelDataTest")
	public void createNewContactTest(String title, String firstName, String lastName, String company) {
		homePage.clickOnNewContact();
		contactsPage.createNewContacts(title, firstName, lastName, company);
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
