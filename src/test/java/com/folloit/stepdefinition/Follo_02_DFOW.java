package com.folloit.stepdefinition;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.baseclass.DFOW;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_02_DFOW extends Baseclass {

	@Given("User clicks settings button")
	public void user_clicks_settings_button() throws Throwable {

		try {
			Thread.sleep(10000);
			Click("DeliveryCalendar", DFOWLocators);

			ClickPageDown();

			Click("Settings", DFOWLocators);
			System.out.println("Settings button is clicked");

		} catch (Exception e) {
			System.err.println("Settings button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Settings button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			System.out.println(e.getMessage());

		}


	}

	@And("User scrolls in the settings menu")
	public void user_scrolls_in_the_settings_menu() throws Throwable {


		try {

			ClickPageDown();

			System.out.println("Page down button is clicked");

		} catch (Exception e) {
			System.err.println("Page down button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Page down button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User clicks the DFOW from the menu")
	public void user_clicks_the_dfow_from_the_menu() throws Throwable {

		try {

			Click("DFOW", DFOWLocators);
			System.out.println("DFOW button is clicked");
			ClickPageDown();

		} catch (Exception e) {
			System.err.println("DFOW button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("DFOW button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Then("DFOW page should be displayed")
	public void dfow_page_should_be_displayed() throws Throwable {


		try {

			if(getElement("AddRow", DFOWLocators).isDisplayed()) {
				System.out.println("DFOW page is dispayed");
				ExtentCucumberAdapter.addTestStepLog("DFOW page is dispayed");
			}

		} 

		catch (Exception e) {

			System.err.println("DFOW page is not dispayed");
			ExtentCucumberAdapter.addTestStepLog("DFOW page is not dispayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}



	@Given("User clicks add row")
	public void user_clicks_add_row() throws Throwable {


		try {
			Thread.sleep(2000);
			//WaitForTheElement("AddRow", DFOWLocators);
			Click("AddRow", DFOWLocators);
			System.out.println("AddRow button is clicked");


		} catch (Exception e) {
			System.err.println("AddRow button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("AddRow button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User adds DFOW list")
	public void user_adds_dfow_list() throws Throwable {

		try {
			DFOW.AddSpecificationSection();
			DFOW.AddDFOW();



		}  catch (Exception e) {

		}

	}

	@And("User clicks the save button")
	public void user_clicks_the_save_button() throws Throwable {

		try {

			Click("SaveButton", DFOWLocators);
			System.out.println("Save button is clicked");
			ClickPageDown();

		} catch (Exception e) {
			System.err.println("Save button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Save button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Then("DFOW list should get added")
	public void dfow_list_should_get_added() throws Throwable {

		try {

			DFOW.WaitForSuccess();
			if(getElement("SuccessfullMessage", DFOWLocators).isDisplayed()) {
				System.out.println("DFOW list added");
				ExtentCucumberAdapter.addTestStepLog("DFOW list added");

			}
		} 
		catch (Exception e) {
			System.err.println("DFOW list not added");
			System.out.println(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("DFOW list not added");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}


	}

	@Given("User clicks import button")
	public void user_clicks_import_button() throws Throwable {


		try {

			Click("Import", DFOWLocators);
			System.out.println("Import button is clicked");

		} catch (Exception e) {
			System.err.println("Import button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Import button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User clicks browse files")
	public void user_clicks_browse_files() throws Throwable {


		try {
			DFOW.BrowseFiles();
			Click("BrowseFiles", DFOWLocators);
			System.out.println("Browse files button is clicked");

		} catch (Exception e) {
			System.err.println("Browse files button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Browse files button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			System.out.println(e.getMessage());
		}

	}

	@And("User selects file to upload")
	public void user_selects_file_to_upload() throws Throwable {


		try {

			DFOW.DFOWlist();
			Click("DoneButton", DFOWLocators);

			System.out.println("Excel is uploaded");

		} catch (Exception e) {
			System.err.println("Excel is not uploaded");
			ExtentCucumberAdapter.addTestStepLog("Excel is not uploaded");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User exports the DFOW list")
	public void user_exports_the_dfow_list() {


	}

}
