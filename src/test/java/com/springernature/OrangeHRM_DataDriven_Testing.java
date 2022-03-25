package com.springernature;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_DataDriven_Testing {
	
	ChromeDriver driver;

	@Test(dataProvider="Login", dataProviderClass=Application_TestData.class)
	public void Login_Valid_Scenario(String uname,String upass, String expUserName) throws InterruptedException {

		driver.findElement(By.name("txtUsername")).sendKeys(uname);
		driver.findElement(By.name("txtPassword")).sendKeys(upass);
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.linkText("Dashboard")).isDisplayed();
		String userName = driver.findElement(By.partialLinkText("Welcome")).getText();
		//System.out.println("userName:"+userName+"    expUserName:"+expUserName);
		Assert.assertTrue(userName.contains(expUserName));
		driver.findElement(By.partialLinkText("Welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		driver.findElement(By.id("btnLogin")).isDisplayed();
	}

	@BeforeTest
	public void LaunchBrowser() {
		// Download chromedriver at run time
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
