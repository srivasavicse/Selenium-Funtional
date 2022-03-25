package com.springernature;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login_Using_Xpath {

	ChromeDriver driver;

	@BeforeTest
	public void PreCondition_LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void PostCondition_LaunchBrowser() {
		driver.quit();
	}

	@Test
	public void Login_Valid_Scenario_GC()  {

		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("admin123");
		// driver.findElement(By.xpath("//input[@name='Submit']")).click();
		// Using Css for Login button
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		
	}
//
//	@Test
//	public void Logout_Valid_Scenario_GC() throws InterruptedException {
//		driver.findElement(By.id("welcome")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.linkText("Logout")).click();
//		driver.findElement(By.name("Submit")).isDisplayed();
//	}

}