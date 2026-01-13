package com.amazon.pages;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;

	@FindBy(name = "username")
	private WebElement usernameField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String user, String pass) throws InterruptedException {
		usernameField.sendKeys(user);
		Thread.sleep(2000);
		passwordField.sendKeys(pass);
		Thread.sleep(2000);

		loginButton.click();
	}

	public void navigateToAdminJobDetails() {
		// Click Admin section
		driver.findElement(By.xpath("//span[normalize-space()='Admin']")).click();
		// Click Job > Job Titles
		driver.findElement(By.xpath("//span[normalize-space()='Job']")).click();

	}

	public boolean verifyJobDropDownList() {
		Set<String> set1 = new HashSet<>(
				Arrays.asList("Job Titles", "Pay Grades", "Employment Status", "Job Categories", "Work Shifts","dsasf"));
		Set<String> set2 = new HashSet<>();
		// Check for a unique element on Job Details page
		try {
			List<WebElement> list = driver.findElements(By.xpath("//a[@class='oxd-topbar-body-nav-tab-link']"));

			for (WebElement ele : list) {
				System.out.println(ele.getText());
				set2.add(ele.getText());;
			}
			boolean value=set1.equals(set2);
         System.out.println("Equality:"+value);
         return value;
		} catch (NoSuchElementException e) {
			 return false;
		}
	}
}
