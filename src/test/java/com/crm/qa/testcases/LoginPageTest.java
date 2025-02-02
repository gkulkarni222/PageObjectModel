package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void crmTitleTest() {
		String title = loginPage.validateTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void crmLogoTest() {
		boolean b = loginPage.validateLogo();
		Assert.assertTrue(b);
	}

	@Test(priority = 3)
	public void validateLoginSuccessful() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("passwprd"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
