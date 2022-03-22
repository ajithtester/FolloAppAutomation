package com.folloit.stepdefinition.sp1;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_02_DFOW extends Baseclass {

	@Given("User clicks settings button")
	public void user_clicks_settings_button() throws Throwable {

		try {
			Wait(10000);
			if(getElement("DeliveryCalendar", DFOWLocators).isDisplayed()) {
				Click("DeliveryCalendar", DFOWLocators);

				ClickPageDown();

				Click("Settings", DFOWLocators);
				Print("Settings button is clicked");
			}
		} catch (Exception e) {
			PrintError("Settings button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Settings button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			Print(e.getMessage());

		}


	}

	@And("User scrolls in the settings menu")
	public void user_scrolls_in_the_settings_menu() throws Throwable {


		try {

			ClickPageDown();

			Print("Page down button is clicked in keyboard");

		} catch (Exception e) {
			PrintError("Page down button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Page down button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User clicks the DFOW from the menu")
	public void user_clicks_the_dfow_from_the_menu() throws Throwable {

		try {
			if(getElement("DFOW", DFOWLocators).isDisplayed()) {
				Click("DFOW", DFOWLocators);
				Print("DFOW button is clicked");
				ClickPageDown();
			}
		} catch (Exception e) {
			PrintError("DFOW button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("DFOW button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Then("DFOW page should be displayed")
	public void dfow_page_should_be_displayed() throws Throwable {


		try {

			if(getElement("AddRow", DFOWLocators).isDisplayed()) {
				Print("DFOW page is dispayed");
				ExtentCucumberAdapter.addTestStepLog("DFOW page is dispayed");
			}

		} 

		catch (Exception e) {

			PrintError("DFOW page is not dispayed");
			ExtentCucumberAdapter.addTestStepLog("DFOW page is not dispayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}



	@Given("User clicks add row")
	public void user_clicks_add_row() throws Throwable {


		try {
			Wait(2000);
			WaitForTheElement("AddRow", DFOWLocators);
			Click("AddRow", DFOWLocators);
			Print("AddRow button is clicked");


		} catch (Exception e) {
			PrintError("AddRow button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("AddRow button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User adds DFOW list")
	public void user_adds_dfow_list() throws Throwable {

		try {


			DFOW.AddDFOW();

			Print("User typed the DFOW list in the rows");
			ExtentCucumberAdapter.addTestStepLog("User typed the DFOW list in the rows");


		}  catch (Exception e) {

			PrintError("User is not able to type the DFOW list in the rows");
			ExtentCucumberAdapter.addTestStepLog("User is not able to type the DFOW list in the rows");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			Print(e.getMessage());
		}

	}

	@And("User clicks the save button")
	public void user_clicks_the_save_button() throws Throwable {

		try {
			if(getElement("AddRow", DFOWLocators).isDisplayed()) {
			String cc= 	GetText("SaveButton", DFOWLocators);
			Print(cc);
				Click("SaveButton", DFOWLocators);
				Print("Save button is clicked");
				ClickPageDown();
			}
		} catch (Exception e) {
			PrintError("Save button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Save button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Then("DFOW list should get added")
	public void dfow_list_should_get_added() throws Throwable {

		try {

			DFOW.AddSuccessfullMessage();
			if(getElement("SuccessfullMessage", DFOWLocators).isDisplayed()) {
				Click("SuccessfullMessage", DFOWLocators);
				Print("DFOW list added");
				ExtentCucumberAdapter.addTestStepLog("DFOW list added");

			}
		} 
		catch (Exception e) {
			PrintError("DFOW list not added");
			Print(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("DFOW list not added");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}


	}

	@Given("User enters the dfow value in the search bar")
	public void user_enters_the_dfow_value_in_the_search_bar() throws Throwable {

		try {
			DFOW.SearchDFOW();

		} catch (Exception e) {
			PrintError("search not happened");
			ExtentCucumberAdapter.addTestStepLog("Search not happened");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			Print(e.getMessage());
		}
	}



	@Given("User looks for the export button")
	public void user_looks_for_the_export_button()  throws Throwable {

		try {


			Waitfortheelement("Export", DFOWLocators);
			if(getElement("Export", DFOWLocators).isDisplayed()){
				Print("Export button is displayed : DFOW list is available");
				ExtentCucumberAdapter.addTestStepLog("Export button is displayed : DFOW list is available");

			}
		} 
		catch (Exception e) {
			Print("Export button is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Export button is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}


	}

	@Then("User clicks the export button to export the file")
	public void user_clicks_the_export_button_to_export_the_file() throws Throwable {
		try {
			Wait(2000);
			if(getElement("Export", DFOWLocators).isDisplayed()){
				Click("Export", DFOWLocators);


				Print("Export button is clicked : File is exported");
				ExtentCucumberAdapter.addTestStepLog("Export button is clicked : File is exported");
			}
		} catch (Exception e) {
			PrintError("Export button is not clicked : File is not exported");
			ExtentCucumberAdapter.addTestStepLog("Export button is not clicked : File is not exported");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}

	}

	@Given("User edits a DFOW from the list")
	public void user_edits_a_dfow_from_the_list() throws Throwable {

		try {
			DFOW.EditDFOW();
			Print("Edit values are entered");
		} 	catch (Exception e) {
			PrintError("Edit values are not entered");
			Print(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Edit values are not entered");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	@Then("User should get edit success popup")
	public void user_should_get_edit_success_popup() throws Throwable {


		try {

			DFOW.AddSuccessfullMessage();
			if(getElement("SuccessfullMessage", DFOWLocators).isDisplayed()) {
				Click("SuccessfullMessage", DFOWLocators);
				Print("DFOW list edited successfully");
				ExtentCucumberAdapter.addTestStepLog("DFOW list edited successfully");

			}
		} 
		catch (Exception e) {
			PrintError("DFOW list not edited successfully");
			Print(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("DFOW list not edited successfully");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}


	@Given("User deletes a DFOW from the list")
	public void user_deletes_a_dfow_from_the_list() throws Throwable {
		try {

			Wait(2000);
			DFOW.DeleteDFOW();
			Print("User selected the dfow to delete");

		} catch (Exception e) {
			PrintError("Not able to select the value to delete");
			ExtentCucumberAdapter.addTestStepLog("Not able to select the value to delete");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			Print(e.getMessage());

		}

	}

//	@Then("User should get delete success popup")
//	public void user_should_get_delete_success_popup() throws Throwable {
//
//
//		try {
//
//			DFOW.DeleteSuccessfullMessage();
//			if(getElement("DeleteDfowMessage", DFOWLocators).isDisplayed()) {
//				Click("DeleteDfowMessage", DFOWLocators);
//				Print("DFOW list deleted successfully");
//				ExtentCucumberAdapter.addTestStepLog("DFOW list deleted successfully");
//
//			}
//		} 
//		catch (Exception e) {
//			PrintError("DFOW list not deleted successfully");
//			Print(e.getMessage());
//			ExtentCucumberAdapter.addTestStepLog("DFOW list not deleted successfully");
//			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
//		}
//	}

	@Given("User selects all DFOW")
	public void user_selects_all_dfow() throws Throwable {


		try {
			Thread.sleep(2000);
			if(getElement("SelectAll", DFOWLocators).isDisplayed()){
				Click("SelectAll", DFOWLocators);


				Print("All DFOW are selected");
				ExtentCucumberAdapter.addTestStepLog("All DFOW are selected");
			}
		} catch (Exception e) {
			PrintError("All DFOW are not selected");
			ExtentCucumberAdapter.addTestStepLog("All DFOW are not selected");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}

	}

	@And("User clicks remove button and click yes")
	public void user_clicks_remove_button_and_click_yes()throws Throwable {


		try {
			if(getElement("RemoveDFOW", DFOWLocators).isDisplayed()){
				Click("RemoveDFOW", DFOWLocators);
				Thread.sleep(2000);
				Click("YesDelete", DFOWLocators);


				Print("Remove button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Remove button is clicked");
			}
		} catch (Exception e) {
			PrintError("Remove button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Remove button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}

	}

	@Then("All the DFOW in the list should be removed")
	public void all_the_dfow_in_the_list_should_be_removed() throws Throwable {


		try {

			if(getElement("NoRecordFound", DFOWLocators).isDisplayed()) {
				Print("No record found is dispayed : All DFOW are deleted");
				ExtentCucumberAdapter.addTestStepLog("No record found is dispayed : All DFOW are deleted");
			}

		} 

		catch (Exception e) {

			PrintError("No record found is not dispayed : All DFOW are not deleted");
			ExtentCucumberAdapter.addTestStepLog("No record found is not dispayed : All DFOW are not deleted");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}




	@Given("User clicks import button")
	public void user_clicks_import_button() throws Throwable {


		try {
			if(getElement("Import", DFOWLocators).isDisplayed()) {
				Click("Import", DFOWLocators);
				Print("Import button is clicked");
			}
		} catch (Exception e) {
			PrintError("Import button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Import button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User clicks browse files")
	public void user_clicks_browse_files() throws Throwable {


		try {
			DFOW.BrowseFiles();
			if(getElement("BrowseFiles", DFOWLocators).isDisplayed()) {
				Click("BrowseFiles", DFOWLocators);
				Print("Browse files button is clicked");
			}
		} catch (Exception e) {
			PrintError("Browse files button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Browse files button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			Print(e.getMessage());
		}

	}

	@And("User selects file to upload")
	public void user_selects_file_to_upload() throws Throwable {


		try {

			DFOW.DfowBulkUpload();
			Waitfortheelement("ExcelDelete", DFOWLocators);

			if(getElement("ExcelDelete", DFOWLocators).isDisplayed()){
				Print("DFOW list excel file is selected from the system");
				ExtentCucumberAdapter.addTestStepLog("DFOW list excel file is selected from the system");
			}


		} catch (Exception e) {
			PrintError("DFOW list excel file is not selected from the system");
			ExtentCucumberAdapter.addTestStepLog("DFOW list excel file is not selected from the system");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User clicks the done button")
	public void user_clicks_the_done_button() throws Throwable {

		try {
			Wait(2000);
			if(getElement("DoneButton", DFOWLocators).isDisplayed()){
				Click("DoneButton", DFOWLocators);
				Print("Done button is clicked");
				ClickPageDown();
			}
		} catch (Exception e) {
			PrintError("Done button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Done button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Then("DFOW list from the excel should get added")
	public void dfow_list_from_the_excel_should_get_added() throws Throwable {


		try {

			DFOW.BulkSuccessfullMessage();

			if(getElement("SuccessfullMessage2", DFOWLocators).isDisplayed()){
				Print("DFOW list added");
				ExtentCucumberAdapter.addTestStepLog("DFOW list added");

			}
		} 
		catch (Exception e) {
			PrintError("DFOW list not added");
			Print(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("DFOW list not added");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}



}
