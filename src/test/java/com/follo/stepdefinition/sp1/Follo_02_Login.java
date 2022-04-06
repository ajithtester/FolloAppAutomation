package com.follo.stepdefinition.sp1;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.browser.launch.BrowserLaunch;
import com.follo.module.method.*;
import com.follo.excel.read.ReadFrom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_02_Login extends Baseclass {



	@Given("User launching the web url")
	public void user_launching_the_web_url() throws Throwable {


		try {

			BrowserLaunch.LaunchTheAppURL("URL", AppProperties);

			String ActualTitle =	PageTitle();		
			String ExpectedTitle =	PropertyFile("PageTitle", AppProperties);

			if(IsEqual(ActualTitle, ExpectedTitle)) {

				Print("Page title is : " + ActualTitle );
				ExtentCucumberAdapter.addTestStepLog("Page title is : " + ActualTitle );

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

			if(IsElementDisplayed("LoginButton", LoginPageLocators)) {
				Click("LoginButton", LoginPageLocators);
				Print("Login button is clicked");
			}
		} catch (Exception e) {
			PrintError("Login button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Login button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@Then("User should see login page")
	public void user_should_see_login_page() throws Throwable {

		try {

			Wait(2000);

			if(IsElementDisplayed("Email", LoginPageLocators)) {
				Print("Login page is displayed");
				ExtentCucumberAdapter.addTestStepLog("Login page is displayed");

			}
			else {
				PrintError("Email field is not displayed");
				ExtentCucumberAdapter.addTestStepLog("Email field is not displayed");
			}



		} 

		catch (Exception e) {

			PrintError("Login page is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Login page is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());



		}


	}

	@Given("User enter mail Id and password")
	public void user_enter_mail_id_and_password() throws Throwable {


		try {

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(0, 1 , ReadFrom.Login));
			ExtentCucumberAdapter.addTestStepLog("EmailId is entered as : " + ReadFrom.Excel(0, 1 , ReadFrom.Login));
			Print("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Login"));

			TypeDataInTheField("Password", LoginPageLocators, ReadFrom.Excel(1, 1 , "Login"));
			ExtentCucumberAdapter.addTestStepLog("Password is selected as : " + ReadFrom.Excel(1, 1 , ReadFrom.Login));
			Print("Password is selected as : " + ReadFrom.Excel(1, 1 , "Login"));


		} 
		catch (Exception e) {

			PrintError("Email and Mobile number is not filled");
			ExtentCucumberAdapter.addTestStepLog("Email and Mobile number is not filled successfully");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			PrintError(e.getMessage());

		}

	}

	@Then("User should see the login success message")
	public void user_should_see_the_login_success_message() throws Throwable {



		try {

			F_02_Login.Loginsucces();

			if(IsElementDisplayed("LoginSuccess", LoginPageLocators)) {
				Print("Dashboard is displayed : Login passed");
				ExtentCucumberAdapter.addTestStepLog("Dashboard is displayed : Login passed");
			}
			else {
				Print("Dashboard is not displayed ");
				ExtentCucumberAdapter.addTestStepLog("Dashboard is not displayed");
			}

		} 	

		catch (Exception e) {
			PrintError("Login failed");
			ExtentCucumberAdapter.addTestStepLog("Login failed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			PrintError(e.getMessage());

		}


	}

	@Given("User clicks forgot password")
	public void user_clicks_forgot_password() throws Throwable {

		try {

			if(IsElementDisplayed("ForgotPassword", LoginPageLocators)) {
				Click("ForgotPassword", LoginPageLocators);
				Print("Forgot password is dispayed and it is clicked");
				ExtentCucumberAdapter.addTestStepLog("Forgot password is dispayed and it is clicked");
			}

		} 

		catch (Exception e) {

			PrintError("Forgot password is not clicked");

			ExtentCucumberAdapter.addTestStepLog("Forgot password is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User enters mailId in the email feild")
	public void user_enters_mail_id_in_the_email_feild() throws Throwable {

		try {

			TypeDataInTheField("email", LoginPageLocators, ReadFrom.Excel(0, 1 , ReadFrom.Login));
			ExtentCucumberAdapter.addTestStepLog("EmailId is entered as : " + ReadFrom.Excel(0, 1 , ReadFrom.Login));
			Print("EmailId is entered as : " + ReadFrom.Excel(0, 1 , "Login"));

		} 
		catch (Exception e) {

			PrintError("EmailId is not entered");

			ExtentCucumberAdapter.addTestStepLog("EmailId is not entered");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}


	}

	@And("User clicks the submit button")
	public void user_clicks_the_submit_button() throws Throwable {


		try {
			if(IsElementDisplayed("SubmitButton", LoginPageLocators)) {
				Click("SubmitButton", LoginPageLocators);
				Print("SubmitButton button is clicked");
				ExtentCucumberAdapter.addTestStepLog("SubmitButton button is clicked");
				
			}
		} catch (Exception e) {
			PrintError("SubmitButton button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("SubmitButton button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Then("User should success message")
	public void user_should_success_message() throws Throwable {

		try {
			WaitForTheElement("MailSentMessage", LoginPageLocators);
			if(IsElementDisplayed("MailSentMessage", LoginPageLocators)) {
				Click("MailSentMessage", LoginPageLocators);
				Print("Mail sent popup is dispayed");
				ExtentCucumberAdapter.addTestStepLog("Mail sent popup is dispayed");
			}

		} 

		catch (Exception e) {

			PrintError("Mail sent popup is not dispayed");

			ExtentCucumberAdapter.addTestStepLog("Mail sent popup is not dispayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}


}
