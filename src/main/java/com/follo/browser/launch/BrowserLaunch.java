package com.follo.browser.launch;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.follo.baseclass.Baseclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLaunch extends Baseclass {

	public static void LaunchTheAppURL(String locator, String locatorfile ) throws Throwable {

		String Browser = PropertyFile("Browser", AppProperties);

		if(IsEqual(Browser, "Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			Print("Chrome browser is launched");

			PropertyFile(locator, locatorfile);
			driver.get(properties);
		} 
		
		else if(IsEqual(Browser, "Firefox")) { 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			Print("Firefox browser is launched");

			PropertyFile(locator, locatorfile);
			driver.get(properties);
		}


		else {
			Print("Please try browser : Chrome or Firefox ");
		}


	}

}
