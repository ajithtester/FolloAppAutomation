package com.folloit.stepdefinition.sp1;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.*;
import com.follo.excel.read.ReadFrom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AFollo_Register extends Baseclass {





	@Given("User launching the app url")
	public void user_launching_the_app_url() throws Throwable {


		try {

			LaunchTheDriver("Chrome", "URL", AppProperties);

			String Title =	PageTitle();		
			if(Title.equalsIgnoreCase("Follo")) {

				Print("Page title is : " + Title );
				ExtentCucumberAdapter.addTestStepLog("Page title is : " + Title );

				Print("Entered URL is : " + PropertyFile("URL", AppProperties) + ": Application launched successfully");
				ExtentCucumberAdapter.addTestStepLog("Entered URL is : " + PropertyFile("URL", AppProperties) + ": Application launched successfully");
			}
			else {
				PrintError("Get-Started button is not displayed : Application failed to launch successfully");
				ExtentCucumberAdapter.addTestStepLog("Get-Started button is not displayed : Application failed to launch successfully");
			}

		} 

		catch (Exception e) {
			PrintError("Application failed to launch successfully");
			ExtentCucumberAdapter.addTestStepLog("Application failed to launch successfully");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User clicks the get-started button")
	public void user_clicks_the_get_started_button() throws Throwable {

		try {
			if(getElement("GetStarted", RegisterPageLocators).isDisplayed()) {
				Click("GetStarted", RegisterPageLocators);
				Print("Get Started button is clicked");
			}
		} catch (Exception e) {
			PrintError("Get Started button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Get Started button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Then("User should see welcome popup")
	public void user_should_see_welcome_popup() throws Throwable {


		try {

			if(getElement("EmailId", RegisterPageLocators).isDisplayed()) {
				Print("Welcome popup opened");
				ExtentCucumberAdapter.addTestStepLog("Welcome popup opened");
			}
		} 
		catch (Exception e) {
			PrintError("Welcome popup not opened");
			ExtentCucumberAdapter.addTestStepLog("Welcome popup not opened");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	@Given("User enter mail Id and Phone number")
	public void user_enter_mail_id_and_phone_number() throws Throwable {

		try {

			TypeDataInTheField("EmailId", RegisterPageLocators, ReadFrom.Excel(0, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Register"));
			Print("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Register"));

			SelectFromDropdown("PhoneCode", RegisterPageLocators, ReadFrom.Excel(1, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Phonecode is selected as : " + ReadFrom.Excel(1, 1 , "Register"));
			Print("Phonecode is selected as : " + ReadFrom.Excel(1, 1 , "Register"));

			TypeDataInTheField("Mobile", RegisterPageLocators, ReadFrom.Excel(2, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Mobile number is entered as : " + ReadFrom.Excel(2, 1 , "Register"));
			Print("Mobile number is entered as : " + ReadFrom.Excel(2, 1 , "Register"));
		} 
		catch (Exception e) {

			PrintError("Email and Mobile number is not filled");
			ExtentCucumberAdapter.addTestStepLog("Email and Mobile number is not filled successfully");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User Clicks the continue button")
	public void user_clicks_the_continue_button() throws Throwable {

		try {
			if(getElement("ContinueButton", RegisterPageLocators).isDisplayed()) {
				Click("ContinueButton", RegisterPageLocators);
				ExtentCucumberAdapter.addTestStepLog("Continue button is clicked");
				Print("Continue button is clicked");
			}
		}	
		catch (Exception e) {
			PrintError("Continue button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Continue button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	@Then("User should see the basic details popup")
	public void user_should_see_the_basic_details_popup() throws Throwable {

		try {

			WaitForTheElement("BasicDetailsPopup", RegisterPageLocators);
			if(getElement("BasicDetailsPopup", RegisterPageLocators).isDisplayed()) {
				Print("Basic details popup is displayed");
				ExtentCucumberAdapter.addTestStepLog("Basic details popup is displayed");
			}

		} 	

		catch (Exception e) {
			PrintError("Basic details popup is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Basic details popup is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User fills the basic details and clicks continue button")
	public void user_fills_the_basic_details_and_clicks_continue_button() throws Throwable {



		try {
			Wait(2000);
			Waitfortheelement("FirstName", RegisterPageLocators);


			TypeDataInTheField("FirstName", RegisterPageLocators, ReadFrom.Excel(3, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("First name is entered as : " + ReadFrom.Excel(3, 1 , "Register"));
			Print("First name is entered as : " + ReadFrom.Excel(3, 1 , "Register"));



			Waitfortheelement("LastName", RegisterPageLocators);
			TypeDataInTheField("LastName", RegisterPageLocators, ReadFrom.Excel(4, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Last name is entered as : " + ReadFrom.Excel(4, 1 , "Register"));
			Print("Last name is entered as : " + ReadFrom.Excel(4, 1 , "Register"));


			ScrollDown();
			ExtentCucumberAdapter.addTestStepLog("Scroll down to continue button");


			Click("ContinueButton", RegisterPageLocators);
			ExtentCucumberAdapter.addTestStepLog("Continue button is clicked");
			Print("Continue button is clicked");

		}


		catch (Exception e) {
			PrintError("Basic details are not filled");
			ExtentCucumberAdapter.addTestStepLog("Basic details are not filled");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

		try {

			if(getElement("Autofill", RegisterPageLocators).isDisplayed()) {
				ExtentCucumberAdapter.addTestStepLog("Error message : Mandatory feilds to be filled : is displayed");
				Print("Error message : Mandatory feilds to be filled : is displayed");


				MoveToElement("CompanyName", RegisterPageLocators);
				ExtentCucumberAdapter.addTestStepLog("Moved to company name feild");

				TypeDataInTheField("CompanyName", RegisterPageLocators, ReadFrom.Excel(7, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("Company name is entered as : " + ReadFrom.Excel(7, 1 , "Register"));
				Print("Company name is entered as : " + ReadFrom.Excel(7, 1 , "Register"));



				TypeDataInTheField("City", RegisterPageLocators, ReadFrom.Excel(10, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("City is entered as : " + ReadFrom.Excel(10, 1 , "Register"));
				Print("City is entered as : " + ReadFrom.Excel(10, 1 , "Register"));



				TypeDataInTheField("State", RegisterPageLocators, ReadFrom.Excel(11, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("State is entered as : " + ReadFrom.Excel(11, 1 , "Register"));
				Print("State is entered as : " + ReadFrom.Excel(11, 1 , "Register"));



				TypeDataInTheField("Country", RegisterPageLocators, ReadFrom.Excel(12, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("Country is entered as : " + ReadFrom.Excel(12, 1 , "Register"));
				Print("Country is entered as : " + ReadFrom.Excel(12, 1 , "Register"));




				TypeDataInTheField("Website", RegisterPageLocators, ReadFrom.Excel(14, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("Website is entered as : " + ReadFrom.Excel(14, 1 , "Register"));
				Print("Website is entered as : " + ReadFrom.Excel(14, 1 , "Register"));


				TypeDataInTheField("CompanyAddress", RegisterPageLocators, ReadFrom.Excel(8, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("Company address is entered as : " + ReadFrom.Excel(8, 1 , "Register"));
				Print("Company address is entered as : " + ReadFrom.Excel(8, 1 , "Register"));


				ClickEnter();



				ScrollDown();
				ExtentCucumberAdapter.addTestStepLog("Scrolled down to continue button");
				Print("Scrolled down to continue button");

				Wait(2000);
				TypeDataInTheField("ZipCode", RegisterPageLocators, ReadFrom.Excel(13, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("ZipCode is entered as : " + ReadFrom.Excel(13, 1 , "Register"));
				Print("ZipCode is entered as : " + ReadFrom.Excel(13, 1 , "Register"));



				Click("ContinueButton", RegisterPageLocators);
				ExtentCucumberAdapter.addTestStepLog("ZContinue button is clicked");
				Print("ZContinue button is clicked");


			}


		} catch (Exception e) {
			Print("Company address Auto-Filled");
			ExtentCucumberAdapter.addTestStepLog("Company address Auto-Filled");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}







	}

	@Then("User should see the project details popup")
	public void user_should_see_the_project_details_popup() throws Throwable {
		try {

			WaitForTheElement("ProjectDetailsPopup", RegisterPageLocators);
			if(getElement("ProjectDetailsPopup", RegisterPageLocators).isDisplayed()) {
				Print("Project details popup is displayed");
				ExtentCucumberAdapter.addTestStepLog("Project details popup is displayed");


			}

		} catch (Exception e) {

			PrintError("Project details popup is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Project details popup is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}


	@Given("User fills the project name and address")
	public void user_fills_the_project_name_and_address() throws Throwable {

		try {

			TypeDataInTheField("ProjectName", RegisterPageLocators, ReadFrom.Excel(5, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Project name is entered as : " + ReadFrom.Excel(5, 1 , "Register"));
			Print("Project name is entered as : " + ReadFrom.Excel(5, 1 , "Register"));


			Clear("ProjectAddress", RegisterPageLocators);
			ExtentCucumberAdapter.addTestStepLog("Project address is cleared");

			TypeDataInTheField("ProjectAddress", RegisterPageLocators, ReadFrom.Excel(6, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Project address is entered as : " + ReadFrom.Excel(6, 1 , "Register"));
			Print("Project address is entered as : " + ReadFrom.Excel(6, 1 , "Register"));

			ClickEnter();
			Thread.sleep(2000);




		} catch (Exception e) {
			PrintError("Project details are not filled");
			ExtentCucumberAdapter.addTestStepLog("Project details are not filled");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@And("User click next button")
	public void user_click_next_button() throws Throwable {


		try {

			Waitfortheelement("NextButton", RegisterPageLocators);
			Click("NextButton", RegisterPageLocators);
			ExtentCucumberAdapter.addTestStepLog("Next button is clicked");
			Print("Next button is clicked");


		}
		catch (Exception e) {
			PrintError("Next button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Next button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Then("User should see the subscription plan page")
	public void user_should_see_the_subscription_plan_page() throws Throwable {


		try {


			Wait(2000);

			WaitForTheElement("SubcriptionPage", RegisterPageLocators);
			if(getElement("SubcriptionPage", RegisterPageLocators).isDisplayed()) {
				Print("Subcription page is displayed");
				ExtentCucumberAdapter.addTestStepLog("Subcription page is displayed");


			}

		}
		catch (Exception e) {
			PrintError("Subcription page is not displayed");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Subcription page is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User selects the subscription plan")
	public void user_selects_the_subscription_plan() throws Throwable {


		try {
			ScrollDown();
			Registeration.SelectPlan(ReadFrom.Excel(17, 0, "Register"));
			ExtentCucumberAdapter.addTestStepLog("Plan is selected as : " + (ReadFrom.Excel(17, 0, "Register")));

			Print("Plan selected : " + ReadFrom.Excel(17, 0, "Register"));
		}
		catch (Exception e) {
			PrintError("Plan is not selected");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Project details are not filled");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}



	}

	@Then("User should redirected to the login page")
	public void user_should_redirected_to_the_login_page() throws Throwable {

		try {



			if(getElement("Email", LoginPageLocators).isDisplayed()) {
				Print("User redirected to the login page after selecting the plan");
				ExtentCucumberAdapter.addTestStepLog("User redirected to the login page after selecting the plan");
			}

		} 

		catch (Exception e) {

			PrintError("User not redirected to the login page");
			ExtentCucumberAdapter.addTestStepLog("User not redirected to the login page after selecting the plan");
			ExtentCucumberAdapter.addTestStepLog("User may have selected enterprise plan");
			Print("User not redirected to the login page after selecting the plan");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

}
