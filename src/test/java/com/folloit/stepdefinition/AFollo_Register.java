package com.folloit.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.baseclass.Registeration;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AFollo_Register extends Baseclass {


	@AfterStep("@Register")
	public void ScreenShot(Scenario scenario) throws Throwable {

		Thread.sleep(3000);
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Refer the Screenshot"); 

	}


	@Given("User launching the app url")
	public void user_launching_the_app_url() throws Throwable {

		try {

			LaunchTheDriver("Chrome", "URL", AppProperties);

			if(getElement("GetStarted", RegisterPageLocators).isDisplayed()) {
				System.out.println("Application launched successfully");
				ExtentCucumberAdapter.addTestStepLog("Application launched successfully");
			}

		} 

		catch (Exception e) {

			System.err.println("Application launched failed");
			ExtentCucumberAdapter.addTestStepLog("Application launched failed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User clicks the get-started button")
	public void user_clicks_the_get_started_button() throws Throwable {

		try {

			Click("GetStarted", RegisterPageLocators);
			System.out.println("Get Started button is clicked");

		} catch (Exception e) {
			System.err.println("Get Started button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Get Started button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Then("User should see welcome popup")
	public void user_should_see_welcome_popup() throws Throwable {


		try {

			if(getElement("EmailId", RegisterPageLocators).isDisplayed()) {
				System.out.println("Welcome popup opened");
				ExtentCucumberAdapter.addTestStepLog("Welcome popup opened");
			}
		} 
		catch (Exception e) {
			System.err.println("Welcome popup not opened");
			ExtentCucumberAdapter.addTestStepLog("Welcome popup not opened");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	@Given("User enter mail Id and Phone number")
	public void user_enter_mail_id_and_phone_number() throws Throwable {

		try {

			TypeDataInTheField("EmailId", RegisterPageLocators, ReadDataFrom(0, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("EmailId is entered as : " + ReadDataFrom(0, 1 , "Register"));
			System.out.println("EmailId is entered as : " + ReadDataFrom(0, 1 , "Register"));

			SelectFromDropdown("PhoneCode", RegisterPageLocators, ReadDataFrom(1, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Phonecode is selected as : " + ReadDataFrom(1, 1 , "Register"));
			System.out.println("Phonecode is selected as : " + ReadDataFrom(1, 1 , "Register"));

			TypeDataInTheField("Mobile", RegisterPageLocators, ReadDataFrom(2, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Mobile number is entered as : " + ReadDataFrom(2, 1 , "Register"));
			System.out.println("Mobile number is entered as : " + ReadDataFrom(2, 1 , "Register"));
		} 
		catch (Exception e) {

			System.err.println("Email and Mobile number is not filled");
			ExtentCucumberAdapter.addTestStepLog("Email and Mobile number is not filled successfully");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@And("User Clicks the continue button")
	public void user_clicks_the_continue_button() throws Throwable {

		try {

			Click("ContinueButton", RegisterPageLocators);
			ExtentCucumberAdapter.addTestStepLog("Continue button is clicked");
			System.out.println("Continue button is clicked");

		}	
		catch (Exception e) {
			System.err.println("Continue button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Continue button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	@Then("User should see the basic details popup")
	public void user_should_see_the_basic_details_popup() throws Throwable {

		try {

			WaitForTheElement("BasicDetailsPopup", RegisterPageLocators);
			if(getElement("BasicDetailsPopup", RegisterPageLocators).isDisplayed()) {
				System.out.println("Basic details popup is displayed");
				ExtentCucumberAdapter.addTestStepLog("Basic details popup is displayed");
			}

		} 	

		catch (Exception e) {
			System.err.println("Basic details popup is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Basic details popup is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User fills the basic details and clicks continue button")
	public void user_fills_the_basic_details_and_clicks_continue_button() throws Throwable {



		try {
			Thread.sleep(2000);
			Waitfortheelement("FirstName", RegisterPageLocators);


			TypeDataInTheField("FirstName", RegisterPageLocators, ReadDataFrom(3, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("First name is entered as : " + ReadDataFrom(3, 1 , "Register"));
			System.out.println("First name is entered as : " + ReadDataFrom(3, 1 , "Register"));



			Waitfortheelement("LastName", RegisterPageLocators);
			TypeDataInTheField("LastName", RegisterPageLocators, ReadDataFrom(4, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Last name is entered as : " + ReadDataFrom(4, 1 , "Register"));
			System.out.println("Last name is entered as : " + ReadDataFrom(4, 1 , "Register"));


			ScrollDown();
			ExtentCucumberAdapter.addTestStepLog("Scroll down to continue button");


			Click("ContinueButton", RegisterPageLocators);
			ExtentCucumberAdapter.addTestStepLog("Continue button is clicked");
			System.out.println("Continue button is clicked");

		}


		catch (Exception e) {
			System.err.println("Basic details are not filled");
			ExtentCucumberAdapter.addTestStepLog("Basic details are not filled");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

		try {

			if(getElement("Autofill", RegisterPageLocators).isDisplayed()) {
				ExtentCucumberAdapter.addTestStepLog("Error message : Mandatory feilds to be filled : is displayed");
				System.out.println("Error message : Mandatory feilds to be filled : is displayed");


				MoveToElement("CompanyName", RegisterPageLocators);
				ExtentCucumberAdapter.addTestStepLog("Moved to company name feild");

				TypeDataInTheField("CompanyName", RegisterPageLocators, ReadDataFrom(7, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("Company name is entered as : " + ReadDataFrom(7, 1 , "Register"));
				System.out.println("Company name is entered as : " + ReadDataFrom(7, 1 , "Register"));

				//Thread.sleep(2000);

				TypeDataInTheField("City", RegisterPageLocators, ReadDataFrom(10, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("City is entered as : " + ReadDataFrom(10, 1 , "Register"));
				System.out.println("City is entered as : " + ReadDataFrom(10, 1 , "Register"));

				//Thread.sleep(2000);

				TypeDataInTheField("State", RegisterPageLocators, ReadDataFrom(11, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("State is entered as : " + ReadDataFrom(11, 1 , "Register"));
				System.out.println("State is entered as : " + ReadDataFrom(11, 1 , "Register"));

				//Thread.sleep(2000);

				TypeDataInTheField("Country", RegisterPageLocators, ReadDataFrom(12, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("Country is entered as : " + ReadDataFrom(12, 1 , "Register"));
				System.out.println("Country is entered as : " + ReadDataFrom(12, 1 , "Register"));

				//Thread.sleep(2000);


				TypeDataInTheField("Website", RegisterPageLocators, ReadDataFrom(14, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("Website is entered as : " + ReadDataFrom(14, 1 , "Register"));
				System.out.println("Website is entered as : " + ReadDataFrom(14, 1 , "Register"));


				TypeDataInTheField("CompanyAddress", RegisterPageLocators, ReadDataFrom(8, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("Company address is entered as : " + ReadDataFrom(8, 1 , "Register"));
				System.out.println("Company address is entered as : " + ReadDataFrom(8, 1 , "Register"));

				//Thread.sleep(2000);
				ClickEnter();

				//TypeDataInTheField("AddressLine", Register, ReadDataFrom(9, 1 , "Register"));
				//Thread.sleep(2000);

				ScrollDown();
				ExtentCucumberAdapter.addTestStepLog("Scrolled down to continue button");
				System.out.println("Scrolled down to continue button");

				TypeDataInTheField("ZipCode", RegisterPageLocators, ReadDataFrom(13, 1 , "Register"));
				ExtentCucumberAdapter.addTestStepLog("ZipCode is entered as : " + ReadDataFrom(13, 1 , "Register"));
				System.out.println("ZipCode is entered as : " + ReadDataFrom(13, 1 , "Register"));

				//Thread.sleep(2000);

				Click("ContinueButton", RegisterPageLocators);
				ExtentCucumberAdapter.addTestStepLog("ZContinue button is clicked");
				System.out.println("ZContinue button is clicked");


			}


		} catch (Exception e) {
			System.out.println("Email domain already registered");
			ExtentCucumberAdapter.addTestStepLog("Email domain already registered");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}







	}

	@Then("User should see the project details popup")
	public void user_should_see_the_project_details_popup() throws Throwable {
		try {

			WaitForTheElement("ProjectDetailsPopup", RegisterPageLocators);
			if(getElement("ProjectDetailsPopup", RegisterPageLocators).isDisplayed()) {
				System.out.println("Project details popup is displayed");
				ExtentCucumberAdapter.addTestStepLog("Project details popup is displayed");


			}

		} catch (Exception e) {

			System.err.println("Project details popup is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Project details popup is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}


	@Given("User fills the project name and address")
	public void user_fills_the_project_name_and_address() throws Throwable {

		try {

			TypeDataInTheField("ProjectName", RegisterPageLocators, ReadDataFrom(5, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Project name is entered as : " + ReadDataFrom(5, 1 , "Register"));
			System.out.println("Project name is entered as : " + ReadDataFrom(5, 1 , "Register"));


			Clear("ProjectAddress", RegisterPageLocators);
			ExtentCucumberAdapter.addTestStepLog("Project address is cleared");

			TypeDataInTheField("ProjectAddress", RegisterPageLocators, ReadDataFrom(6, 1 , "Register"));
			ExtentCucumberAdapter.addTestStepLog("Project address is entered as : " + ReadDataFrom(6, 1 , "Register"));
			System.out.println("Project address is entered as : " + ReadDataFrom(6, 1 , "Register"));

			ClickEnter();
			Thread.sleep(2000);




		} catch (Exception e) {
			System.err.println("Project details are not filled");
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
			System.out.println("Next button is clicked");


		}
		catch (Exception e) {
			System.err.println("Next button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Next button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Then("User should see the subscription plan page")
	public void user_should_see_the_subscription_plan_page() throws Throwable {


		try {


			Thread.sleep(2000);

			WaitForTheElement("SubcriptionPage", RegisterPageLocators);
			if(getElement("SubcriptionPage", RegisterPageLocators).isDisplayed()) {
				System.out.println("Subcription page is displayed");
				ExtentCucumberAdapter.addTestStepLog("Subcription page is displayed");


			}

		}
		catch (Exception e) {
			System.err.println("Subcription page is not displayed");
			System.err.println(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Subcription page is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User selects the subscription plan")
	public void user_selects_the_subscription_plan() throws Throwable {


		try {
			ScrollDown();
			Registeration.SelectPlan(ReadDataFrom(17, 0, "Register"));
			ExtentCucumberAdapter.addTestStepLog("Plan is selected as : " + (ReadDataFrom(17, 0, "Register")));

			System.out.println("Plan selected : " + ReadDataFrom(17, 0, "Register"));
		}
		catch (Exception e) {
			System.err.println("Plan is not selected");
			System.err.println(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Project details are not filled");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}



	}

	@Then("User should redirected to the login page")
	public void user_should_redirected_to_the_login_page() throws Throwable {

		try {



			if(getElement("Email", LoginPageLocators).isDisplayed()) {
				System.out.println("Login page is displayed");
				ExtentCucumberAdapter.addTestStepLog("Login page is displayed");
			}

		} 

		catch (Exception e) {

			System.err.println("Login page is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Login page is not displayed");
			ExtentCucumberAdapter.addTestStepLog("User may have selected enterprise plan");
			System.out.println("User may have selected enterprise plan");

			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

}
