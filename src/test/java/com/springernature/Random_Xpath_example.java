package com.springernature;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Random_Xpath_example {
	WebDriver driver;
	@Test(priority=0)
	  public void Add_User() throws InterruptedException
	  {
		  driver.findElement(By.linkText("Admin")).click();
		  driver.findElement(By.cssSelector(".toggle.tiptip")).isDisplayed();
		  driver.findElement(By.id("btnAdd")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("UserHeading")).isDisplayed();
		  Select userrole = new Select(driver.findElement(By.id("systemUser_userType")));
		  userrole.selectByVisibleText("Admin");
		  driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys("Fiona Grace");
		  //Random class will help to generate random number
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(1000);
		  driver.findElement(By.id("systemUser_userName")).sendKeys("Dixit"+randomInt);
		  driver.findElement(By.id("systemUser_password")).sendKeys("admin123");
		  driver.findElement(By.id("systemUser_confirmPassword")).sendKeys("admin123");
		  driver.findElement(By.id("btnSave")).click();
		  Thread.sleep(4000);
		  //Verify that user got added to Webtable or not
		  String ExpName = "Dixit"+randomInt;
		  String ActName = driver.findElement(By.xpath("//a[text()='" + ExpName + "']")).getText();
		  Assert.assertEquals(ActName, ExpName);
	  }
}
