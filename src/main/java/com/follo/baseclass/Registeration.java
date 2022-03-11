package com.follo.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Registeration extends Baseclass{



	
	public static void SelectPlan(String Plan) throws Throwable {


		
		switch (Plan) {
		case "Trial Plan":
			WebDriverWait wait = new WebDriverWait(driver, 120);
			WebElement Plan1 = 	wait.until(ExpectedConditions.elementToBeClickable(getElement("TrailPlan", RegisterPageLocators)));
			Plan1.click();
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					  .withTimeout(Duration.ofSeconds(120))
					  .pollingEvery(Duration.ofSeconds(5))
					  .ignoring(NoSuchElementException.class);

					
					WebElement foo = fluentWait.until(new Function<WebDriver, WebElement>() {
						  public WebElement apply(WebDriver driver) {
						    return driver.findElement(By.xpath("//button[normalize-space()='Close']"));
						  }
						});
		
			if(getElement("CloseButton", RegisterPageLocators).isDisplayed()) {
				System.out.println("Trial plan is selected");
				Click("CloseButton", RegisterPageLocators);
			}
			else {
				System.out.println("Trial plan is not selected successfully");
			}
			break;
			
		case "Project Plan":
			WebDriverWait wait2 = new WebDriverWait(driver, 120);
			WebElement Plan2 = 	wait2.until(ExpectedConditions.elementToBeClickable(getElement("ProjectPlan", RegisterPageLocators)));
			Plan2.click();
			if(getElement("PaymentPage", RegisterPageLocators).isDisplayed()) {
				
				SelectFromDropdown("MonthorYear", RegisterPageLocators, ReadDataFrom(22, 1, "Register"));
				
				if(ReadDataFrom(22, 1, "Register").equalsIgnoreCase("year")) {
					Thread.sleep(2000);
					ScrollDown();
					Click("ProjectPlan", RegisterPageLocators);
				}
				TypeDataInTheField("NameOnTheCard", RegisterPageLocators, ReadDataFrom(23, 1, "Register"));
				TypeDataInTheField("CardNumber", RegisterPageLocators, ReadDataFrom(24, 1, "Register"));
				SelectFromDropdown("ExpiryMonth", RegisterPageLocators, ReadDataFrom(25, 1, "Register"));
				SelectFromDropdown("ExpiryYear", RegisterPageLocators, ReadDataFrom(26, 1, "Register"));
				TypeDataInTheField("Cvc", RegisterPageLocators, ReadDataFrom(27, 1, "Register"));
				Thread.sleep(2000);
				SelectFromDropdown("PaymentCountry", RegisterPageLocators, ReadDataFrom(28, 1, "Register"));
				TypeDataInTheField("PaymentzipCode", RegisterPageLocators, ReadDataFrom(29, 1, "Register"));
				Click("Pay", RegisterPageLocators);
				
				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						  .withTimeout(Duration.ofSeconds(120))
						  .pollingEvery(Duration.ofSeconds(5))
						  .ignoring(NoSuchElementException.class);

						
						WebElement foo1 = fluentWait1.until(new Function<WebDriver, WebElement>() {
							  public WebElement apply(WebDriver driver) {
							    return driver.findElement(By.xpath("//button[normalize-space()='Close']"));
							  }
							});
						
			
				if(getElement("CloseButton", RegisterPageLocators).isDisplayed()) {
					System.out.println("Project plan is selected");
					Click("CloseButton", RegisterPageLocators);
				}
				else {
					System.out.println("Project plan is not selected successfully");
				}
				
				
			}
			break;
			
		case "Enterprise Plan":
			WebDriverWait wait3 = new WebDriverWait(driver, 120);
			WebElement Plan3 = 	wait3.until(ExpectedConditions.elementToBeClickable(getElement("EnterprisePlan", RegisterPageLocators)));
			Plan3.click();
			if(getElement("EnterprisePlanMessage", RegisterPageLocators).isDisplayed()) {
				System.out.println("Enterprise plan is selected");
			}
			else {
				System.out.println("Enterprise plan is not selected successfully");
			}

			break;
		default:
			System.err.println("Please select the correct plan");

		}
	}
	
	

}
