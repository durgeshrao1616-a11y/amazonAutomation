package com.amazon.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.amazon.driverUtil.DriverManager;

public class BaseTest {
	@BeforeTest
	public void setUp() {
		DriverManager.initDriver();
	}

	@AfterTest
	public void tearDown() {
		DriverManager.quitDriver();
	}
}
