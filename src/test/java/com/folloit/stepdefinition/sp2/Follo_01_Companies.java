package com.folloit.stepdefinition.sp2;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.Companies;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_01_Companies extends Baseclass {


	@Given("User clicks Company button")
	public void user_clicks_company_button() throws Throwable {

		try {

			if(getElement("Companies", CompaniesLocators).isDisplayed()) {

				Click("Companies", CompaniesLocators);


				Print("Companies button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Companies button is clicked");			

			}
		} 

		catch (Exception e) {
			PrintError("Companies button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Companies button is not clicked");	
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@And("User clicks new company button")
	public void user_clicks_new_company_button() throws Throwable {

		try {

			Companies.AddDCompany();
			Print("New company button is clicked");
			ExtentCucumberAdapter.addTestStepLog("New company button is clicked");			

		
	} 

	catch (Exception e) {
		PrintError("New company button is not clicked");
		ExtentCucumberAdapter.addTestStepLog("New company button is not clicked");	
		ExtentCucumberAdapter.addTestStepLog(e.getMessage());

	}

}

@And("User fills the company details")
public void user_fills_the_company_details() {


}

@And("User clicks sumbit button")
public void user_clicks_sumbit_button() {


}

@Then("User should see the success message")
public void user_should_see_the_success_message() {


}



}
