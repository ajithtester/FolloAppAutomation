package com.folloit.stepdefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.baseclass.Login;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_01_Login extends Baseclass {
	
	@AfterStep("@Regression")
	public void ScreenShot(Scenario scenario) {

	
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Refer the Screenshot"); 

	}
	
	@Given("User launching the web url")
	public void user_launching_the_web_url() throws Throwable {
	    
		
		try {

			LaunchTheDriver("Chrome", "URL", AppProperties);
			
			String Title =	PageTitle();
		
			
			if(softassert(Title , "Follow")) {

			
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

	@And("User clicks the Login button")
	public void user_clicks_the_login_button() throws Throwable {
	    
		
		try {

			Click("LoginButton", LoginPageLocators);
			System.out.println("Login button is clicked");

		} catch (Exception e) {
			System.err.println("Login button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Login button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	   
	}

	@Then("User should see login page")
	public void user_should_see_login_page() throws Throwable {
	    
		try {

	Thread.sleep(2000);

			if(getElement("Email", LoginPageLocators).isDisplayed()) {
	
//			String Con =	GetText("Email", LoginPageLocators);
//			System.out.println(Con);
//			String Con2 = "Mendal";
//			softassert(Con, Con2);
				System.out.println("Login page is displayed");
				ExtentCucumberAdapter.addTestStepLog("Login page is displayed");
			
				//Assert.assertEquals(Con2, Con);
			}
			
		

		} 

		catch (Exception e) {

			System.err.println("Login page is not displayed");
			ExtentCucumberAdapter.addTestStepLog("Login page is not displayed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			System.out.println(e.getMessage());
			//Assert.assertFalse(true);

		}
		
	   
	}

	@Given("User enter mail Id and password")
	public void user_enter_mail_id_and_password() throws Throwable {
	    
		
		try {

			TypeDataInTheField("Email", LoginPageLocators, ReadDataFrom(0, 1 , "Login"));
			ExtentCucumberAdapter.addTestStepLog("EmailId is entered as : " + ReadDataFrom(0, 1 , "Login"));
			System.out.println("EmailId is entered as : " + ReadDataFrom(0, 1 , "Login"));

			TypeDataInTheField("Password", LoginPageLocators, ReadDataFrom(1, 1 , "Login"));
			ExtentCucumberAdapter.addTestStepLog("Password is selected as : " + ReadDataFrom(1, 1 , "Login"));
			System.out.println("Password is selected as : " + ReadDataFrom(1, 1 , "Login"));

			
		} 
		catch (Exception e) {

			System.err.println("Email and Mobile number is not filled");
			ExtentCucumberAdapter.addTestStepLog("Email and Mobile number is not filled successfully");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
		
	}

	@Then("User should see the login success message")
	public void user_should_see_the_login_success_message() throws Throwable {
	    
	   
		
		try {

			
			Login.Loginsucces();
//		WebElement s = 	
			//test();
			System.out.println("Login successfull");
//			if(getElement("LoginSuccess", LoginPageLocators).isDisplayed()) {
//				Click("LoginSuccess", LoginPageLocators);
//				System.out.println("Login successfull");
//				ExtentCucumberAdapter.addTestStepLog("Login successfull");
//			}

		} 	

		catch (Exception e) {
			System.err.println("Login failed");
			ExtentCucumberAdapter.addTestStepLog("Login failed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
			System.out.println(e.getMessage());

		}
		
		
	}
	

}
