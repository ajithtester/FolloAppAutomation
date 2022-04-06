package com.follo.stepdefinition.sp2;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.follo.baseclass.Baseclass;
import com.follo.module.method.F_03_DFOW;
import com.follo.module.method.F_04_Companies;
import com.follo.module.method.F_05_Members;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Follo_05_Members extends Baseclass {


	@Given("User clicks members button")
	public void user_clicks_members_button() throws Throwable {


		try {


			if(IsElementDisplayed("MembersButton", MembersLocators)){
				Click("MembersButton", MembersLocators);
				Print("Members button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Members button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Members button is not clicked");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Members button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}



	@And("User enters invite members button")
	public void user_enters_invite_members_button() throws Throwable {

		try {

			if(IsElementDisplayed("InviteMembers", MembersLocators)){
				Click("InviteMembers", MembersLocators);
				Print("Invite members button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Invite members button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Invite members button is not clicked");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Invite members button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	@And("User enters members mailid")
	public void user_enters_members_mailid() throws Throwable {

		try {

			F_05_Members.InviteMembers();
		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}

	@And("User assign company and role to the member")
	public void user_assign_company_and_role_to_the_member() throws Throwable {

		try {

			F_05_Members.SelectCompany();
		} 
		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	@And("User clicks send invite button")
	public void user_clicks_send_invite_button() throws Throwable {


		try {
			MoveToElement("SendInvitesButton", MembersLocators);
			if(IsElementDisplayed("SendInvitesButton", MembersLocators)){
				Click("SendInvitesButton", MembersLocators);
				Print("Send invites button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Send invites button is clicked");

			}
		} 
		catch (Exception e) {
			PrintError("Send invites button is not clicked");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Send invites button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	@Then("User should see the invite sent success message")
	public void user_should_see_the_invite_sent_success_message() throws Throwable {

		try {
			F_05_Members.InviteSentPopup();
			if(IsElementDisplayed("SuccessMessage", MembersLocators)){
				Click("SuccessMessage", MembersLocators);
				Print("Invite sent successfully");
				ExtentCucumberAdapter.addTestStepLog("Invite sent successfully");

			}
		} 
		catch (Exception e) {
			PrintError("Invite sent failed");
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog("Invite sent failed");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}

	}

	@Given("User edit a member from the list")
	public void user_edit_a_member_from_the_list() throws Throwable {
		try {

			F_05_Members.EditMembers();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

	@Given("User search and view the members")
	public void user_search_and_view_the_members() throws Throwable {

		try {
			F_05_Members.SearchMember();
		} 
		catch (Exception e) {

			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}


	}

	@Given("User send reinvites to the pending members")
	public void user_send_reinvites_to_the_pending_members() throws Throwable {


		try {
			F_05_Members.ReInviteMembers();
		} 
		catch (Exception e) {
			
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());
		}
	}


	@Given("User search and filter the company based on company")
	public void user_search_and_filter_the_company_based_on_company() throws Throwable {


		try {

			F_05_Members.FilterMemberOnCompany();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User search and filter the company based on role")
	public void user_search_and_filter_the_company_based_on_role() throws Throwable {

		try {

			F_05_Members.FilterMemberOnRole();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}

	}

	@Given("User deletes a member from the list")
	public void user_deletes_a_member_from_the_list() throws Throwable {


		try {

			F_05_Members.DeleteMembers();
		} 

		catch (Exception e) {
			PrintError(e.getMessage());
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}



	@Given("User selects all members")
	public void user_selects_all_members() throws Throwable {

		try {
			Wait(2000);
			if(IsElementDisplayed("SelectAll", MembersLocators)){
				Click("SelectAll", MembersLocators);
				Print("All members are selected");
				ExtentCucumberAdapter.addTestStepLog("All members are selected");
			}
		} catch (Exception e) {
			PrintError("All members are not selected");
			ExtentCucumberAdapter.addTestStepLog("All members are not selected");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}

	}

	@And("User clicks remove button and click yes from the popup")
	public void user_clicks_remove_button_and_click_yes_from_the_popup() throws Throwable {

		try {
			if(IsElementDisplayed("RemoveButton", MembersLocators)){
				Click("RemoveButton", MembersLocators);
				Wait(2000);
				Click("YesDelete", MembersLocators);


				Print("Remove button is clicked");
				ExtentCucumberAdapter.addTestStepLog("Remove button is clicked");
			}
		} catch (Exception e) {
			PrintError("Remove button is not clicked");
			ExtentCucumberAdapter.addTestStepLog("Remove button is not clicked");
			ExtentCucumberAdapter.addTestStepLog(e.getMessage());


		}
	}

	@Then("All the members except origin member should be deleted")
	public void all_the_members_except_origin_member_should_be_deleted() throws Throwable {


		try {

			F_05_Members.RemoveAll();
		} 

		catch (Exception e) {


			ExtentCucumberAdapter.addTestStepLog(e.getMessage());

		}
	}

}
