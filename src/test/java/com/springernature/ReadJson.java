package com.springernature;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadJson {

	@Test
	public static void Flight_Login() throws IOException, ParseException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//Creating a JSON parser Object
		JSONParser jsonparser = new JSONParser();
		//Parsing the content of the JSON file
		JSONObject jsonobj = (JSONObject) jsonparser.parse(new FileReader(System.getProperty("user.dir")+"/src/test/java/com/resourceFile/ObjectRepository.json"));
		//Reading data from the JSON file
		String url=(String) jsonobj.get("URL");
		String uname=(String) jsonobj.get("iUserName");
		String upass=(String) jsonobj.get("iUserPass");
		String btnLogin=(String) jsonobj.get("bLogin");

		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id(uname)).sendKeys("Admin");
		driver.findElement(By.id(upass)).sendKeys("admin123");
		driver.findElement(By.id(btnLogin)).click();
		driver.quit();
	}
	
}
