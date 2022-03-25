package com.springernature;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class JS_Alert_Example {
	
	ChromeDriver driver;
	@Test(priority=1)
	public void jsAlert() throws InterruptedException {
		
	driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		
		driver.switchTo().alert().accept();
		
		String successMsg=driver.findElement(By.id("result")).getText();
	String expectMsg="You successfully clicked an alert";
	Assert.assertEquals(successMsg, expectMsg);
	System.out.println("pass");
	
	
		
}
	@Test(priority=2)
	public void jsConfirm() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		driver.switchTo().alert().dismiss();
		String successMsg=driver.findElement(By.id("result")).getText();
		String expectMsg="You clicked: Cancel";
		Assert.assertEquals(successMsg, expectMsg);
		System.out.println("pass");
			
			}
	@Test(priority=3)
	public void jsPrompt() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
			driver.switchTo().alert().sendKeys("selenium");
			driver.switchTo().alert().accept();
			String successMsgText=driver.findElement(By.id("result")).getText();
			String expectMsgText="You entered: selenium";
			Assert.assertEquals(successMsgText, expectMsgText);
			System.out.println("pass");
			
		
			}
	
	
	@BeforeTest
	public void lunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}


}
