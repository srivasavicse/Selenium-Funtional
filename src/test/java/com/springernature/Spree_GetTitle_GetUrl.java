package com.springernature;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spree_GetTitle_GetUrl {

	ChromeDriver driver;

	@Test
	public void login_Scenario() throws InterruptedException {
		driver.findElement(By.id("account-button")).click();
		driver.findElement(By.linkText("LOGIN")).click();
		Thread.sleep(5000);
		String actualTitle = driver.getTitle();
		String actualUrl = driver.getCurrentUrl();
		
		String expTitle = "Login - Spree Demo Site";
		String expUrl = "https://demo.spreecommerce.org/login" ;
		
		Assert.assertEquals(actualTitle, expTitle);
		Assert.assertEquals(actualUrl, expUrl);
		
		String textOnLoginPage = driver.findElement(By.xpath("//h3[normalize-space()='Log in to continue']")).getText();
		String ExpectedText="LOG IN TO CONTINUE";
		Assert.assertEquals(textOnLoginPage, ExpectedText);
		
	}

	@BeforeTest
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.spreecommerce.org/");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}



	

}
