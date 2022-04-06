package com.follo.stepdefinition.sp2;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_04_Companies;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_04_Companies extends Baseclass {


	@Given("User clicks Company button")
	public void user_clicks_company_button() throws Throwable {

		try {

			if(IsElementDisplayed("Companies", CompaniesLocators)) {

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

	@And("User add new company")
	public void user_add_new_company() throws Throwable {

		try {

			F_04_Companies.AddDCompany();
		} 

		catch (Exception e) {
	
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User search and view the company")
	public void user_search_and_view_the_company() throws Throwable {

		try {

			F_04_Companies.SearchCompany();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}


	@Given("User search and filter the company")
	public void user_search_and_filter_the_company() throws Throwable {


		try {

			F_04_Companies.FilterCompany();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}


	@Given("User edits a Company from the list")
	public void user_edits_a_company_from_the_list() throws Throwable {


		try {

			F_04_Companies.EditCompany();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Given("User deletes a Company from the list")
	public void user_deletes_a_company_from_the_list() throws Throwable {

		try {

			F_04_Companies.DeleteCompany();

		} 

		catch (Exception e) {
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			PrintError(e.getMessage());
		}

	}

	@Given("User selects all Companies")
	public void user_selects_all_companies() throws Throwable {

		try {
			Wait(2000);
			if(IsElementDisplayed("SelectAll", CompaniesLocators)){
				Click("SelectAll", CompaniesLocators);


				Print("All companies are selected");
				ExtentCucumberAdapter.addTestStepLog("All companies are selected");
			}
		} catch (Exception e) {
			PrintError("All companies are not selected");
			ExtentCucumberAdapter.addTestStepLog("All companies are not selected");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			PrintError(e.getMessage());

		}

	}

		@And("User clicks remove button and click yes in company delete popup")
		public void user_clicks_remove_button_and_click_yes_in_company_delete_popup() throws Throwable {
	
			try {
				if(IsElementDisplayed("RemoveButton", CompaniesLocators)){
					Click("RemoveButton", CompaniesLocators);
					Wait(2000);
					Click("YesDelete", CompaniesLocators);
	
	
					Print("Remove button is clicked");
					ExtentCucumberAdapter.addTestStepLog("Remove button is clicked");
				}
			} catch (Exception e) {
				PrintError("Remove button is not clicked");
				ExtentCucumberAdapter.addTestStepLog("Remove button is not clicked");
				ExtentCucumberAdapter.addTestStepLog(e.getMessage());
	
	
			}
	
		}


	@Then("All the Companies except parent company is deleted")
	public void all_the_companies_except_parent_company_is_deleted() throws Throwable {



		try {
			int size =	GetSize("CompanyList", CompaniesLocators);

			if(size<=1) {
				Print("All companies are deleted except parent company");
				ExtentCucumberAdapter.addTestStepLog("All companies are deleted except parent company");
			}
			else {
				System.err.println(size);
			}

		} 

		catch (Exception e) {

			PrintError("All companies are not deleted");
			ExtentCucumberAdapter.addTestStepLog("All companies are not deleted");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}



}
