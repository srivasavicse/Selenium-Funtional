package com.springernature;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Hdfc_Alert_Example {
	
	ChromeDriver driver;
	@Test
	public void hdfc_Login() throws InterruptedException {
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='login_page']")));
		// driver.findElement(By.name("fldLoginUserId")).sendKeys("1000");
		driver.findElement(By.cssSelector(".btn.btn-primary.login-btn")).click();
		Thread.sleep(5000);
		String actualAlertText=driver.switchTo().alert().getText();
		String ExpectedAlertText="Customer ID  cannot be left blank.";
		Assert.assertEquals(actualAlertText, ExpectedAlertText);
		driver.switchTo().alert().accept();
		
		
		
	
	
		
}
	
	
	
	
	@BeforeTest
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}


}
