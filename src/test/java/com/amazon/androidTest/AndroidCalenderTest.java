package com.amazon.androidTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.amazon.config.ConfigLoader;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidCalenderTest {
	@Test
	public void testLogin() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();
		AndroidDriver driver;
		ConfigLoader.load("qa");
		boolean remote = ConfigLoader.get("remote").equalsIgnoreCase("true");
		String BS_USERNAME = ConfigLoader.get("BS_USERNAME");
		String BS_ACCESS_KEY = System.getProperty("BS_ACCESS_KEY");
		if (!remote) {
			options.setPlatformName("Android");
			options.setDeviceName("emulator-5554");
			options.setAppPackage("com.google.android.calendar");
			options.setAppActivity("com.android.calendar.LaunchActivity");
			options.setAutomationName("UiAutomator2");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		} else {
			options.setPlatformName("android");
			options.setPlatformVersion("12.0");
			options.setDeviceName("Samsung Galaxy S22 Ultra");
			options.setAutomationName("UiAutomator2");
			options.setApp("bs://abscddcfcfcf"); // Upload app to BrowserStack and use its ID

			driver = new AndroidDriver(
					new URL("https://" + BS_USERNAME + ":" + BS_ACCESS_KEY + "@hub.browserstack.com/wd/hub"), options);

		}
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until( ExpectedConditions.elementToBeClickable(By.id(
		 * "com.google.android.calendar:id/floating_action_button"))) .click();
		 */

		// wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Event
		// button"))).click();

		driver.findElement(By.id("com.google.android.calendar:id/floating_action_button")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Event button\"]")).click();
		Thread.sleep(5000);

		driver.findElement(By.id("com.google.android.calendar:id/title")).sendKeys("Meeting");

		Thread.sleep(2000);
		// driver.context("NATIVE_APP");

		driver.findElement(By.id("com.google.android.calendar:id/save")).click();
		// System.out.println("Result is: " + result);

		driver.quit();
	}
}
