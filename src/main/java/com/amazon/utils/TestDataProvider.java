package com.amazon.utils;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	@DataProvider(name = "loginData")
	public Object[][] loginData() throws Exception {
		ExcelUtils excel = new ExcelUtils(
				"C:\\Users\\durge\\eclipse-workspace\\amazonAutomation\\src\\test\\resources\\testdata.xlsx");
		return excel.getSheetData("Login");
	}
}
