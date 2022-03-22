package com.folloit.stepdefinition.sp1;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.*;
import com.follo.excel.read.ReadFrom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_01_Login extends Baseclass {



	@Given("User launching the web url")
	public void user_launching_the_web_url() throws Throwable {


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

	@And("User clicks the Login button")
	public void user_clicks_the_login_button() throws Throwable {


		try {
			if(getElement("LoginButton", LoginPageLocators).isDisplayed()) {
				Click("LoginButton", LoginPageLocators);
				System.out.println("Login button is clicked");
			}
		} catch (Exception e) {
			System.err.println("Login button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Login button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Then("User should see login page")
	public void user_should_see_login_page() throws Throwable {

		try {

			Wait(2000);

			if(getElement("Email", LoginPageLocators).isDisplayed()) {
				System.out.println("Login page is displayed");
				ExtentCucumberAdapter.addTestStepLog("Login page is displayed");

			}
			else {
				System.err.println("Email field is not displayed");
				ExtentCucumberAdapter.addTestStepLog("Email field is not displayed");
			}



		} 

		catch (Exception e) {

			System.err.println("Login page is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Login page is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());



		}


	}

	@Given("User enter mail Id and password")
	public void user_enter_mail_id_and_password() throws Throwable {


		try {

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(0, 1 , "Login"));
			ExtentCucumberAdapter.addTestStepLog("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Login"));
			System.out.println("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Login"));

			TypeDataInTheField("Password", LoginPageLocators, ReadFrom.Excel(1, 1 , "Login"));
			ExtentCucumberAdapter.addTestStepLog("Password is selected as : " + ReadFrom.Excel(1, 1 , "Login"));
			System.out.println("Password is selected as : " + ReadFrom.Excel(1, 1 , "Login"));


		} 
		catch (Exception e) {

			System.err.println("Email and Mobile number is not filled");
			ExtentCucumberAdapter.addTestStepLog("Email and Mobile number is not filled successfully");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			System.out.println(e.getMessage());

		}

	}

	@Then("User should see the login success message")
	public void user_should_see_the_login_success_message() throws Throwable {



		try {

			Login.Loginsucces();

			if(getElement("LoginSuccess", LoginPageLocators).isDisplayed()) {
				System.out.println("Dashboard is displayed : Login passed");
				ExtentCucumberAdapter.addTestStepLog("Dashboard is displayed : Login passed");
			}
			else {
				System.err.println("Dashboard is not displayed ");
				ExtentCucumberAdapter.addTestStepLog("Dashboard is not displayed");
			}

		} 	

		catch (Exception e) {
			System.err.println("Login failed");
			ExtentCucumberAdapter.addTestStepLog("Login failed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			System.out.println(e.getMessage());

		}


	}

	@Given("User clicks forgot password")
	public void user_clicks_forgot_password() throws Throwable {

		try {

			if(getElement("ForgotPassword", LoginPageLocators).isDisplayed()) {
				Click("ForgotPassword", LoginPageLocators);
				System.out.println("Forgot password is dispayed and it is clicked");
				ExtentCucumberAdapter.addTestStepLog("Forgot password is dispayed and it is clicked");
			}

		} 

		catch (Exception e) {

			System.err.println("Forgot password is not clicked");

			ExtentCucumberAdapter.addTestStepLog("Forgot password is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User enters mailId in the email feild")
	public void user_enters_mail_id_in_the_email_feild() throws Throwable {

		try {

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(0, 1 , "Login"));
			ExtentCucumberAdapter.addTestStepLog("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Login"));
			System.out.println("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Login"));

		} 
		catch (Exception e) {

			System.err.println("EmailId is not entered");

			ExtentCucumberAdapter.addTestStepLog("EmailId is not entered");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@And("User clicks the submit button")
	public void user_clicks_the_submit_button() throws Throwable {


		try {
			if(getElement("SubmitButton", LoginPageLocators).isDisplayed()) {
				Click("SubmitButton", LoginPageLocators);
				System.out.println("SubmitButton button is clicked");
			}
		} catch (Exception e) {
			System.err.println("SubmitButton button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("SubmitButton button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Then("User should success message")
	public void user_should_success_message() throws Throwable {

		try {
			WaitForTheElement("MailSentMessage", LoginPageLocators);
			if(getElement("MailSentMessage", LoginPageLocators).isDisplayed()) {
				Click("MailSentMessage", LoginPageLocators);
				System.out.println("Mail sent popup is dispayed");
				ExtentCucumberAdapter.addTestStepLog("Mail sent popup is dispayed");
			}

		} 

		catch (Exception e) {

			System.err.println("Mail sent popup is not dispayed");

			ExtentCucumberAdapter.addTestStepLog("Mail sent popup is not dispayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}


}
