package com.follo.module.method;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.follo.baseclass.Baseclass;
import com.follo.excel.read.ReadFrom;


public class Registeration extends Baseclass {




	public static void SelectPlan(String Plan) throws Throwable {



		switch (Plan) {
		case "Trial Plan":

			WebElement TrialPlan =  WaitForTheElement("TrailPlan", RegisterPageLocators);

			TrialPlan.click();

			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);


			WebElement waits = fluentWait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath("//button[normalize-space()='Close']"));
				}
			});

			if(getElement("CloseButton", RegisterPageLocators).isDisplayed()) {
				Print("Trial plan is selected");
				Click("CloseButton", RegisterPageLocators);
			}
			else {
				Print("Trial plan is not selected successfully");
			}
			break;

		case "Project Plan":

			WebElement ProjectPlan =  WaitForTheElement("ProjectPlan", RegisterPageLocators);

			ProjectPlan.click();
			if(getElement("PaymentPage", RegisterPageLocators).isDisplayed()) {

				SelectFromDropdown("MonthorYear", RegisterPageLocators, ReadFrom.Excel(22, 1, "Register"));

				if(ReadFrom.Excel(22, 1, "Register").equalsIgnoreCase("year")) {
					Wait(2000);
					ScrollDown();
					Click("ProjectPlan", RegisterPageLocators);
					
				}
				TypeDataInTheField("NameOnTheCard", RegisterPageLocators, ReadFrom.Excel(23, 1, "Register"));
				TypeDataInTheField("CardNumber", RegisterPageLocators, ReadFrom.Excel(24, 1, "Register"));
				SelectFromDropdown("ExpiryMonth", RegisterPageLocators, ReadFrom.Excel(25, 1, "Register"));
				SelectFromDropdown("ExpiryYear", RegisterPageLocators, ReadFrom.Excel(26, 1, "Register"));
				TypeDataInTheField("Cvc", RegisterPageLocators, ReadFrom.Excel(27, 1, "Register"));
				Wait(2000);
				SelectFromDropdown("PaymentCountry", RegisterPageLocators, ReadFrom.Excel(28, 1, "Register"));
				TypeDataInTheField("PaymentzipCode", RegisterPageLocators, ReadFrom.Excel(29, 1, "Register"));
				Click("Pay", RegisterPageLocators);

				Wait<WebDriver> fluentWait1 = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(120))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class);


				WebElement fluentwaits = fluentWait1.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//button[normalize-space()='Close']"));
					}
				});


				if(getElement("CloseButton", RegisterPageLocators).isDisplayed()) {
					Print("Project plan is selected");
					Click("CloseButton", RegisterPageLocators);
				}
				else {
					Print("Project plan is not selected successfully");
				}


			}
			break;

		case "Enterprise Plan":
			
			WebElement EnterprisePlan =  WaitForTheElement("EnterprisePlan", RegisterPageLocators);


			EnterprisePlan.click();

			if(getElement("EnterprisePlanMessage", RegisterPageLocators).isDisplayed()) {
				Print("Enterprise plan is selected");
			}
			else {
				Print("Enterprise plan is not selected successfully");
			}

			break;
		default:
			PrintError("Please select the correct plan");

		}
	}



}
