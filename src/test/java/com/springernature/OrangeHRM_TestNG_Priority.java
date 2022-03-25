package com.springernature;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_TestNG_Priority {
	ChromeDriver driver;

	@Test(priority = 2)
	public void first_Scenario() {
		System.out.println("first_Scenario in the class executing");
	}

	@Test(priority = 1)
	public void second_Scenario() {
		System.out.println("second_Scenario in the class executing");
	}

	@BeforeTest
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
