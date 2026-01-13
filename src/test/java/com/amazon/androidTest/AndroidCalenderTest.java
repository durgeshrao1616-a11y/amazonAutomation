package com.amazon.androidTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidCalenderTest {
	@Test
	public void testLogin() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName("emulator-5554"); // or your real device name
		options.setAppPackage("com.google.android.calendar");
		options.setAppActivity("com.android.calendar.LaunchActivity");
		options.setAutomationName("UiAutomator2");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		
		driver.findElement(By.id("com.google.android.calendar:id/floating_action_button")).click();
		
		Thread.sleep(5000);
		/*
		 * WebElement element=driver.findElement(By.
		 * xpath("//android.widget.TextView[@text=\"Tap here to minimize calculator\"]")
		 * ); JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", element); Thread.sleep(5000);
		 */
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Event button\"]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.google.android.calendar:id/title")).sendKeys("Meeting");
		
		Thread.sleep(2000);
		// driver.context("NATIVE_APP");  


      driver.findElement(By.id("com.google.android.calendar:id/save")).click();
	//	System.out.println("Result is: " + result);

		driver.quit();
	}
}
