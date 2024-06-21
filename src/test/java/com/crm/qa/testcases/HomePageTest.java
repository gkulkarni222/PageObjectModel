package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	// test cases should be independent ---
	// before every testcase,lauch the browser and login
	// execute testcases -- close it

	@BeforeMethod
	public void setup() {
		initialization();
		loginPage = new LoginPage();
		testUtil=new TestUtil();
		contactsPage =new ContactsPage();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Test(priority = 1)
	public void validateHomePageTitleTest() throws InterruptedException {
		Thread.sleep(2000);
		String homePageTitle = homepage.verifyHomepageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Homepage title not matched");
	}

	@Test(priority = 2)
	public void validateUserNamePresent() throws InterruptedException {
		Thread.sleep(2000);
		testUtil.switchToFrame();
		boolean b = homepage.VerifyUser();
		Assert.assertTrue(b, "user is not logged in");
	}

	@Test(priority = 3)
	public void validateContacts() {
		testUtil.switchToFrame();
		contactsPage = homepage.clickOnContactsLink();

	}

	@Test(priority = 4)
	public void validateDeals() {
		testUtil.switchToFrame();
		dealsPage = homepage.clickDealsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
