package com.follo.stepdefinition.sp2;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_05_Members;
import com.follo.module.method.F_06_Gate;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Follo_06_Gate extends Baseclass{


	@Given("User clicks gate button")
	public void user_clicks_gate_button() throws Throwable {

		try {


			if(IsElementDisplayed("GatesButton", GateLocators)){
				Print("Gates button is displayed");
				Click("GatesButton", GateLocators);
				Print("Gates button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Gates button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Gates button is not clicked");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Gates button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}


	}


	@And("User adds new gate")
	public void user_adds_new_gate() throws Throwable {

		try {

			F_06_Gate.AddGate();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}


	@Given("User edit a gate from the list")
	public void user_edit_a_gate_from_the_list() throws Throwable {
		
		try {

			F_06_Gate.EditGate();

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
		

	}
	
	@Given("User delete a gate from the list")
	public void user_delete_a_gate_from_the_list() throws Throwable {
		
		try {

			F_06_Gate.DeleteGate();

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	    
	}
	
	@Given("User select all gates")
	public void user_select_all_gates() throws Throwable {
		
		try {
			Wait(2000);
			if(IsElementDisplayed("SelectAll", GateLocators)){
				
				Click("SelectAll", GateLocators);


				Print("All gates are selected");
				ExtentCucumberAdapter.addTestStepLog("All gates are selected");
			}
		} catch (Exception e) {
			PrintError("All gates are not selected");
			ExtentCucumberAdapter.addTestStepLog("All gates are not selected");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}
	    
	}

	@When("User clicks remove button and click yes from the delete popup")
	public void user_clicks_remove_button_and_click_yes_from_the_delete_popup() throws Throwable {
	 
		try {
			if(IsElementDisplayed("RemoveButton", GateLocators)){
				Click("RemoveButton", GateLocators);
				Print("Remove button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Remove button is clicked");
				
				Wait(2000);
				Click("YesDelete", GateLocators);


				Print("Yes button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Yes button is clicked");
			}
		} catch (Exception e) {
			PrintError("Detele button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Detele button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}
	}

	@Then("All the gates should be deleted")
	public void all_the_gates_should_be_deleted() throws Throwable {
		
		try {

			if(IsElementDisplayed("NoRecordFound", GateLocators)) {
				Print("No record found is dispayed : All gates are deleted");
				ExtentCucumberAdapter.addTestStepLog("No record found is dispayed : All gates are deleted");
			}

		} 

		catch (Exception e) {

			PrintError("No record found is not dispayed : All gates are not deleted");
			ExtentCucumberAdapter.addTestStepLog("No record found is not dispayed : All gates are not deleted");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	   
	}
	
	@Given("User search and view the gates")
	public void user_search_and_view_the_gates() throws Throwable {
		
		try {

			F_06_Gate.SearchGates();

		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	  
	}

}
