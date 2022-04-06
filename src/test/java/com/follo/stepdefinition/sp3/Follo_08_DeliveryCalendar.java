package com.follo.stepdefinition.sp3;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;

import io.cucumber.java.en.Given;

public class Follo_08_DeliveryCalendar extends Baseclass {
	
	@Given("User clicks delivery calendar button")
	public void user_clicks_delivery_calendar_button() throws Throwable {
		
		try {


			Click("DeliveryCalendar", DFOWLocators);
			
			ClickPageUp();
			
			if(IsElementDisplayed("DeliveryCalendar", DeliveryCalendarLocators)){
				
				Click("EquipmentButton", DeliveryCalendarLocators);
				Print("Delivery calendar button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Delivery calendar button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Delivery calendar button is not clicked");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Delivery calendar button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	   
	}

}
