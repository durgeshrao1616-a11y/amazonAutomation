package com.amazon.driverUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.amazon.utils.ConfigReader;

public class DriverManager {
	private static WebDriver driver;

	public static void initDriver() {
		String browser = ConfigReader.get("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless"); 
			driver = new FirefoxDriver(options);

		}
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigReader.get("implicitWait"))));
		driver.get(ConfigReader.get("baseUrl"));
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		if (driver != null)
			driver.quit();
	}
}
