package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		contactsPage =new ContactsPage();
		loginPage =new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() throws InterruptedException {
		Thread.sleep(1000);
		//testUtil.switchToFrame();
	Boolean ContactsTitle=contactsPage.verifyContactsPage();
		Assert.assertTrue(ContactsTitle, "contacts not present");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactByName("test test2");
		
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactByName("test test2");
		contactsPage.selectContactByName("User Automation");
		
	}
	
	
	
	@Test
	public void validateNewContact() {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
