package com.springernature;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Navigate_Example {
	
	 ChromeDriver driver;
	@Test
	public void login_scenario() throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		String actualUrl=driver.getCurrentUrl();
		String ExpUrl="https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode";
		Assert.assertEquals(actualUrl, ExpUrl);
		driver.navigate().back();
		Thread.sleep(5000);
		String actualUrlBack=driver.getCurrentUrl();
		String ExpUrlBack="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
		Assert.assertEquals(actualUrlBack, ExpUrlBack);
		driver.navigate().forward();
		Thread.sleep(5000);
		String actualUrlForward=driver.getCurrentUrl();
		String ExpUrlForward="https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode";
		Assert.assertEquals(actualUrlForward, ExpUrlForward);
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Thread.sleep(5000);
		
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
