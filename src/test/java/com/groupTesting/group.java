package com.groupTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class group {
	ChromeDriver driver;
	@Test(groups= {"smoketest"})
	@Parameters({"uname","upass"})
  public void group_test(String uname,String upass) throws InterruptedException {
	  
	  

            driver.findElement(By.name("txtUsername")).sendKeys(uname);
			driver.findElement(By.name("txtPassword")).sendKeys(upass);
			driver.findElement(By.id("btnLogin")).click();
			// Verify that Dashboard page displayed
			String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
			String ExpElement = "Dashboard";
			Assert.assertEquals(ActElement, ExpElement);
			System.out.println(ActElement);

			driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Logout")).click();
			driver.findElement(By.id("logInPanelHeading")).isDisplayed();

		}

		@BeforeTest
		public void LaunchBrowser() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.navigate().to(url);
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			driver.manage().window().maximize();
		}

		@AfterTest
		public void CloseBrowser() {
			// driver.close();//Close will close only current chrome browser
			driver.quit();
		}



  }
  
  
