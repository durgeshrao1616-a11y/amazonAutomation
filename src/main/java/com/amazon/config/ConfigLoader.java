package com.amazon.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ConfigLoader {
	private static Properties properties = new Properties();

	public static void load(String env) {
		try {
			String path = "src/test/resources/config/config." + env + ".properties";
			FileInputStream fis = new FileInputStream(path);
			if (fis == null) {
				throw new RuntimeException("Config file not found: " + path);
			}

			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static WebDriver driver;

	public static void initDriver() {
		String browser = ConfigLoader.get("browser");
		System.out.println("Browser selected: " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--headless");
			driver = new FirefoxDriver(options);

		}
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigLoader.get("implicitWait"))));
		driver.get(ConfigLoader.get("baseUrl"));
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		if (driver != null)
			driver.quit();
	}

	public static String get(String key) {
		return properties.getProperty(key);
	}
}
