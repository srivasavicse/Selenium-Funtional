package com.springernature;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_PrePost_Conditions {

	ChromeDriver driver;

	@Before
	public void PreCondition_LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@After
	public void PostCondition_LaunchBrowser() {
		driver.quit();
	}

	@Test
	public void Login_Valid_Scenario_GC() {

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
	}

	@Test
	public void Logout_Valid_Scenario_GC() throws InterruptedException {
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.name("Submit")).isDisplayed();
	}

}