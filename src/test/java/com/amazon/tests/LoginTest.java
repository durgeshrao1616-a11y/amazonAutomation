package com.amazon.tests;

import org.testng.annotations.Test;

import com.amazon.base.BaseTest;
import com.amazon.driverUtil.DriverManager;
import com.amazon.pages.LoginPage;
import com.amazon.utils.TestDataProvider;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class LoginTest extends BaseTest {
	LoginPage loginPage;

	@Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class, enabled = false)
	public void testLogin(String username, String password) throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.login(username, password);
		org.testng.Assert.assertTrue(DriverManager.getDriver().getTitle().contains("OrangeHRM"));
	}

	@Test(dependsOnMethods = "testLogin", dataProvider = "loginData", dataProviderClass = TestDataProvider.class, enabled = false)
	public void testAdminJobDetails(String username, String password) {
		loginPage.navigateToAdminJobDetails();
		boolean value = loginPage.verifyJobDropDownList();
		org.testng.Assert.assertTrue(value);
	}

	@Test
	@Description("Verify addition functionality")
	public void testAddition() {
		stepAdd(2, 3);
	}

	@Step("Adding {a} and {b}")
	public void stepAdd(int a, int b) {
		assert (a + b) == 5;
	}
}
