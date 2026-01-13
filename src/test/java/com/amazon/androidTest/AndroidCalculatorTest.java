package com.amazon.androidTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AndroidCalculatorTest {
	@Test
	public void testLogin() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setDeviceName("emulator-5554"); // or your real device name
		options.setAppPackage("com.miui.calculator");
		options.setAppActivity("com.miui.calculator.cal.CalculatorActivity");
		options.setAutomationName("UiAutomator2");

		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		
		WebElement element=driver.findElement(By.id("android:id/button1"));
		element.click();
		Thread.sleep(5000);
		/*
		 * WebElement element=driver.findElement(By.
		 * xpath("//android.widget.TextView[@text=\"Tap here to minimize calculator\"]")
		 * ); JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", element); Thread.sleep(5000);
		 */
		driver.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.miui.calculator:id/btn_6_s")).click();
		
		Thread.sleep(2000);
		// driver.context("NATIVE_APP");  


//		// Get result
		String result = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
		System.out.println("Result is: " + result);

		driver.quit();
	}
}
