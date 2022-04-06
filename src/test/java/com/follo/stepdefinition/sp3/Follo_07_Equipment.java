package com.follo.stepdefinition.sp3;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_06_Gate;
import com.follo.module.method.F_07_Equipment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_07_Equipment extends Baseclass {
	
	
	
	@Given("User clicks equipment button")
	public void user_clicks_equipment_button() throws Throwable {
		
		try {


			if(IsElementDisplayed("EquipmentButton", EquipmentLocators)){
				Print("Equipment button is displayed");
				Click("EquipmentButton", EquipmentLocators);
				Print("Equipment button is displayed");
				ExtentCucumberAdapter.addTestStepLog("Equipment button is displayed");

			}
		} 
		catch (Exception e) {
			PrintError("Equipment button is not clicked");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Equipment button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	 
	}

	@Given("User adds new equipment")
	public void user_adds_new_equipment() throws Throwable {
		
		try {

			F_07_Equipment.AddEquipment();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}
	
	
	@Given("User edit a equipment from the list")
	public void user_edit_a_equipment_from_the_list() throws Throwable {
	 
		try {

			F_07_Equipment.EditEquipment();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
		
		
	}
	
	@Given("User filter the company based on equipment name")
	public void user_filter_the_company_based_on_equipment_name() throws Throwable {
	
		
		try {

			F_07_Equipment.FilterEquipment();
			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
		
	}
	
	@Given("User search and view the equipment")
	public void user_search_and_view_the_equipment() throws Throwable {
		
		try {

			F_07_Equipment.SearchEquipment();
			
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	 
	}
	
	
	@Given("User delete a equipment from the list")
	public void user_delete_a_equipment_from_the_list() throws Throwable {

		try {

			F_07_Equipment.DeleteEquipment();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}
	
	
	@Given("User selects all equipment")
	public void user_selects_all_equipment() throws Throwable {
		
		try {
			Wait(2000);
			if(IsElementDisplayed("SelectAll", EquipmentLocators)){
				
				Click("SelectAll", EquipmentLocators);


				Print("All equipments are selected");
				ExtentCucumberAdapter.addTestStepLog("All equipments are selected");
			}
		} catch (Exception e) {
			PrintError("All equipments are not selected");
			ExtentCucumberAdapter.addTestStepLog("All equipments are not selected");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}
	   
	}

	@And("User clicks remove button and click yes from the equipment popup")
	public void user_clicks_remove_button_and_click_yes_from_the_equipment_popup() throws Throwable {
		
		try {
			if(IsElementDisplayed("RemoveButton", EquipmentLocators)){
				Click("RemoveButton", EquipmentLocators);
				Print("Remove button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Remove button is clicked");
				
				Wait(2000);
				Click("YesDelete", EquipmentLocators);


				Print("Yes button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Yes button is clicked");
			}
		} catch (Exception e) {
			PrintError("Detele button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Detele button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}
	    
	}

	@Then("All the equipment should be deleted")
	public void all_the_equipment_should_be_deleted() throws Throwable {
		
		try {

			if(IsElementDisplayed("NoRecordFound", EquipmentLocators)) {
				Print("No record found is dispayed : All equipments are deleted");
				ExtentCucumberAdapter.addTestStepLog("No record found is dispayed : All equipments are deleted");
			}

		} 

		catch (Exception e) {

			PrintError("No record found is not dispayed : All equipments are not deleted");
			ExtentCucumberAdapter.addTestStepLog("No record found is not dispayed : All equipments are not deleted");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	    
	}
	
	
}
