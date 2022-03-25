package com.springernature;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForgetPassword {

	@Test
	public void forgetPassword() {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.id("btnSearchValues")).isDisplayed();
		driver.quit();

	}

}
