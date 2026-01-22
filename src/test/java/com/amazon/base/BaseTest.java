package com.amazon.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.amazon.config.ConfigLoader;
import com.amazon.driverUtil.DriverManager;

public class BaseTest {
	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		ConfigLoader.load(System.getProperty("env", "qa")); // loads config.qa.properties
		DriverManager.initDriver();
		driver = DriverManager.getDriver();
	}

	@AfterClass
	public void tearDown() {
		DriverManager.quitDriver();
	}

}
