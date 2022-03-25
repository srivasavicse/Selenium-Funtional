package com.springernature;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login {

	@Test
	public void Login_Valid_Scenario_GC() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		driver.quit();
	}

	@Test
	public void Login_Valid_Scenario_FF() {

		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.quit();
	}

	@Test
	public void Login_Valid_Scenario_SF() {

		WebDriverManager.safaridriver().setup();
		SafariDriver driver = new SafariDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.quit();
	}

}
